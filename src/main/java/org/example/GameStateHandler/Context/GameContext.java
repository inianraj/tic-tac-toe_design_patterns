package org.example.GameStateHandler.Context;

import org.example.GameStateHandler.ConcreteState.XTurnState;
import org.example.GameStateHandler.GameState;

public class GameContext {
    private GameState currentsState;
    public GameContext(){
        this.currentsState = new XTurnState();
    }

    public void setState(GameState state){
        this.currentsState = state;
    }

    public GameState getState(){
        return currentsState;
    }

}
