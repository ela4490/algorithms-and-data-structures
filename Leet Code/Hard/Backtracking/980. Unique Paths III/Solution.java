/* You are given an m x n integer array grid where grid[i][j] could be:
1 representing the starting square. There is exactly one starting square.
2 representing the ending square. There is exactly one ending square.
0 representing empty squares we can walk over.
-1 representing obstacles that we cannot walk over.

Return the number of 4-directional walks from the starting square to the ending square, that walk over every non-obstacle square exactly once.

Example 1:
Input: grid = [[1,0,0,0],[0,0,0,0],[0,0,2,-1]]
Output: 2
Explanation: We have the following two paths: 
1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2)
2. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2)

Example 2:
Input: grid = [[1,0,0,0],[0,0,0,0],[0,0,0,2]]
Output: 4
Explanation: We have the following four paths: 
1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2),(2,3)
2. (0,0),(0,1),(1,1),(1,0),(2,0),(2,1),(2,2),(1,2),(0,2),(0,3),(1,3),(2,3)
3. (0,0),(1,0),(2,0),(2,1),(2,2),(1,2),(1,1),(0,1),(0,2),(0,3),(1,3),(2,3)
4. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2),(2,3)

Example 3:
Input: grid = [[0,1],[2,0]]
Output: 0
Explanation: There is no path that walks over every empty square exactly once.
Note that the starting and ending square can be anywhere in the grid.

Constraints:
m == grid.length
n == grid[i].length
1 <= m, n <= 20
1 <= m * n <= 20
-1 <= grid[i][j] <= 2
There is exactly one starting cell and one ending cell.
    
Link: https://leetcode.com/problems/unique-paths-iii/ */

class Solution {
	public int uniquePathsIII(int[][] grid) {
		int zero = 0; // Count the 0's
		int sx = 0; // starting x index
		int sy = 0; // starting y index

		for(int r = 0; r < grid.length; r++){ // r = row
			for(int c = 0; c < grid[0].length; c++) { // c = column
				
                		if(grid[r][c] == 0) zero++; // if current cell is 0, count it.
				else if(grid[r][c] == 1) {
					sx = r; // starting x co-ordinate
					sy = c; // starting y co-ordinate
				}
                
			}
		}
        
		return dfs(grid, sx, sy, zero);
	}
	
	public int dfs(int grid[][], int x, int y, int zero) {
		
        	// Base Condition
		if(x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] == -1) {
			return 0;
		}
		
        	if(grid[x][y] == 2) {
			return zero == -1 ? 1 : 0; // Why zero = -1, because in above example we have 9 zero's. So, when we reach the final cell we are covering one cell extra then the zero count.
			// If that's the case we find the path and return '1' otherwise return '0';
		}
		
        	grid[x][y] = -1; // mark the visited cells as -1;
		zero--; // and reduce the zero by 1

		int totalPaths = dfs(grid, x + 1, y, zero) + // calculating all the paths available in 4 directions
						 dfs(grid, x - 1, y, zero) +
						 dfs(grid, x, y + 1, zero) +
						 dfs(grid, x, y - 1, zero);

		// Let's say if we are not able to count all the paths. Now we use Backtracking over here
		grid[x][y] = 0;
		zero++;

		return totalPaths; // if we get all the paths, simply return it.
	}
}