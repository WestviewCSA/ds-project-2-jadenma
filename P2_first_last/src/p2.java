import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class p2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("p2");
		
		readMap("Design 4");
	}
	
	public static void readMap(String filename) {
	    File file = new File(filename);
	    Scanner scanner;
	    try {
	        scanner = new Scanner(file);
	        int numRows = scanner.nextInt();
	        int numCols = scanner.nextInt();
	        int numRooms = scanner.nextInt();
	        scanner.nextLine();  // Move to the next line after reading dimensions

	        Tile[][] map = new Tile[numRows][numCols];

	        int rowIndex = 0;
	        while (scanner.hasNextLine() && rowIndex < numRows) {
	            String row = scanner.nextLine();
	            if (row.length() > 0) {
	                for (int i = 0; i < numCols && i < row.length(); i++) {
	                    char e1 = row.charAt(i);
	                    map[rowIndex][i] = new Tile(rowIndex, i, e1);
	                }
	                rowIndex++;
	            }
	        }
	        scanner.close();

	        // For debugging, print the map
	        printMap(map);

	    } catch (FileNotFoundException e) {
	        e.printStackTrace();
	    }
	}
	
	public static void printMap(Tile[][] map) {
	    for (int i = 0; i < map.length; i++) {
	        for (int j = 0; j < map[i].length; j++) {
	            System.out.print(map[i][j].type);
	        }
	        System.out.println();
	    }
	}

	 
	
	

	
	
}

