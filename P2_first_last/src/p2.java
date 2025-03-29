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
		System.out.println("Testing with map file: ");
		readMap("Design 5");
		queueSolution();
		
		optimalSolution();
		
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
	
	public static void queueSolution() {

		for (int i = 0; i < numRooms; i++) {

			Queue<Tile> queue = new LinkedList<>();
			boolean[][] visited = new boolean[numRows][numCols];
			int distance[][] = new int[numRows][numCols];

			for (int j = 0; j < numRows; j++) {
				for (int k = 0; k < numCols; k++) {
					distance[i][j] = -1;
					if (grid[room].get(j, k).getType() == 'W') {
						queue.add(grid[i].get(j, k));
						visited[j][k] = true;
						distance[j][k] = 0;
					}
				}
			}
			while (!queue.isEmpty()) {
	            		Tile current = queue.remove();
	            		int curRow = current.getRow();
	            		int curCol = current.getCol();

	            		//check target reached
	           		if (grid[i].get(curRow, curCol).getType() == '$' || grid[i].get(curRow, curCol).getType() == '|') {

	                		LinkedList<Tile> path = new LinkedList<>();
	                		Tile targetTile = current;
	                
	                		while (targetTile != null) {
	                    			path.addFirst(targetTile); //reverse list
	                    			targetTile = parent[targetTile.getRow()][targetTile.getCol()];
	                		}
	                
	                		//mark the path
	                		for (Tile t : path) {
	                    			if (t.getType() == '.') {
	                        		t.setType('+'); 
	                    		}
	                	}
	                
	                	System.out.println("Path found:");
	                	grid[i].print();  //Print the grid with the path marked
	                	return;
	            	}

	            //4 directions
	            for (int direction = 0; direction < 4; direction++) {
	                int nextRow = curRow + colDir[direction];
	                int nextCol = curCol + rowDir[direction];

	                if (nextRow >= 0 && nextCol >= 0 && nextRow < numRows && nextCol < numCols && !visited[nextRow][nextCol] && grid[i].get(nextRow, nextCol).getType() != '@') {
	                    visited[nextRow][nextCol] = true;
	                    parent[nextRow][nextCol] = currentTile;  //set the parent
	                    queue.add(grid[i].get(nextRow, nextCol));
	                }
	            }
	        }
		}
		//if the target was not found
	        System.out.println("Target not found.");
		
	}

	public static void stackSolution() {

		
	}
	
	public static void optimalSolution() {
		queueSolution();
	}
}

