import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class p2 {

	static int[] colDir = {0, 1, 0, -1};
	static int[] rowDir = {1, 0, -1, 0};
	static Map[] grid;
	static LinkedList<Tile> path;
	static int numRows;
	static int numCols;
	static int numRooms;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Testing with map file: " + filename);
		readMap("Design 5");
		queueSolve();
	}
	
	public static void readMap(String filename) {
	    
	    try {
	        scanner = new Scanner(file);
	        numRows = scanner.nextInt();
	        numCols = scanner.nextInt();
	        numRooms = scanner.nextInt();
		    File file = new File(filename);
	    Scanner scan = new Scanner(file);


	        grid = new Map[numRooms];

	        int rowIndex = 0;
	        for (int i = 0; i < numRooms; i++) {
			
			grid[i] = new Map(numRows, numCols);
			
			while (scanner.hasNextLine() && rowIndex < numRows) {
				String row = scanner.nextLine();
				//check if something is on the next line
				if (row.length() > 0) {
					for (int j = 0; j < numCols && j < row.length(); j++) {
						char a = row.charAt(j);
						Tile tile = new Tile(rowIndex, j, a);
						grid[i].set(rowIndex, i, obj);
					}
					rowIndex++;
				}
			}
		}
	        scanner.close();

	        // For debugging, print the map

	    } catch (FileNotFoundException e) {
	        e.printStackTrace();
	    }
	}
	
	
	
	
}

