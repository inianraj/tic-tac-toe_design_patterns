package org.example.GameStateHandler.ConcreteState;

import org.example.CommonEnum.Symbol;
import org.example.GameStateHandler.Context.GameContext;
import org.example.GameStateHandler.GameState;
import org.example.Utility.Player;

public class XTurnState implements GameState {

    @Override
    public  void next(GameContext context, Player player, boolean hasWon){
        if(hasWon){
            context.setState(player.getSymbol() == Symbol.O ? new OWonState() : new XWonState());
        }else{
            context.setState(new OTurnState());
        }
    }
}
