import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Map {

	private Tile[][] map;

	public Map(int row, int column) {
		
		map = new Tile[row][column];
		
		for (int i = 0; i < row; i++) {
			
			for (int j = 0; j < column; j++) {
				
				map[i][j] = new Tile(i, j, '.');
				
			}
		}
	}
	
	public void set(int row, int column, Tile tile) {
		
		map[row][column] = tile;
		
	}
	
	public Tile get(int row, int column) {
		
		//check boundaries
		if (row < 0 || column < 0 || row >= map.length || column >= map[0].length) {
			
			return new Tile(row, column, '@');
			
		}
		
		return map[row][column];
		
	}
	
	public void print() {
		for (int i = 0; i < map.length; i++) {
			
			for (int j = 0; j < map[i].length; j++) {
				
				System.out.print(map[i][j].getType());

			}
			
			System.out.println();
			
		}
	}
    
	
	
}
