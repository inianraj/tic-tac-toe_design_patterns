# tic-tac-toe_design_patterns
A console-based Tic-Tac-Toe game in Java demonstrating the Strategy and State design patterns

I constructed this upon the below rules
• N × N board 
• Two players 
• Win with a horizontal, vertical, or diagonal line 

Design Patterns I used to Build

1. Strategy Design Pattern
Used to distinguish different player behaviour, like Human and AI Play, so it makes the code loosely coupled and makes it easier to extend Easy/Medium/Hard AI Later. 

2. Factory Design Pattern
I considered using Factory for player creation, but for the current implementation, it felt unnecessary since player creation is simple. It can be introduced if the creation logic becomes more complex.

3. State Design Pattern 
I incorporated XTurnState, YTurnState, XWonState, and YWonState to manage turns and game outcomes. Also if we need to add a state like PausedState, it will be easy to extend without violating the Open/Closed Principle.

One Thing I would Improve
I have currently implemented board logic as normal tictactoe board class but in future if I incorporate more board games then rules will be different so in that case I might end up in using strategy design. 

