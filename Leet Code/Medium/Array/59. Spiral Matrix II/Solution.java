/* Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.

Example 1:
Input: n = 3
Output: [[1,2,3],[8,9,4],[7,6,5]]

Example 2:
Input: n = 1
Output: [[1]]

Constraints:
1 <= n <= 20
    
Link: https://leetcode.com/problems/spiral-matrix-ii/ */

class Solution {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        
        if(n == 0) {
            return result;
        }
        
        int startRow = 0;
        int endRow = n - 1;
        int startColumn = 0;
        int endColumn = n - 1;
        int count = 1;
        
        while(startRow <= endRow && startColumn <= endColumn) {
            
            for(int i = startColumn; i <= endColumn; i++) {
                result[startRow][i] = count++;
            }
            
            startRow++;
            
            for(int i = startRow; i <= endRow; i++) {
                result[i][endColumn] = count++;
            }
            
            endColumn--;
            
            if(startRow <= endRow) {
                for(int i = endColumn; i >= startColumn; i--) {
                    result[endRow][i] = count++;
                }
            }
            
            endRow--;
            
            if(startColumn <= endColumn) {
                for(int i = endRow; i >= startRow; i--) {
                    result[i][startColumn] = count++;
                }
            }
            
            startColumn++;
        }
        
        return result;
    }
}