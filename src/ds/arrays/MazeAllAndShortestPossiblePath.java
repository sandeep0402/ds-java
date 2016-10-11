package ds.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Custom Solution By sandeep
 */
public class MazeAllAndShortestPossiblePath {
	public static void main(String[] args) {
		boolean[][] maze = new boolean[4][4];
		makeRandomMaze(maze);
		//makeCustomMaze(maze);
		printMaze(maze);
		List<List<String>> paths = findPaths(maze, 0, 0);
		if (paths == null || paths.isEmpty()) {
			System.out.println("No path possible");
			return;
		}else{
			System.out.println("All Posible Paths are : " + paths.size());
		}
		System.out.println();
		List<String> shortPath = null;
		for (List<String> path : paths) {
			System.out.println(path);
			if(shortPath == null){
				shortPath = path;
			}else if(shortPath.size() > path.size()){
				shortPath = path;
			}
		}
		System.out.println("Shortest Path is: " + shortPath);		
	}

	/**
	 * Custom method By sandeep
	 */
	private static List<List<String>> findPaths(boolean[][] maze, int i, int j) {
		// Hold the list of paths, where path i itself is a list
		List<List<String>> result = new ArrayList<List<String>>();
		// create the path with current cell, which will be returned to parent
		List<String> path = new ArrayList<String>();
		String current = " (" + i + "," + j + ")";
		// if index is going out or maze boundaries then return null
		if (i < 0 || j < 0 || i >= maze.length || j >= maze[0].length)
			return null;
		// if maze is blocked then return null path
		if (maze[i][j] == true)
			return null;
		// if current cell is the last exit cell then return the current path
		if (i == maze.length - 1 && j == maze[0].length - 1) {
			path.add(current);
			result.add(path);
			return result;
		}
		// Temporary Step: If we are here, means current cell is not blocked (not marked as true as obstacle)
		// temporary blocking for child cells to stop backtracking 
		// (only required when back and up movement is allowed, otherwise skip this one) 
		maze[i][j] = true;
		// find child paths from downside cell
		List<List<String>> downSidePaths = findPaths(maze, i + 1, j);
		// if atleast one path is there
		if(downSidePaths != null){
			// iterate and add current cell in start of path
			for (List<String> list : downSidePaths) {
				list.add(0, current);				
			}
			// add all child paths to parent list to return back 
			result.addAll(downSidePaths);
		}
		// find child paths from left cell
		List<List<String>>  leftSidePaths = findPaths(maze, i, j + 1);
		if(leftSidePaths != null){
			for (List<String> list : leftSidePaths) {
				list.add(0, current);				
			}			
			result.addAll(leftSidePaths);
		}
		// find child paths from upper cell
		List<List<String>>  upperSidePaths = findPaths(maze, i - 1, j);
		if(upperSidePaths != null){
			for (List<String> list : upperSidePaths) {
				list.add(0, current);				
			}	
			result.addAll(upperSidePaths);
		}		
		// find child paths from previous cell		
		List<List<String>>  previousSidePaths = findPaths(maze, i, j - 1);
		if(previousSidePaths != null){
			for (List<String> list : previousSidePaths) {
				list.add(0, current);				
			}	
			result.addAll(previousSidePaths);
		}
		// from Temporary Step, unblocking the current cell (only required if temporary Step is applied) 
		maze[i][j] = false;
		return result;
	}
	private static void printMaze(boolean[][] maze) {
		for (int i = 0; i < maze.length; ++i) {
			for (int j = 0; j < maze[i].length; ++j) {
				if (maze[i][j])
					System.out.print("#|");
				else
					System.out.print("_|");
			}
			System.out.println();
		}
	}

	private static void makeRandomMaze(boolean[][] maze) {
		for (int i = 0; i < maze.length; ++i) {
			for (int j = 0; j < maze[0].length; ++j) {
				maze[i][j] = (int) (Math.random() * 3) == 1;
			}
		}
		maze[0][0] = false;
		maze[maze.length - 1][maze[0].length - 1] = false;

	}
	private static void makeCustomMaze(boolean[][] maze) {
		for (int i = 0; i < maze.length; ++i) {
			for (int j = 0; j < maze[0].length; ++j) {
				maze[i][j] = false;
			}
		}
		maze[0][0] = false;
		maze[maze.length - 1][maze[0].length - 1] = false;
		maze[0][1] = true;
		maze[0][3] = true;
		maze[3][1] = true;
		maze[3][2] = true;
	}	
}
