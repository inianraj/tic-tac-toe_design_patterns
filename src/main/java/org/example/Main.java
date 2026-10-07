package org.example;

import org.example.Controller.BoardGames;
import org.example.Controller.GameController.TicTacToe;
import org.example.strategy.CocreteStrategies.HumanPlayerStrategy;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        while (true) {
            System.out.println("Please Enter The Board Size in n Format");
            try {
                n = Integer.parseInt(sc.nextLine().trim());
                if (n <= 0) {
                    System.out.println("Board size must be a positive number.");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a positive whole number.");
            } catch (java.util.NoSuchElementException e) {
                System.out.println("No input available. Exiting the game.");
                return;
            }
        }

        System.out.println("Please Enter The Player Name for X Symbol");
        if (!sc.hasNextLine()) return;
        String name1 = sc.nextLine().trim();
        System.out.println("Please Enter The Player Name for O Symbol");
        if (!sc.hasNextLine()) return;
        String name2 = sc.nextLine().trim();
        BoardGames board = new TicTacToe(
                new HumanPlayerStrategy(name1, sc),
                new HumanPlayerStrategy(name2, sc),
                n, n
        );
        board.play();

    }
}
