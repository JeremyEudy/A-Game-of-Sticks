# A-Game-of-Sticks
A simple program for playing pick up sticks with either a player or an AI. The AI can also train itself through a random trial and error system. The AI training program plays against an untrained AI in order to refine its random choice options.

## Getting Started
This is to be run as a Java project in a Java IDE

Easy clone:
```
mkdir -p ~/A-Game-of-Sticks/ && cd
git clone https://github.com/JeremyEudy/A-Game-of-Sticks
```
Or replace ```~/A-Game-of-Sticks/``` with a different valid location

## Usage
From ```/src/```
```
javac -d classes/ files/Game.java files/AIProtocol.java && javac -cp classes/ -d classes/ files/SticksTest.java
cd classes/
java PickupSticks.SticksTest
```
### Author
Jeremy Eudy

### License
This project is licensed under the GPLv2
