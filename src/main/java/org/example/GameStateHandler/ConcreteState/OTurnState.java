package org.example.GameStateHandler.ConcreteState;

import org.example.CommonEnum.Symbol;
import org.example.GameStateHandler.Context.GameContext;
import org.example.GameStateHandler.GameState;
import org.example.Utility.Player;

public class OTurnState implements GameState {

    @Override
    public  void next(GameContext context, Player player, boolean hasWon){
        if(hasWon){
            context.setState(player.getSymbol() == Symbol.X ? new XWonState() : new OWonState());
        }else{
            context.setState(new XTurnState());
        }
    }
}
