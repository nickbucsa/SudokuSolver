import java.util.*;
import java.io.*;

class SudokuSolver {
    public static int[][] puzzle = new int [9][9];
    public static int index = 0;
    public static box[] boxArray;
    public static List<int[][]> list;

    public static void printBoard(int[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.print("\n");
        }
    }

    public static void printMenu() {
        System.out.println("\nWhat would you like to do?");
        System.out.print("(a) Find another solution\n(b) Change a constraint\n(c) Quit\n>>> ");
    }

    public static boolean isInRow(int board[][], int row, int number) {
        for (int i = 0; i < 9; i++)
            if (board[row][i] == number)
                return true;
        return false;
    }

    public static boolean isInColumn(int[][] board, int column, int number) {
        for (int i = 0; i < 9; i++)
            if (board[i][column] == number)
                return true;
        return false;
    }

    public static boolean isInBox(int[][] board, int row, int column, int number) {
        int r = row - row % 3;
        int c = column - column % 3;
        for (int i = r; i < r + 3; i++)
            for (int j = c; j < c + 3; j++)
                if (board[i][j] == number)
                    return true;
        return false;
    }

    private static boolean isValid(int[][] board, int r, int c, int n) {
        return !isInRow(board, r, n) && !isInColumn(board, c, n) && !isInBox(board, r, c, n);
    }

    public static int getBlanks(int[][] board) {
        int counter = 0;
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (board[r][c] == 0) {
                    counter++;
                }    
            }
        }
        return counter;
    }

    // Recursive function
    public static boolean solve(box[] boxArray, int index) {
        int blanx = getBlanks(puzzle);
        int r,c,v;
        
        if (blanx == 0) {
            
            return true;
        }
        r = boxArray[index].row;
        c = boxArray[index].column;
        v = boxArray[index].value + 1;
        if (isValid(puzzle, r, c, v)) {
            puzzle[r][c] = v;
            ++index;
            solve(boxArray, index);
        } else {
            if (v == 9) {
                puzzle[r][c] = 0;
                boxArray[--index].incValue();
                solve(boxArray, index);
            } else {
                boxArray[index].incValue();
                solve(boxArray, index);
            }
        }
        // disregard the next comment
        /*for (int k = 1; k <10; k++) {
            // If a certain number is a legal for a cell - use it
            if (isValid(board, cell.row, cell.column, k)) {
                board[cell.row][cell.column] = k;
                if (i == .length - 1) {// if it's the last empty box
                    //printgame.board(b);
                    return true;
                } else {
                    solved = solveBacktrack(b,row+1,0); // if its not the lowest row - keep solving for next row
                }
                else // keep solving for the next cell
                    solved=solveBacktrack(b,row,col+1);
            }
            if (solved)
                return true;
            else //if down the recursion sudoku isn't solved-> remove the number (backtrack)
            {
                b[row][col]=0;
            }
        }*/
        return false;
    }

        
    public static void main(String[] args) {
        char opt;
        System.out.println("Welcome to the 9x9 Sudoku Solver!\nLoading SudokuPuzzle.txt\n");
        System.out.println("Solving the puzzle below:");
        try {
            Scanner sc = new Scanner(new File("SudokuPuzzle.txt"));
            while (sc.hasNextLine()) {
			    //read sudoku from text file into 9x9 array
                //System.out.println(sc.nextInt());
                for (int i = 0; i < 9; i ++) {
				    for (int j = 0; j < 9; j++) {
                        try {
                            puzzle[i][j] = sc.nextInt();
                        }
                        catch (java.util.NoSuchElementException e) {
                            // e.printStackTrace();
                        }
                    }
                }
            }
            sc.close();
        } catch (Exception e) {
                e.printStackTrace();
        }
        printBoard(puzzle);
        int nrOfBlanks = getBlanks(puzzle);
        int k = 0;
        //box[] 
        boxArray = new box[nrOfBlanks];
        Scanner input = new Scanner(System.in);
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (puzzle[r][c] == 0) {
                    //boxArray[k] = new box(r,c,0);
                    boxArray[k] = new box();
                    boxArray[k].row = r;
                    boxArray[k].column = c;
                    boxArray[k].value = 0;
                    k++;
                }
            }
        }
        // This is the array of empty boxes:
        //for (int i = 0; i < nrOfBlanks; i++)
        //    System.out.println(boxArray[i].row + " " + boxArray[i].column + " " + boxArray[i].value);
        System.out.println("\nA solution is: ");
        solve(boxArray, index);
        printBoard(puzzle);
        /*while (true) {
            printMenu();
            opt = input.next().charAt(0);
            switch (opt) {
                case 'a':
                    if (solve(puzzle, boxArray)) {
                        System.out.println("A solution is: ");
                        printBoard(puzzle);
                    } else
                        System.out.println("There are no other solutions. ");
                break;
                case 'b':
                    System.out.println("What constraint would you like to change?\nFormat: row(1-9) column(1-9) value(0-9) --- 0 indicates a blank");
                    int r = input.nextInt()-1;
                    int c = input.nextInt()-1;
                    int n = input.nextInt();
                    if (isValid(puzzle, r, c, n)) {
                        puzzle[r][c] = n;
                        System.out.println("\nSolving the puzzle bellow: ");
                        printBoard(puzzle);
                        nrOfBlanks = getBlanks(puzzle);
                        k = 0;
                        boxArray = new box[nrOfBlanks];
                        for (r = 0; r < 9; r++) {
                            for (c = 0; c < 9; c++) {
                                if (puzzle[r][c] == 0) {
                                    boxArray[k] = new box();
                                    boxArray[k].row = r;
                                    boxArray[k].column = c;
                                    boxArray[k].value = 0;
                                    k++;
                                }
                            }
                        }
                        if (solve(puzzle, boxArray, index)) {
                            System.out.println("A solution is: ");
                            printBoard(puzzle);
                        } else
                            System.out.println("There are no solutions. ");
                    } else
                        System.out.println("\nInvalid value! ");
                break;
                case 'c':
                return;
                default:
                    System.out.println("Invalid option! ");
                break;
            }
        }*/
        input.close();
    }
}