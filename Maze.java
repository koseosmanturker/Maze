
public class Maze {
	
	private int rowSize;
	private int[][] maze;
	private boolean[][] visited;
	private String[][] solution;
	
	
	public Maze(int[][] maze, int rowSize) {
		
		this.rowSize = rowSize;
		this.maze = maze;
		visited = new boolean[rowSize][maze[0].length];
		solution = new String[rowSize][maze[0].length];
		
		for(int i = 0; i < rowSize; i++) {
			for(int j = 0; j < maze[0].length; j++) {
				visited[i][j] = false;
				solution[i][j] = ".";
			}
		}

		visited[0][0] = true;
		solution[0][0] = "#";
		checkForNextPoint(maze, 0, 0, visited);
		
	}
	
	
	public void checkForNextPoint(int[][] maze, int i, int j, boolean[][] visited){
		
		if(i == rowSize - 1 && j == maze[0].length - 1) {// end of the maze
			displayMazeSolution();
			return;
		}
		
		if(i - 1 >= 0 && j - 1 >= 0 && visited[i-1][j-1] == false && maze[i-1][j-1] == 0) { // check left top point
			visited[i-1][j-1] = true;
			solution[i-1][j-1] = "#";
			checkForNextPoint(maze, i - 1, j - 1, visited);
			solution[i-1][j-1] = ".";
		}
		
		if(i - 1 >= 0 && j < maze[0].length && visited[i-1][j] == false && maze[i-1][j] == 0) {// check top point
			visited[i-1][j] = true;
			solution[i-1][j] = "#";
			checkForNextPoint(maze, i - 1, j, visited);
			solution[i-1][j] = ".";
		}
		
		if(i - 1 >= 0 && j + 1 < maze[0].length && visited[i-1][j+1] == false && maze[i-1][j+1] == 0) {// check right top point 
			visited[i-1][j+1] = true;
			solution[i-1][j+1] = "#"; 
			checkForNextPoint(maze, i - 1, j + 1, visited);
			solution[i-1][j+1] = ".";
		}
		
		if(i < rowSize && j - 1 > 0 && visited[i][j-1] == false && maze[i][j-1] == 0) {// check left point 
			visited[i][j-1] = true;
			solution[i][j-1] = "#";
			checkForNextPoint(maze, i, j - 1, visited);
			solution[i][j-1] = ".";
		}
		
		if(i < rowSize && j + 1 < maze[0].length && visited[i][j+1] == false && maze[i][j+1] == 0) {// check right point 
			visited[i][j+1] = true;
			solution[i][j+1] = "#";
			checkForNextPoint(maze, i, j + 1, visited);
			solution[i][j+1] = ".";
		}
		
		if(i + 1 < rowSize && j - 1 > 0 && visited[i+1][j-1] == false && maze[i+1][j-1] == 0) {// check bottom left point 
			visited[i+1][j-1] = true;
			solution[i+1][j-1] = "#";
			checkForNextPoint(maze, i + 1, j - 1, visited);
			solution[i+1][j-1] = ".";
		}
		
		if(i + 1 < rowSize && j < maze[0].length && visited[i+1][j] == false && maze[i+1][j] == 0) {// check bottom point 
			visited[i+1][j] = true;
			solution[i+1][j] = "#";
			checkForNextPoint(maze, i + 1, j, visited);
			solution[i+1][j] = ".";
		}
		
		if(i + 1< rowSize && j + 1 < maze[0].length && visited[i+1][j+1] == false && maze[i+1][j+1] == 0) {// check bottom right point 
			visited[i+1][j+1] = true;
			solution[i+1][j+1] = "#";
			checkForNextPoint(maze, i + 1, j + 1, visited);
			solution[i+1][j+1] = ".";
		}
		
		else {
			return;
		}
		
		
	
	}
	
	public void displayMazeSolution() {
		
		for(int i = 0; i < rowSize; i++) {
			for(int j = 0; j < maze[0].length; j++) {
				System.out.print(solution[i][j]);
			}
			System.out.println();
		}
		
	}
		
}
