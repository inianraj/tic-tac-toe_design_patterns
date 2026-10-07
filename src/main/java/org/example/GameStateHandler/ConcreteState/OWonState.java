package org.example.GameStateHandler.ConcreteState;

import org.example.GameStateHandler.Context.GameContext;
import org.example.GameStateHandler.GameState;
import org.example.Utility.Player;

public class OWonState implements GameState {

    @Override
    public  void next(GameContext context, Player player, boolean hasWon){
        //game finished
    }
}
