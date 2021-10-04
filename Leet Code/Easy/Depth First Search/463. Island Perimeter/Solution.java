/* You are given row x col grid representing a map where grid[i][j] = 1 represents land and grid[i][j] = 0 represents water. Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells). The island doesn't have "lakes", meaning the water inside isn't connected to the water around the island. One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.

Example 1:
Input: grid = [[0,1,0,0],[1,1,1,0],[0,1,0,0],[1,1,0,0]]
Output: 16
Explanation: The perimeter is the 16 yellow stripes in the image above.

Example 2:
Input: grid = [[1]]
Output: 4

Example 3:
Input: grid = [[1,0]]
Output: 4

Constraints:
row == grid.length
col == grid[i].length
1 <= row, col <= 100
grid[i][j] is 0 or 1.
There is exactly one island in grid.
    
Link: https://leetcode.com/problems/island-perimeter/ */

class Solution {
    public int islandPerimeter(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                
                if(grid[i][j] == 1) return dfs(i, j, grid, visited);
                
            }
        }
        
        return 0;
    }
    
    private int dfs(int i, int j, int[][] grid, boolean[][] visited) {
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0) return 1;
        if(visited[i][j]) return 0;
        visited[i][j] = true;
        
        return dfs(i + 1, j, grid, visited) + dfs(i - 1, j, grid, visited) + dfs(i, j + 1, grid, visited) + dfs(i, j - 1, grid, visited);
    }
}