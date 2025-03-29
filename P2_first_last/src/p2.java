import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class p2 {

	//direction of travel for wolverine - N, S, E, W
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
		readMap("test8");
		
		//calculating runtimes
		double initTime = System.currentTimeMillis();
		queueSolution();
		double finalTime = System.currentTimeMillis();
		System.out.println("Queue Solution runTime: " + (finalTime-initTime)/100000);
		initTime = System.currentTimeMillis();
		stackSolution();
		finalTime = System.currentTimeMillis();
		System.out.println("Stack Solution runTime: " + (finalTime-initTime)/100000);
		initTime = System.currentTimeMillis();
		optimalSolution();
		finalTime = System.currentTimeMillis();
		System.out.println("Optimal Solution runTime: " + (finalTime-initTime)/100000);

		//rest of test files
		readMap("test1");
		readMap("test2");
		readMap("test3");
		readMap("test4");
		readMap("test5");
		readMap("test6");
		readMap("test7");
		readMap("test9");
		readMap("test10");
		
	}
	
	
	//readMap method (did together in class)
	public static void readMap(String filename) {
	    
	    try {
	    	File file = new File(filename);
	    	Scanner scanner = new Scanner(file);
	        
	        numRows = scanner.nextInt();
	        numCols = scanner.nextInt();
	        numRooms = scanner.nextInt();


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
							grid[i].set(rowIndex, i, tile);
						}
						rowIndex++;
					}
				}
			
			scanner.close();
		}
	        

	        // For debugging, print the map

	    } catch (FileNotFoundException e) {
	        e.printStackTrace();
	    }
	}
	
	//Queue-based solution
	public static void queueSolution() {

		for (int i = 0; i < numRooms; i++) {

			Queue<Tile> queue = new LinkedList<>();
			boolean[][] visited = new boolean[numRows][numCols];
			
			//keeps track of tiles visited and path of wolverine
			Tile[][] path = new Tile[numRows][numCols];

			for (int j = 0; j < numRows; j++) {
				for (int k = 0; k < numCols; k++) {
					
					
					if (grid[i].get(j, k).getType() == 'W') {
						//finds location of W and adds it to the queue
						
						queue.add(grid[i].get(j, k));
						//marks the spot as visited
						
						visited[j][k] = true;
						
						path[j][k] = null;
					}
				}
			}
			while (!queue.isEmpty()) {
				
				Tile current = queue.remove();
	       		int curRow = current.getRow();
	            int curCol = current.getCol();

	            //check if you reached prize or next room
	           	if (grid[i].get(curRow, curCol).getType() == '$' || grid[i].get(curRow, curCol).getType() == '|') {

                		LinkedList<Tile> pathway = new LinkedList<>();
                		Tile targetTile = current;
	                
                		while (targetTile != null) {
                    			pathway.addFirst(targetTile);
                    			//add the tiles from tracked path to new pathway but reversed so when you get to the front it is null;
                    			targetTile = path[targetTile.getRow()][targetTile.getCol()];
                		}
	                
                		//mark with + for path
                		for (Tile t : pathway) {
                   			if (t.getType() == '.') {
                        		t.setType('+'); 
                    		}
	                	}
                		//once pathway is found, print the path with the path marked
                		System.out.println("Path found: ");
                		grid[i].print();
	                	return;
	            }

	            // add each available direction to queue so wolverine can check
	            for (int l = 0; l < 4; l++) {
	                int nextRow = curRow + colDir[l];
	                int nextCol = curCol + rowDir[l];

	                if (nextRow >= 0 && nextCol >= 0 && nextRow < numRows && nextCol < numCols && !visited[nextRow][nextCol] && grid[i].get(nextRow, nextCol).getType() != '@') {
	                    visited[nextRow][nextCol] = true;
	                    path[nextRow][nextCol] = current;  //set the parent
	                    queue.add(grid[i].get(nextRow, nextCol));
	                }
	            }
	        }
		}
		
		
	}

	//stack-based solution
	public static void stackSolution() {

		
		
	}
	
	//optimal solution
	public static void optimalSolution() {
		//queue is the optimal solution
		queueSolution();
	}
}

