#-----------------------2048 GAME-----------------------
# COMP2042_CW_hfyai4
#Project Description
2048 is a single-player sliding block puzzle game . This game objective is to slide numbered tiles on a grid to combine them to create a tile with the number 2048. However, one can continue to play the game after reaching the goal, creating tiles with larger numbers.
##Program Workspace
This program is Programmed using InteliJ IDEA.To run the app coursework_fix[run]configuration.

##Code Maintaining
1-Any codes,imports or libraries that have not been used in the game have been deleted.

2-Refactored some functions from one class to another class to decrease size of classes and bs responsible for specific tasks

3-Singleton design pattern has been added in PopUpEndGame and TextMaker class

4-Factory method has been applied interface(CellColorBase) linked to CellColor and CellGreen Class.

5-Changed Switch Case statements in CellColor to Hash Map as it allows arbitrary objects to be associated with other arbitrary objects. This can be very useful for doing things like grouping or joining data together by some common attributes.Also in the future it would be more easier to change color as the code looks cleaner and easier to use and modify.

##Additions
1-Scene Builder has been used and linked to intelliJ to navigate from one menu to another.

2- Made an option to make the user comfortable weather to choose to play as a "Guest" or Sign-Up an email and Login with it to record his/her score.

3- Added a color picker where the user gets to set a color based on his preference in 2048 Login menu , this will apply on the color of cells too, while playing the game. This game can be played by all users even for those who have week eyesight as color changes are under their control now .

4-Sign up button on LoginMenu allows user to Sign up  unique email and password and it gets saved. Later users can log in with it to save his high score to leaderboard.

5-LeaderBoard Button in MainMenu is responsible for recording high scores of the users who registerd an email

6-Help button created to guide the user how the game works.

7-Settings button created to allow user open or close music while playing the game. Game difficulty and Dark theme options will be implemented in the future as game improvement.

8- Quit button allows user to exit game.

9-When user starts the game , color theme will be based on color user chose in LoginMenu or else it will randomly be set to black. In game scene 2 buttons have been added to make user easily return to MainMenu or quit the game.

10-As soon as the game end and the user is out of Moves , a Popup Menu appears displaying that the game is Over and the Score the user achieved. Note that score will never be recorded to leaderboard if you do not register an Account in the Game.




