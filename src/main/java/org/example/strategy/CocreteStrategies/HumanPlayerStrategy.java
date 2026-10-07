package org.example.strategy.CocreteStrategies;

import org.example.Utility.Board;
import org.example.Utility.Position;
import org.example.strategy.PlayerStrategy;

import java.util.Scanner;
import java.util.InputMismatchException;

public class HumanPlayerStrategy implements PlayerStrategy {
    private final Scanner sc;
    private final String playerName;

    @Override
    public String getName(){
        return playerName;
    }

    public HumanPlayerStrategy(String playerName, Scanner sc){
        this.sc = sc;
        this.playerName = playerName;
    }

    @Override
    public Position makeMove(Board board) {
        while (true) {
            try {
                System.out.printf(
                        "%s, enter your move (row [0-%d] and column [0-%d]): ",
                        playerName,
                        board.getRows() - 1,
                        board.getColumns() - 1
                );

                int row = sc.nextInt();
                int col = sc.nextInt();

                if (row < 0 || row >= board.getRows()
                        || col < 0 || col >= board.getColumns()) {
                    throw new IllegalArgumentException(
                            "Please enter valid row and column numbers within the board."
                    );
                }

                Position move = new Position(row, col);

                if (!board.isValidMove(move)) {
                    throw new IllegalArgumentException(
                            "That position is already filled. Please choose another position."
                    );
                }

                return move;

            } catch (InputMismatchException e) {
                System.out.println("Please enter row and column as integers.");
                sc.nextLine(); // Discard invalid input.
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
