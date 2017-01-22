package ds.arrays.advanced;

/**
 *  Custom Solution By sandeep
 *  2 d arrays will have 0s and 1s. You need to find how many groups of 1s are present and what is the maximum numbers of 1 in any group
 *  Example
    0 1 0 1 0 
    0 0 1 1 0 
    1 0 0 1 0 
    0 0 1 1 1 
    1 0 0 0 0 
    Total regions: 3
    Connected cells in largest region: 8
 * Algorithm used: DFS (Depth first search)
 * Steps:
 * 1. Use a similar size of boolean 2d array to track which cell is already traversed
 * 2. Traverse every cell in 2d array 
 * 3. For every cell if its non zero and non visited then count =1 and check for child and add count return by child to parent cell
 * 4. Child include next, previous, up, down, and diagonal elements (next down, next up, previous up, previous down) 
 * 5. maximum count returned for any child is the max number of elements in connected cells
 * 6. Total number of connected cells is the count of all non-zero returns for any element
 */
public class ConnectedSectorsInLargetGrid {

    public static void main(String[] args) {
        int[][] maze = new int[5][5];
        makeRandomMaze(maze);
        //makeCustomMaze(maze);
        printMaze(maze);
        System.out.println("Connected cells in largest regions: " + findLargestConnectedSector(maze));
    }

    public static int findLargestConnectedSector(int[][] maze){
        if(maze == null)
            return 0;
        int count =0 ;
        int regions = 0;
        boolean[][] visitedCells = new boolean[maze.length][maze[0].length];
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                int c = traversePath(maze, visitedCells, i, j);
                //System.out.print("   " + c);
                if(c > 0){
                    regions++;
                }
                if(c > count){
                    count = c;
                }
            }
        }
        System.out.println("Total regions: " + regions);
        return count;
    }
    /**
     * Custom method By sandeep
     */
    private static int traversePath(int[][] maze, boolean[][] visitedCells, int i, int j) {
        // if index is going out or maze boundaries then return 0
        if (i < 0 || j < 0 || i >= maze.length || j >= maze[0].length) {
            return 0;
        }
        if(maze[i][j] == 0 || visitedCells[i][j] == true){
           return 0; 
        }
        visitedCells[i][j] = true;
        int count = 1;        
        // find child paths from downside cell
        count += traversePath(maze,visitedCells, i+1,j);
        count += traversePath(maze,visitedCells, i,j+1);
        count += traversePath(maze,visitedCells, i-1,j);
        count += traversePath(maze,visitedCells, i,j-1);
        count += traversePath(maze,visitedCells, i,j-1);
        // call for diagonal elements
        count += traversePath(maze,visitedCells, i+1,j-1);
        count += traversePath(maze,visitedCells, i+1,j+1);
        count += traversePath(maze,visitedCells, i-1,j+1);
        count += traversePath(maze,visitedCells, i-1,j-1);
        return count;
    }

    private static void printMaze(int[][] maze) {
        for (int i = 0; i < maze.length; ++i) {
            for (int j = 0; j < maze[i].length; ++j) {
                    System.out.print(maze[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void makeRandomMaze(int[][] maze) {
        for (int i = 0; i < maze.length; ++i) {
            for (int j = 0; j < maze[0].length; ++j) {
                maze[i][j] =  (int) (Math.random() * 2) == 1?0:1;
            }
        }
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
