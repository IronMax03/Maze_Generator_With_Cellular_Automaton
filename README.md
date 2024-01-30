# Maze Generator With Cellular Automaton

## Introduction

This an old project I used as an HelloWorld for my gitHub.
It was in 2020 when I was learning Java. I had an homework wich was to creat a maze generator. I came up whith solutinon using a [Cellular automaton](https://en.wikipedia.org/wiki/Cellular_automaton)(Also called CA) inspired by the [Conway's Game of Life](https://en.wikipedia.org/wiki/Conway%27s_Game_of_Life). After going back on the project and doing some reasearch on the subject I discovered half of my solution was already existing. I created this repository to share this fun aproach of maze generator.
<br>

### Algoritme
The CA begin whith a randomized grid. Black cells are walls and the white ones are coridores. The edges of this grid are walls excepte for one exit and one entrence. Then the CA starts and organize the randomize grid in a acceptable maze parterns. After a certain amout of iterations the CA stops giving the resulting maze.

<p align="center">
  <img src="README_files/MazeGeneratorDemo.gif" alt="Demo Maze Generator" width="550">
</p>

### Neighborhood
This cellular automaton use 2 different neighborhoods.
The first one is a classical [Von Neumann Neighborhood](https://en.wikipedia.org/wiki/Von_Neumann_neighborhood).
And the second counts diagonol Neighboors.

### The Rules


## Usage

This project is designed to run with Oracle [OpenJDK 20](https://www.oracle.com/java/technologies/javase/jdk20-archive-downloads.html).

### Running the Project
To compile the project and then execute the "Main.java" File. A window will apear whith the randomize grid. The CA should start 4 secons after the randomize grid.


## Acknowledgments

[View Conway's Game of Life project in Java by someone else](https://github.com/leonpetrinos/GameOfLifeJavaFX)
<br>
[Other Cellular Automaton Maze Generator ](https://conwaylife.com/wiki/OCA:Maze#Mazectric)
