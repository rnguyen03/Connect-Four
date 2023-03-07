# CIS 2430 Assignment 2

Simple connect four with save and load functionality.

## Description

Upon running the program the user will be asked if they want to load a saved game. If yes then prompt for file name and directory and then laod the gane, if no then start new game. When a board is printed, it will indicate the player turn and turn number. Player 1 ($) will start followed by player 2 (#). The player
can either input a move (1-7) or save the game (8). In the case of save game (8) the user will be promtped for file name and directory. If the file exists then the file will be overwritten and the board will be saved. If it doesn't exist the nit is created. The game continues until a tie or win occur. The users will be prompted to play again. If yes then continue the loop, if no end the program.

## Getting Started

### Dependencies

* Describe any prerequisites, libraries, OS version, etc., needed before installing and running your program.



### Executing program

* How to build and run the program
* Step-by-step bullets
```
run: gradle build
     java -cp build/classes/java/main connectfour.ConnectFour
```
* include the expected output

## Limitations

What isn't done? What things cause errors?
Slight incoveniences such as if the load file is not detected, it defaults to an empty board.
Can't quit game, must finish one in order to end without issues.  

## Author Information
Ryan Nguyen

## Acknowledgments

Inspiration, code snippets, etc.
* [awesome-readme](https://github.com/matiassingers/awesome-readme)
* [simple-readme] (https://gist.githubusercontent.com/DomPizzie/7a5ff55ffa9081f2de27c315f5018afc/raw/d59043abbb123089ad6602aba571121b71d91d7f/README-Template.md)



