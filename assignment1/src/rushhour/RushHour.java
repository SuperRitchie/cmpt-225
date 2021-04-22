package rushhour;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RushHour
{
	public final static int UP = 0;
	public final static int DOWN = 1;
	public final static int LEFT = 2;
	public final static int RIGHT = 3;

	public final static int SIZE = 6;

	char boardArr[][] = new char[SIZE][SIZE]; // A good board will always be 6 x 6

	/**
	 * @param fileName
	 * Reads a board from file and creates the board
	 * @throws Exception if the file not found or the board is bad
	 */
	public RushHour(String fileName) throws Exception {
		File board = new File(fileName);
		Scanner reader = new Scanner(board);
		if(reader.hasNext()) {
			for(int i = 0; i < 6; i++) {
				String line = reader.nextLine();
				for(int j = 0; j < 6; j++) {
					boardArr[i][j] = line.charAt(j);
				}
			}
		}
		else {
			FileNotFoundException ex = new FileNotFoundException("File could not be read");
			throw ex;
		}
		reader.close();
	}

	/**
	 * @param carName
	 * @param dir
	 * @param length
	 * Moves car with the given name for length steps in the given direction  
	 * @throws IllegalMoveException if the move is illegal
	 */
	public void makeMove(char carName, int dir, int length) throws IllegalMoveException {
		boolean hor, ver;
		boolean exception = false;
		int horizontal = 0, vertical = 0;
		int maxH = 0, maxV = 0;

		for(int i = 0; i < 6; i++) {
			for(int j = 0; j < 6; j++) {
				if(boardArr[i][j] == carName) {
					horizontal++;
				}
			}
			if(horizontal > maxH) {
				maxH = horizontal;
			}
			horizontal = 0;
		}

		// Algorithm that determines whether the car is oriented horizontally or vertically
		for(int i = 0; i < 6; i++) {
			for(int j = 0; j < 6; j++) {
				if(boardArr[j][i] == carName) {
					vertical++;
				}
			}
			if(vertical > maxV) {
				maxV = vertical;
			}
			vertical = 0;
		}

		if(maxV > maxH) {
			ver = true;
			hor = false;
		}
		else {
			ver = false;
			hor = true;
		}
		//////////////////////////////////////////////////////////////////////////
		// Exception that is thrown when an illegal move is detected
		IllegalMoveException ex = new IllegalMoveException("Illegal move detected");

		// Declaring variables to be compared with directions
		int carLength = 0, iCompare = 0, jCompare = 0;
		int v = 0, h = 0, maxVertical = 0, maxHorizontal = 0;

		for (int j = 0; j < 6; j++) {
			for (int i = 0; i < 6; i++) {
				if (boardArr[i][j] == carName) {
					v++;
				}
			}
			if (v > maxVertical) {
				maxVertical = v;
			}
			v = 0;
		}

		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				if (boardArr[i][j] == carName) {
					h++;
				}
			}
			if (h > maxHorizontal) {
				maxHorizontal = h;
			}
			h = 0;
		}

		if (maxVertical > maxHorizontal) {
			hor = false;
		} else {
			ver = false;
		}

		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				if (boardArr[i][j] == carName) {
					if (carLength == 0) {
						iCompare = i;
						jCompare = j;
					}
					carLength++;
				}
			}
		}

		// Now that we have determined the value of all the variables, we can compare,
		// first checking whether the path is clear for the car to be moved
		if (dir == UP && !hor) {
			if ((iCompare-length) >= 0) {
				for (int i = 0; i <= length; i++) {
					// Move cars
					if(boardArr[iCompare-i][jCompare] == carName || boardArr[iCompare-i][jCompare] == '.') {
						boardArr[iCompare-i][jCompare] = carName;
					} else {
						throw ex;
					}
				}
				// Replace the old spot of the car
				for (int i = 1; i <= length; i++) {
					boardArr[iCompare+carLength-i][jCompare] = '.';
				}
			} else {
				throw ex;
			}
		}
		if (dir == DOWN && !hor) {
			if ((iCompare+carLength+length-1) < 6) {
				for (int i = 1; i <= length; i++) {
					if (boardArr[iCompare+carLength-1+i][jCompare] == carName || boardArr[iCompare+carLength-1+i][jCompare] == '.') {
						boardArr[iCompare+carLength-1+i][jCompare] = carName;
					} else {
						throw ex;
					}
				}
				for (int i = 0; i < length; i++) {
					boardArr[iCompare+i][jCompare] = '.';
				}
			} else {
				throw ex;
			}
		}
		if (dir == LEFT && !ver) {
			if ((iCompare+carLength+length) >= 0) {
				for (int i = 0; i <= length; i++) {
					if (boardArr[iCompare][jCompare-i] == carName || boardArr[iCompare][jCompare-i] == '.') {
						boardArr[iCompare][jCompare-i] = carName;
					} else {
						throw ex;
					}
				}
				for (int i = 0; i < length; i++) {
					boardArr[iCompare][jCompare+carLength-i-1] = '.';
				}
			} else {
				throw ex;
			}
		}
		if (dir == RIGHT && !ver) {
			if ((jCompare+carLength+length-1) < 6) {
				for (int i = 0; i <= length; i++) {
					if (boardArr[iCompare][jCompare+carLength+i-1] == carName || boardArr[iCompare][jCompare+carLength+i-1] == '.') {
						boardArr[iCompare][jCompare+carLength+i-1] = carName;
					} else {
						throw ex;
					}
				}
				for (int i = 0; i < length; i++) {
					boardArr[iCompare][jCompare+i] = '.';
				}
			} else {
				throw ex;
			}
		}
	}

	/**
	 * @return true if and only if the board is solved,
	 * i.e., the XX car is touching the right edge of the board
	 */
	public boolean isSolved() {
		for(int i = 0; i < 6; i++) {
			if(boardArr[i][5] == 'X') {
				return true;
			}
		}
		return false;
	}
}