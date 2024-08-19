package solutions.pack7_Recursion;

public class GridPaths {
    public static int numberOfPaths(int [][] grid){
        int m = grid.length - 1;
        int n = grid[0].length - 1;
        return numberOfPaths_recur(m, n, grid);
    }
    public static int numberOfPaths_recur(int m, int n, int [][] grid){
        if (grid[m][n] == 1){
            return 0;
        }
        if (m == 0 || n == 0){
            return 1;
        }
        return numberOfPaths_recur(m - 1, n, grid) + numberOfPaths_recur(m, n - 1, grid);
    }
}
