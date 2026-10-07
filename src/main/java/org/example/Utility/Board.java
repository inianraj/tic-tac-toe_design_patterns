package org.example.Utility;
import org.example.CommonEnum.GameStatus;
import org.example.CommonEnum.Symbol;
import org.example.GameStateHandler.Context.GameContext;

public class Board {
    private final int rows;
    private final int columns;
    private final Symbol[][] grid;

    public int getRows(){
        return rows;
    }

    public int getColumns(){
        return columns;
    }

    public Board(int rows, int columns){
        this.rows = rows;
        this.columns = columns;
        this.grid = new Symbol[rows][columns];
        for(int i=0; i<rows; i++){
            for(int j=0; j<columns; j++){
                grid[i][j] = Symbol.EMPTY;
            }
        }
    }

    public boolean isValidMove(Position pos){
        return pos != null &&
                pos.row >= 0 && pos.row < rows &&
                pos.col >= 0 && pos.col < columns &&
                grid[pos.row][pos.col] == Symbol.EMPTY;
    }

    public void makeMove(Position pos, Symbol sym){
        grid[pos.row][pos.col] = sym;
    }

    public void printBoard(){
        for(int i=0; i<rows; i++){
            for(int j=0; j<columns; j++){
                Symbol sy = grid[i][j];
                switch(sy){
                    case X:
                        System.out.print(" X ");
                        break;
                    case O:
                        System.out.print(" O ");
                        break;
                    default:
                        System.out.print(" . ");
                }

                if(j<columns-1)System.out.print("|");
            }
            System.out.println();
            if (i < rows - 1) {
                for (int j = 0; j < columns; j++) {
                    System.out.print("---");

                    if (j < columns - 1) {
                        System.out.print("+");
                    }
                }
                System.out.println();
            }
        }
        System.out.println();
    }

    public GameStatus checkGameState(Player currentPlayer){

       Symbol symbol = currentPlayer.getSymbol();

       if(hasWon(symbol)) return GameStatus.GAME_OVER;
       else {
           for (int i = 0; i < rows; i++) {
               for (int j = 0; j < columns; j++) {
                   if (grid[i][j] == Symbol.EMPTY) return GameStatus.IN_PROGRESS;
               }
           }
       }

       return GameStatus.DRAW;

    }

    private boolean hasWon(Symbol symbol){
        for(int i=0; i<rows;i++){
            if(isWinningLine(grid[i], symbol)) return true;
        }
        for(int i=0; i<columns; i++){
            Symbol[] arr = new Symbol[columns];
            for(int j=0; j<rows; j++){
                arr[j] = grid[j][i];
            }
            if(isWinningLine(arr, symbol)) return true;
        }

        if(rows==columns) {
            Symbol[] diagonal1 = new Symbol[Math.min(rows, columns)];
            Symbol[] diagonal2 = new Symbol[Math.min(rows, columns)];
            for (int i = 0; i < Math.min(rows, columns); i++) {
                diagonal1[i] = grid[i][i];
                diagonal2[i] = grid[i][columns - i - 1];
            }
            if (isWinningLine(diagonal1, symbol)) return true;
            if (isWinningLine(diagonal2, symbol)) return true;
        }

        return false;
    }
    private boolean isWinningLine(Symbol[] line, Symbol symbol){
        for(Symbol sy : line){
            if(!sy.equals(symbol)) return false;
        }
        return true;
    }
}
