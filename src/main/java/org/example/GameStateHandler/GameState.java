package org.example.GameStateHandler;

import org.example.GameStateHandler.Context.GameContext;
import org.example.Utility.Player;

public interface GameState {
    void next(GameContext context, Player player, boolean hasWon);
}
