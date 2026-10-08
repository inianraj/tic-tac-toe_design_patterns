# Tic-Tac-Toe — Design Patterns

A console-based Tic-Tac-Toe game built in Java, demonstrating the **Strategy** and **State** design patterns.

## Game Rules

The game is built around the following rules:

- N × N board
- Two players
- A player wins by completing a horizontal, vertical, or diagonal line

## Design Patterns Used

### 1. Strategy Design Pattern

Used to distinguish different player behaviours, such as **Human** and **AI** players.

This keeps the code loosely coupled and makes it easier to extend the game with different AI difficulty levels like **Easy, Medium, and Hard** in the future.

### 2. Factory Design Pattern

I considered using the Factory Design Pattern for player creation, but for the current implementation, it felt unnecessary since player creation is simple.

It can be introduced later if the player creation logic becomes more complex.

### 3. State Design Pattern

I incorporated:

- `XTurnState`
- `YTurnState`
- `XWonState`
- `YWonState`

These states are used to manage player turns and game outcomes.

If we need to add another state, such as `PausedState`, it can be added easily without violating the **Open/Closed Principle**.

## One Thing I Would Improve

Currently, I have implemented the board logic specifically for Tic-Tac-Toe.

If I extend this design to support multiple board games in the future, each game could have different rules. In that case, I would consider using the **Strategy Design Pattern** for the game rules as well, so that the board logic is not tightly coupled to Tic-Tac-Toe.
