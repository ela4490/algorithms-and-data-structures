/* Given an m x n binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.

Example 1:
Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
Output: 4

Example 2:
Input: matrix = [["0","1"],["1","0"]]
Output: 1

Example 3:
Input: matrix = [["0"]]
Output: 0

Constraints:
m == matrix.length
n == matrix[i].length
1 <= m, n <= 300
matrix[i][j] is '0' or '1'.
    
Link: https://leetcode.com/problems/maximal-square/ */

class Solution {
    public int maximalSquare(char[][] matrix) {
        
        if(matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        
        int[][] dp = new int[matrix.length + 1][matrix[0].length + 1];
        int ans = 0;
        
        for(int i = 1; i <= matrix.length; i++) {
            for(int j = 1; j <= matrix[0].length; j++) {
                if(matrix[i - 1][j - 1] == '1') {
                    int min = Integer.MAX_VALUE;
                    min = Math.min(dp[i - 1][j], min);
                    min = Math.min(dp[i][j - 1], min);
                    min = Math.min(dp[i - 1][j - 1], min);
                
                    dp[i][j] = min + 1;
                    ans = Math.max(dp[i][j], ans);
                }
            }
        }
        
        return ans * ans;
    }
}