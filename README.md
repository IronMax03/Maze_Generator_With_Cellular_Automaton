# Maze Generator With Cellular Automaton

## Introduction

This an old project I used as an HelloWorld for my gitHub.
It was in 2020 when I was learning Java. I had a homework which was to create a maze generator. I came up with solution using a [Cellular automaton](https://en.wikipedia.org/wiki/Cellular_automaton)(Also called CA) inspired by the [Conway's Game of Life](https://en.wikipedia.org/wiki/Conway%27s_Game_of_Life). After going back on the project and doing some reasearch on the subject I discovered half of my solution was already existing. I created this repository to share this fun aproach of maze generator.
<br>

### Algorithm
The CA begin with a randomized grid. Black cells are walls and the white ones are corridors. 
The edges of this grid are walls except for one exit and one entrance. 
Then the CA starts and organize the randomize grid in an acceptable maze patterns. 
After a certain amount of iterations the CA stops giving the resulting maze.
This CA work like The Conway's Game of Life by using a set of rule on each cell to determine the next state of this cell.
In one special case a rule is only considered after 10 generation. 
This has been found testing and is entirely empirical. 
This value is probably not the best but works good.


<p align="center">
  <img src="README_files/MazeGeneratorDemo.gif" alt="Demo Maze Generator" width="550">
</p>

### Neighborhood
This cellular automaton use 2 different neighborhoods.
The first one is a [Von Neumann Neighborhood](https://en.wikipedia.org/wiki/Von_Neumann_neighborhood).
And the second counts the Neighbors in diagonal cells(I did not find any name for this Neighborhood in my research. Because of this I will simply continue to name it `diagonal Neighborhood`).
For some rules we are going to need the sum of Von Neumann Neighborhood and diagonal cells forming a [Moore neighborhood](https://en.wikipedia.org/wiki/Moore_neighborhood)(This word will be used later in this section to simplify).

### The Rules
1. The first step is to get the state of the current cell. 
Each state as a set of rules which determine the state of the cell for the next generation.
2. If the current cell is in the state corridor(represented by the boolean value True) then: 
   1. If the `Von Neumann Neighborhood count` and `diagonal Neighbors count` are both `even` or both `odd` then the state doesn't change.
   2. Else If the `Moore neighborhood count` is smaller or equal to `4` or the `Moore neighborhood count` is equal `0` or `diagonal Neighbors` is bigger than the `Von Neumann Neighborhood count`, then the celle becomes a wall(False).
3. If the current cell is in the state wall(represented by the boolean value False) then:
   1. If the `diagonal Neighbors count` is equal to `4`and the `Von Neumann Neighborhood count` is equal to `3` and the generation count is bigger than 10 then the state doesn't change.
   2. Else If the `Von Neumann Neighborhood count` is lower than 2 or `diagonal Neighbors count` is equal to 0 or the `Moore neighborhood count` is lower than 4, then the cell become a corridor(True).

## Usage

This project is designed to run with Oracle [OpenJDK 20](https://www.oracle.com/java/technologies/javase/jdk20-archive-downloads.html).

### Running the Project
To compile the project and then execute the "Main.java" File. A window will appear with the randomize grid. The CA should start 4 seconds after the randomize grid.


## Acknowledgments

[Cellular automaton wiki](https://en.wikipedia.org/wiki/Cellular_automaton)
<br>
[View Conway's Game of Life project in Java by someone else](https://github.com/leonpetrinos/GameOfLifeJavaFX)
<br>
[Other Cellular Automaton Maze Generator ](https://conwaylife.com/wiki/OCA:Maze#Mazectric)
