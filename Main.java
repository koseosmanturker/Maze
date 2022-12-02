import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	
	public static void readMaze(String path) throws FileNotFoundException {
		
		File file = new File(path);
		
		if(!file.exists()) {
			System.out.println("File not found");
			return;
		}

	    Scanner scan = new Scanner(file);
	    
	    int[][] mazeArray = new int[30][];
	    int rowIdx = 0;
	    int colSize = 0;
	    while(scan.hasNext()) {
	    	
	    	String line = scan.next();
	    	mazeArray[rowIdx] = new int[line.length()];
	    	
	    	for(int i = 0; i < line.length(); i++) {
	    		mazeArray[rowIdx][i] = line.charAt(i) - 48;
	    	}
	    	rowIdx++;
	    	colSize = line.length();
	    }
	    
	   
	    Maze maze = new Maze(mazeArray, rowIdx, colSize);
	    
	    scan.close();
	}

	
	public static void main(String[] args) throws FileNotFoundException {
		
		String fileName = "maze";
		readMaze(fileName);

	}

}
