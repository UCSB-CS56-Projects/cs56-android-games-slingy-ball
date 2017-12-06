# cs56-android-games-slingy-ball

## Introduction
Slingy Ball is an Android port of an existing iOS mobile game. 
The player controls a ball, and their objective is to climb upwards by landing on platforms. 
The player moves the ball by making "shots". You can see how the shot mechanic works in this YouTube video [here](https://www.youtube.com/watch?v=DHGi1dEkDo0&t=90s). 
The player drags their finger on the "control pad ball" on the bottom of the screen. 
When a player lands on a platform, they earn a point, and the next platform will lower on to the screen. 

## Documentation
### Activities
* *MainActivity.java* : The main Activity for the Android app. Contains methods related to score-saving and starting the game.
### Views
*The following classes extend View*
* *GameView.java* : The view that manages the game screen, or the viewing area (the top of the game). Contains methods related to drawing game objects, as well as the physics for collisions.
* *ControlBallView.java* : The view that the player interacts with to make shots. Contains methods related to screen touching.
### Game Objects
* *PlayerBall.java* : The object that bounces around on the GameView. Contains methods related to getting and setting PlayerBall's properties.
* *Platform.java* : The object representing the main obstacle in the game. Contains methods related to getting and setting Platform attributes.
### Threads
* *GameThread.java* : The thread responsible for calculating PlayerBall and Platform movement, and then redrawing them.

## How to Run
Run in simulator through Android Studio or install on phone using Android Studio. 

## Known Bugs and Issues
[Link to Issues Page](https://github.com/UCSB-CS56-Projects/cs56-android-games-slingy-ball/issues)

## F17 final remarks
*Jonathan Chen, Jackson Li*  
Our iteration is the first of this project, and so there are numerous issues, most related to code design. 
However, since it is new, there are a large number of new features and issues for you to work on. 
One of the most beneficial code refactoring opportunities is in creating a *Collidable* interface that platforms, walls, and the eventual powerups can use. 
Initialization sometimes causes frame skips in the beginning of the game. 

Also, play the game to find bugs. 
