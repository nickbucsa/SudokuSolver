import java.util.*;
import java.io.*;

class Node {
    private Node next;
    private int[][] solution;

    public Node(int[][] sol) {
        next = null;
        solution = sol;
    }
	public Node(Node n) {
		this.solution = n.getSolution();
		next = n.getNext();
	}
    public int[][] getSolution() {
        return solution;
    }
    public void setNext(Node n) {
        next = n;
    }
    public Node getNext() {
        return next;
    }
}

class Sudoku {
    private int[][] original, puzzle;
    private boolean reset;
    private Node head, tail;
	private int totalSolutions;

    public Sudoku() {
        totalSolutions = 0;
		original = new int[9][9];
		puzzle = new int[9][9];
		reset = true;
		head = null;
		tail = null;
        readPuzzle();
        createWorkPuzzle();
    }

    public void readPuzzle() {
        try {
            Scanner sc = new Scanner(new File("SudokuPuzzle.txt"));
            while (sc.hasNextLine()) {
			    //read sudoku from text file into 9x9 array
                //System.out.println(sc.nextInt());
                for (int i = 0; i < 9; i ++) {
				    for (int j = 0; j < 9; j++) {
                        try {
                            original[i][j] = sc.nextInt();
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
    }

    public void createWorkPuzzle() {
        for (int i = 0; i < 9; i ++)
            for (int j = 0; j < 9; j++)
                puzzle[i][j] = original[i][j];
    }
    
    public void printPuzzle() {
		for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(puzzle[i][j] + " ");
            }
            System.out.print("\n");
        }
    }

    public void printMenu() {
        System.out.println("\nWhat would you like to do?");
        System.out.print("(a) Find another solution\n(b) Change a constraint\n(c) Quit\n>>> ");
    }

    public boolean isInRow(int row, int number) {
        for (int i = 0; i < 9; i++)
            if (puzzle[row][i] == number)
                return true;
        return false;
    }

    public boolean isInColumn(int column, int number) {
        for (int i = 0; i < 9; i++)
            if (puzzle[i][column] == number)
                return true;
        return false;
    }

    public boolean isInBox(int row, int column, int number) {
        int r = row - row % 3;
        int c = column - column % 3;
        for (int i = r; i < r + 3; i++)
            for (int j = c; j < c + 3; j++)
                if (puzzle[i][j] == number)
                    return true;
        return false;
    }

    public boolean isValid(int r, int c, int n) {
        return !isInRow(r, n) && !isInColumn(c, n) && !isInBox(r, c, n);
    }

    // Recursive function
    public boolean solve() {
        if (!reset) {
			for (int i = 0; i < 9; i++)
				for (int j = 0; j < 9; j++ )
					puzzle[i][j] = original[i][j];
            reset = true;
        }
		for (int r = 0; r < 9; r++) {
			for (int c = 0; c < 9; c++) {
				if (puzzle[r][c] == 0) {
					for (int nr = 1; nr < 10; nr++) {
						if (isValid(r, c, nr)) {
							puzzle[r][c] = nr;
							if (solve()) {
								return true;
							}
						}
					}
					puzzle[r][c] = 0;
					return false;
				}
			}
        }
        if (!validateSolution()) {
			return false;
		}
		addSolution();
        return true;
    }

    public void addSolution() {
		int[][] solution = new int[9][9];
		for (int r = 0; r < 9; r++)
			for (int c = 0; c < 9; c++)
				solution[r][c] = puzzle[r][c];
		if (totalSolutions == 0) {
			head = new Node(solution);
		} else if (totalSolutions == 1) {
			tail = new Node(solution);
			head.setNext(tail);
		} else {
			Node curr = new Node(solution);
			tail.setNext(curr);
			tail = tail.getNext();
		}
		totalSolutions++;
		reset = false;
    }
    
    public boolean validateSolution() {
		if (totalSolutions == 0) return true;
		Node curr = new Node(head);
		boolean different = false;
		while (curr != null) {
			for (int r = 0; r < 9; r++)
				for( int c = 0; c < 9; c++ )
					if (puzzle[r][c] != curr.getSolution()[r][c])
						different = true;
			curr = curr.getNext();
			if (!different)
				return false;
			different = false;
		}
		return true;
	}
	
	public int getTotalSolutions() {
		return totalSolutions;
	}
	
	public void addConstraint(int r, int c, int n) {
		original[r][c] = n;
		totalSolutions = 0;
		head = null;
		tail = null;
		reset = false;
		createWorkPuzzle();
		System.out.println("\nSolving the puzzle bellow: ");
		printPuzzle();
	}
}

class SudokuSolver {
    public static void main(String[] args) {
        Sudoku sudo = new Sudoku();
        char opt;
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to the 9x9 Sudoku Solver!\nLoading SudokuPuzzle.txt\n");
        System.out.println("Solving the puzzle below:");
        sudo.printPuzzle();
		
		System.out.println("\nA solution is: ");
		if (sudo.solve())
			sudo.printPuzzle();
		else 
			System.out.println("No solutions");
		System.out.println("Total solutions: " + sudo.getTotalSolutions());
		
        while (true) {
            sudo.printMenu();
            opt = input.next().charAt(0);
            switch (opt) {
                case 'a':
                    if (sudo.solve()) {
                        System.out.println("A solution is: ");
                        sudo.printPuzzle();
                    } else
                        System.out.println("There are no other solutions. ");
					System.out.println("Total solutions: " + sudo.getTotalSolutions());
                break;
                case 'b':
                    System.out.println("What constraint would you like to change?\nFormat: row(1-9) column(1-9) value(0-9) --- 0 indicates a blank");
                    int r = input.nextInt()-1;
                    int c = input.nextInt()-1;
                    int n = input.nextInt();
					sudo.addConstraint(r, c, n);
                break;
                case 'c':
					input.close();
                return;
                default:
                    System.out.println("Invalid option! ");
                break;
            }
        }
    }
}
