package org.example.Controller.GameController;

import org.example.CommonEnum.GameStatus;
import org.example.CommonEnum.Symbol;
import org.example.Controller.BoardGames;
import org.example.GameStateHandler.ConcreteState.OWonState;
import org.example.GameStateHandler.ConcreteState.XWonState;
import org.example.GameStateHandler.Context.GameContext;
import org.example.GameStateHandler.GameState;
import org.example.Utility.Board;
import org.example.Utility.Player;
import org.example.Utility.Position;
import org.example.strategy.PlayerStrategy;

public class TicTacToe implements BoardGames {
    private final Board board;
    private final Player playerX;
    private final Player playerO;
    private Player currentPlayer;
    private final GameContext gameContext;


    public TicTacToe(PlayerStrategy xStrategy, PlayerStrategy oStrategy,
                     int rows, int columns){

        this.board = new Board(rows, columns);
        this.playerX = new Player(xStrategy, Symbol.X);
        this.playerO = new Player(oStrategy, Symbol.O);
        this.currentPlayer = playerX;
        this.gameContext = new GameContext();
    }

    @Override
    public void play(){
        GameStatus gameStatus = GameStatus.IN_PROGRESS;
        do{
            board.printBoard();
            Position move = currentPlayer.getstrategy().makeMove(board);
            board.makeMove(move, currentPlayer.getSymbol());
            gameStatus = board.checkGameState(currentPlayer);
            if(gameStatus == GameStatus.IN_PROGRESS)
                gameContext.getState().next(gameContext,currentPlayer,false);
            else if (gameStatus == GameStatus.GAME_OVER)
                gameContext.getState().next(gameContext, currentPlayer, true);
            else break;
            if(gameStatus == GameStatus.IN_PROGRESS){
                currentPlayer = (currentPlayer == playerX) ? playerO : playerX;
            }
        }while(gameStatus == GameStatus.IN_PROGRESS);

        announceResult();
    }

    public void announceResult(){
        GameState state = gameContext.getState();
        if(state instanceof XWonState){
            System.out.println(playerX.getName() + " Has WON The Game");
        }else if(state instanceof OWonState){
            System.out.println(playerO.getName() + " Has WON The Game");
        }else{
            System.out.println("The Game Is Draw");
        }
        board.printBoard();
    }
}
