/* You are given an m x n grid where each cell can have one of three values:
0 representing an empty cell,
1 representing a fresh orange, or
2 representing a rotten orange.

Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten. Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.

Example 1:
Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
Output: 4

Example 2:
Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
Output: -1
Explanation: The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.

Example 3:
Input: grid = [[0,2]]
Output: 0
Explanation: Since there are already no fresh oranges at minute 0, the answer is just 0.

Constraints:
m == grid.length
n == grid[i].length
1 <= m, n <= 10
grid[i][j] is 0, 1, or 2.
    
Link: https://leetcode.com/problems/rotting-oranges/ */

class Solution {
    public int orangesRotting(int[][] grid) {
        Set<String> rotten = new HashSet<>();
        Set<String> fresh = new HashSet<>();
        
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                
                if(grid[i][j] == 1) {
                    fresh.add(i + "_" + j);
                } else if(grid[i][j] == 2) {
                    rotten.add(i + "_" + j);
                }
                
            }
        }
        
        int[][] directions = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        int minutes = 0;
        
        while(fresh.size() > 0) {
            Set<String> infected = new HashSet<>();
            
            for(String s : rotten) {
                int i = s.charAt(0) - '0';
                int j = s.charAt(2) - '0';
                
                for(int[] direction : directions) {
                    int nextI = i + direction[0];
                    int nextJ = j + direction[1];
                    
                    if(fresh.contains(nextI + "_" + nextJ)) {
                        fresh.remove(nextI + "_" + nextJ);
                        infected.add(nextI + "_" + nextJ);
                    }
                }
            }
            
            if(infected.size() == 0) {
                return -1;
            }
            
            rotten = infected;
            minutes++;
        }
        
        return minutes;
    }
}