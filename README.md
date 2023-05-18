# SCC110
Repository for SCC.110 summer term project

My game is the Air Hockey (project option 2) game that works with the latest version of GameArena and it's associated classes. It has the capability of playing the game with accurate collisions and noises, has built-in cheat codes and also has replayability through the main game loop. 

HOW TO RUN WITHOUT IDE:
The main way to run is by opening and typing into the terminal:

'**javac Controller.java**' then '**java Controller**'

once you have downloaded and opened the folder via the terminal (aka use _cd_ to navigate to my folder)

The main window will pop-up with sound pre-enabled. This can be toggled on and off by pressing ENTER for on and SHIFT for off. The status of the sound being on or off is indicated by the colour of the sound text (red - off / green - on). The controls are WASD for player 1 (The player on the left side) and arrow keys for player 2 (The player one the right side). Cheat codes are indicated in a similar fashion, with text at the top, and are used by pressing either 'O' or 'P' for player 1 and 2 respectively. Sound is handled by using 'Runnable' and running the class logic through a seperate thread to prevent the main game logic from lagging. I have adhered to the principles of OOP by using the classes and methods provided as well as creating two new classes and one new constructor to aide in implementation.

KEY INFO:

Window size - 1500 x 1000 

Player 1 controls - WASD (left player)

Player 2 controls - arrow keys (right player)

Player 1 cheat button - O key

Player 2 cheat button - P key

Sound on toggle - ENTER

Sound off toggle - SHIFT

(FIRST TO 6)



