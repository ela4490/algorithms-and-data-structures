/* You are given an m x n integer matrix grid where each cell is either 0 (empty) or 1 (obstacle). You can move up, down, left, or right from and to an empty cell in one step. Return the minimum number of steps to walk from the upper left corner (0, 0) to the lower right corner (m - 1, n - 1) given that you can eliminate at most k obstacles. If it is not possible to find such walk return -1.

Example 1:
Input: 
grid = 
[[0,0,0],
 [1,1,0],
 [0,0,0],
 [0,1,1],
 [0,0,0]], 
k = 1
Output: 6
Explanation: 
The shortest path without eliminating any obstacle is 10. 
The shortest path with one obstacle elimination at position (3,2) is 6. Such path is (0,0) -> (0,1) -> (0,2) -> (1,2) -> (2,2) -> (3,2) -> (4,2).

Example 2:
Input: 
grid = 
[[0,1,1],
 [1,1,1],
 [1,0,0]], 
k = 1
Output: -1
Explanation: 
We need to eliminate at least two obstacles to find such a walk.

Constraints:
m == grid.length
n == grid[i].length
1 <= m, n <= 40
1 <= k <= m * n
grid[i][j] == 0 or 1
grid[0][0] == grid[m - 1][n - 1] == 0
    
Link: https://leetcode.com/explore/challenge/card/september-leetcoding-challenge-2021/639/week-4-september-22nd-september-28th/3987/ */

class Solution {
    private int[][] dir = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
    
    public int shortestPath(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        
        if(m == 0 || n == 0) return 0;
        
        int[][] obstacle = new int[m][n];
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        int level = 1;
        
        queue.add(new int[]{0, 0, grid[0][0]});
        obstacle[0][0] = grid[0][0];
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            
            while(size-- > 0) {
                int[] head = queue.poll();
                
                if(head[0] == m - 1 && head[1] == n - 1) return level - 1;
                
                int currentObstacle = head[2];
                
                for(int[] d : dir) {
                    int x = d[0] + head[0];
                    int y = d[1] + head[1];
                    
                    if(!(x >= 0 && y >= 0 && x < m && y < n)) continue;
                    
                    int oldObstacle = obstacle[x][y];
                    int newObstacle = currentObstacle + grid[x][y];
                    
                    if((!visited[x][y]) && newObstacle <= k) {
                        queue.add(new int[]{x, y, newObstacle});
                        obstacle[x][y] = newObstacle;
                        visited[x][y] = true;
                    }
                    
                    if(oldObstacle > newObstacle && newObstacle <= k) {
                        queue.add(new int[]{x, y, newObstacle});
                        obstacle[x][y] = newObstacle;
                        visited[x][y] = true;
                    }
                }
            }
            
            level++;
        }
        
        return -1;
    }
}