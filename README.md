# SudokuSolver
Sudoku solver recursively, finds multiple solutions

Comp 182 Project 1
9X9 Sudoku Solver

A sudoku puzzle for this project follows the rules of sudoku (given below) and can have multiple solutions (unlike the strict definition which requires that there be only one solution).

Rules of Sudoku
The 9X9 Sudoku game involves a grid of 81 squares.
The grid is divided into nine blocks, each containing nine squares.
Each of the nine blocks has to contain all the numbers 1-9 within its squares. Each number can only appear once in a row, column, and block.

Create a sudoku solver that (1) will take an input file (SudokuPuzzle.txt) and provide a solution if one exist or say that the puzzle has no valid solutions; (2) Provide the options to (a) find another solution if one exist (b) change a constraint in the puzzle and display solutions, and (c) quit the program.

The SudokuPuzzle.txt is a plain text file that has all the numbers (0-9) in a row in nine lines, delimited by a space.  Zero (‘0’) indicates a blank square. An example is given below.

Sample SudokuPuzzle.txt
0 0 2 6 0 0 0 7 0
0 0 0 0 3 0 0 0 6
0 7 0 0 4 0 3 0 0
0 0 0 0 0 0 6 0 3
0 0 0 0 0 0 0 1 0
0 0 0 8 1 0 0 9 2
0 0 6 0 0 0 0 2 5
0 0 0 0 5 0 0 0 0
3 2 0 4 0 0 8 0 9  

The program should follow the sample run provided below.  The project submission should be a java file entitled my 9X9SudokuSolver.java onto Canvas.  This is an individual project.  You may not share code with other students.  

The sample run of the required program is given below.

Welcome to the 9X9 Sudoku Solver!
Loading SudokuPuzzle0txt.

Solving the puzzle below: 

0 0 2 6 0 0 0 7 0
0 0 0 0 3 0 0 0 6
0 7 0 0 4 0 3 0 0
0 0 0 0 0 0 6 0 3
0 0 0 0 0 0 0 1 0
0 0 0 8 1 0 0 9 2
0 0 6 0 0 0 0 2 5
0 0 0 0 5 0 0 0 0
3 2 0 4 0 0 8 0 9

A solution is:

4 3 2 6 8 5 9 7 1
9 5 8 1 3 7 2 4 6
6 7 1 9 4 2 3 5 8
5 1 9 7 2 4 6 8 3
2 8 3 5 6 9 4 1 7
7 6 4 8 1 3 5 9 2
1 4 6 3 9 8 7 2 5
8 9 7 2 5 6 1 3 4
3 2 5 4 7 1 8 6 9

What would you like to do? 
(A) find another solution, 
(B) change a constraint  
(C) quit
> A

Looking for another solution.

There are no other solutions.

What would you like to do? 
(A) find another solution, 
(B) change a constraint  
(C) quit
> B

What constraint would you like to change?
Format: row(1-9) column(1-9) value(0-9) --- 0 indicates a blank

0 0 2 6 0 0 0 7 0
0 0 0 0 3 0 0 0 6
0 7 0 0 4 0 3 0 0
0 0 0 0 0 0 6 0 3
0 0 0 0 0 0 0 1 0
0 0 0 8 1 0 0 9 2
0 0 6 0 0 0 0 2 5
0 0 0 0 5 0 0 0 0
3 2 0 4 0 0 8 0 9
> 1 3 1

Solving the puzzle below:

0 0 1 6 0 0 0 7 0
0 0 0 0 3 0 0 0 6
0 7 0 0 4 0 3 0 0
0 0 9 0 0 0 6 0 3
0 0 0 0 0 0 0 1 0
0 0 0 8 1 0 0 9 2
0 0 6 0 0 0 0 2 5
0 0 0 0 5 0 0 0 0
3 2 0 4 0 0 8 0 9 

A solution is:

5 3 1 6 8 2 9 7 4
8 9 4 1 3 7 2 5 6
6 7 2 5 4 9 3 8 1
1 8 9 7 2 5 6 4 3
2 5 3 9 6 4 7 1 8
4 6 7 8 1 3 5 9 2
7 1 6 3 9 8 4 2 5
9 4 8 2 5 6 1 3 7
3 2 5 4 7 1 8 6 9

What would you like to do? 
(A) find another solution, 
(B) change a constraint  
(C) quit
>A

Another solution is:

5 3 1 6 8 2 9 7 4
8 9 4 1 3 7 2 5 6
6 7 2 5 4 9 3 8 1
1 8 9 7 2 5 6 4 3
2 5 3 9 6 4 7 1 8
4 6 7 8 1 3 5 9 2
7 4 6 3 9 8 1 2 5
9 1 8 2 5 6 4 3 7
3 2 5 4 7 1 8 6 9

What would you like to do? 
(A) find another solution, 
(B) change a constraint  
(C) quit
>A

Another solution is:

5 3 1 6 8 2 9 7 4
9 4 8 1 3 7 2 5 6
6 7 2 5 4 9 3 8 1
1 8 9 7 2 5 6 4 3
2 5 3 9 6 4 7 1 8
4 6 7 8 1 3 5 9 2
7 1 6 3 9 8 4 2 5
8 9 4 2 5 6 1 3 7
3 2 5 4 7 1 8 6 9

What would you like to do? 
(A) find another solution, 
(B) change a constraint  
(C) quit
>A

Another solution is:

5 3 1 6 8 2 9 7 4
9 8 4 1 3 7 2 5 6
6 7 2 5 4 9 3 8 1
8 1 9 7 2 5 6 4 3
2 5 3 9 6 4 7 1 8
4 6 7 8 1 3 5 9 2
7 4 6 3 9 8 1 2 5
1 9 8 2 5 6 4 3 7
3 2 5 4 7 1 8 6 9

What would you like to do? 
(A) find another solution, 
(B) change a constraint  
(C) quit
>A

There are no other solutions

What would you like to do? 
(A) find another solution, 
(B) change a constraint  
(C) quit
>B

What constraint would you like to change?
Format: row(1-9) column(1-9) value(0-9) --- 0 indicates a blank

0 0 1 6 0 0 0 7 0
0 0 0 0 3 0 0 0 6
0 7 0 0 4 0 3 0 0
0 0 9 0 0 0 6 0 3
0 0 0 0 0 0 0 1 0
0 0 0 8 1 0 0 9 2
0 0 6 0 0 0 0 2 5
0 0 0 0 5 0 0 0 0
3 2 0 4 0 0 8 0 9 
> 3 2 2

Solving the puzzle below:

0 0 1 6 0 0 0 7 0
0 0 0 0 3 0 0 0 6
0 2 0 0 4 0 3 0 0
0 0 9 0 0 0 6 0 3
0 0 0 0 0 0 0 1 0
0 0 0 8 1 0 0 9 2
0 0 6 0 0 0 0 2 5
0 0 0 0 5 0 0 0 0
3 2 0 4 0 0 8 0 9 

There are no valid solutions.

What would you like to do?
(A) find another solution, 
(B) change a constraint  
(C) quit
> C


