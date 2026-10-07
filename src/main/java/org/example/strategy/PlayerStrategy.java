package org.example.strategy;

import org.example.Utility.Board;
import org.example.Utility.Position;

public interface PlayerStrategy {

    Position makeMove(Board board);
    String getName();
}
