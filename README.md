# Project Requirements
## Overview

Develop a console-based Rock, Paper, Scissors game which supports two modes of play. One where a player competes against a computer opponent and one where two computer opponents compete against each other.

Functional Requirements

### 1.  Game Rules:

- The game follows standard Rock, Paper, Scissors rules:

  * Rock beats Scissors

  * Scissors beats Paper

  * Paper beats Rock

- The user selects whether the game is Computer Vs Computer or Computer Vs Human.

  * When in Computer Vs Player mode, the player selects one of the three choices, and the computer randomly selects one.

  * When in Computer Vs Computer mode, the computer randomly selects one of the three choices for both computer players.

- The program determines the winner of each round.

### 2.  Gameplay Flow:

-   Display a welcome message and instructions.

-   Prompt the user to select a game mode, Computer Vs Computer or Computer Vs Human

-   When in Computer Vs Human mode,

    * prompt the user to enter the player’s name

    * prompt the user to select Rock, Paper, or Scissors.

    * Generate a random choice for the computer player(.

-   When in Computer Vs Computer mode,

    * Generate a random choice for the computer player 1

    * Generate a random choice for the computer player 2

-   Determine and display the winner.

-   Allow the player to play multiple rounds or exit the game.

## Technical Requirements

1.  The software should be written following standard Object-Oriented Design principles.

2.  The software should be written in such a way as to make unit testable possible with no modification to the written solution.

    -   Unit tests are not required to be included with the solution

## Additional Considerations

-   Follow clean coding practices (meaningful variable names, well-structured methods).

-   Include appropriate error handling (e.g., invalid user inputs).

-   Use dependency injection where applicable for better testability.

-   Keep the code scalable for potential future enhancements (such as a GUI version).
