
public class Maze {
	
	private int[][] maze;
	private int rowSize;
	private int colSize;
	private boolean[][] visited;
	private int numberOfSolution = 0;
	
	
	public Maze(int[][] maze, int rowSize, int colSize) {
		
		this.colSize = colSize;
		this.rowSize = rowSize;
		this.maze = maze;
		visited = new boolean[rowSize][colSize];
		
		for(int i = 0; i < rowSize; i++) {
			for(int j = 0; j < colSize; j++) {
				visited[i][j] = false;
			}
		}

		visited[0][0] = true;
		checkForNextPoint(maze, 0, 0, visited);
		
	}
	
	
	public void checkForNextPoint(int[][] maze, int i, int j, boolean[][] visited){
		
		if(i == rowSize - 1 && j == colSize - 1) {// end of the maze
			displayMazeSolution();
			return;
		}
		
		if(i - 1 >= 0 && j - 1 >= 0 && visited[i-1][j-1] == false && maze[i-1][j-1] == 0) { // check left top point
			visited[i-1][j-1] = true;
			checkForNextPoint(maze, i - 1, j - 1, visited);
			visited[i-1][j-1] = false;
		}
		
		if(i - 1 >= 0 && j < colSize && visited[i-1][j] == false && maze[i-1][j] == 0) {// check top point
			visited[i-1][j] = true;
			checkForNextPoint(maze, i - 1, j, visited);
			visited[i-1][j] = false;
		}
		
		if(i - 1 >= 0 && j + 1 < colSize && visited[i-1][j+1] == false && maze[i-1][j+1] == 0) {// check right top point 
			visited[i-1][j+1] = true;
			checkForNextPoint(maze, i - 1, j + 1, visited);
			visited[i-1][j+1] = false;
		}
		
		if(i < rowSize && j - 1 > 0 && visited[i][j-1] == false && maze[i][j-1] == 0) {// check left point 
			visited[i][j-1] = true;
			checkForNextPoint(maze, i, j - 1, visited);
			visited[i][j-1] = false;
		}
		
		if(i < rowSize && j + 1 < colSize && visited[i][j+1] == false && maze[i][j+1] == 0) {// check right point 
			visited[i][j+1] = true;
			checkForNextPoint(maze, i, j + 1, visited);
			visited[i][j+1] = false;
		}
		
		if(i + 1 < rowSize && j - 1 > 0 && visited[i+1][j-1] == false && maze[i+1][j-1] == 0) {// check bottom left point 
			visited[i+1][j-1] = true;
			checkForNextPoint(maze, i + 1, j - 1, visited);
			visited[i+1][j-1] = false;
		}
		
		if(i + 1 < rowSize && j < colSize && visited[i+1][j] == false && maze[i+1][j] == 0) {// check bottom point 
			visited[i+1][j] = true;
			checkForNextPoint(maze, i + 1, j, visited);
			visited[i+1][j] = false;
		}
		
		if(i + 1< rowSize && j + 1 < colSize && visited[i+1][j+1] == false && maze[i+1][j+1] == 0) {// check bottom right point 
			visited[i+1][j+1] = true;
			checkForNextPoint(maze, i + 1, j + 1, visited);
			visited[i+1][j+1] = false;
		}
	
	}
	
	public void displayMazeSolution() {
		
		numberOfSolution++;
		
		System.out.println("Solution " + numberOfSolution + ":");
		for(int i = 0; i < rowSize; i++) {
			for(int j = 0; j < colSize; j++) {
				if(visited[i][j] == true) {
					System.out.print("#");
				}
				else {
					System.out.print(maze[i][j]);
				}
			}
			System.out.println();
		}
		System.out.println("\n\n");
		
	}
		
}
