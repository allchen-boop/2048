# 2048

IMPLEMENTATION:

Tile.java:     represents each individual tile object in the game.
  			       It stores methods for getting and setting the value of a
  			       specified tile and drawing the tile.
  	
Board.java:     represents the game board with a 2D array of Tile objects.
                It keeps track of the state of the game board, and it includes methods
                for the game's tile sliding interactions. It also includes methods for
                drawing the board, instruction, and ending screens.
  
GameCourt.java: holds the primary game logic for how different objects
  				      interact with one another.
  				  
Game.java:      main class that specifies the frame and widgets of the GUI.
  			        It includes the main method that starts and runs the game.
  
GameTest.java:  contains all the JUnit tests for my game.
  
Image.java:     gets the png image files that will be displayed to 
  			        visually represent the tiles.


CORE CONCEPTS:

2D Arrays:    2D array of tile objects to represent the state of the board grid.
           
Collections:  linked list of board states to be used in an undo feature.
  	          With each turn the player takes, a 2D array representation of the board grid is 
  	          added to the head of the linked list. When undoing, the current board will then be
  	          replaced by the past board state that was stored on the linked list.
