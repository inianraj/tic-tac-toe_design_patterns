package org.example.Utility;

import org.example.CommonEnum.Symbol;
import org.example.strategy.PlayerStrategy;

public class Player {
    private final Symbol symbol;
    private final PlayerStrategy strategy;

    public Player(PlayerStrategy strategy, Symbol symbol){
        this.symbol = symbol;
        this.strategy = strategy;
    }

    public PlayerStrategy getstrategy(){
        return strategy;
    }

    public Symbol getSymbol(){
        return symbol;
    }

    public String getName(){
        return strategy.getName();
    }
}
