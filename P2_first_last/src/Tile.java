
public class Tile {

	int row;
    int col;
    char type;  // 'W', '@', '.', '$', '|'
    boolean visited;

    public Tile(int row, int col, char type) {
        this.row = row;
        this.col = col;
        this.type = type;
        this.visited = false;
    }
    
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public int getCol() {
		return col;
	}
	public void setCol(int col) {
		this.col = col;
	}
	public char getType() {
		return type;
	}
	public void setType(char type) {
		this.type = type;
	}
	
	
	
}
