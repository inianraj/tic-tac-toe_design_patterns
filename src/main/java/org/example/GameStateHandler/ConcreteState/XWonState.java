package org.example.GameStateHandler.ConcreteState;

import org.example.CommonEnum.Symbol;
import org.example.GameStateHandler.Context.GameContext;
import org.example.GameStateHandler.GameState;
import org.example.Utility.Player;

public class XWonState implements GameState {

    @Override
    public  void next(GameContext context, Player player, boolean hasWon){
            //game finished
    }
}
