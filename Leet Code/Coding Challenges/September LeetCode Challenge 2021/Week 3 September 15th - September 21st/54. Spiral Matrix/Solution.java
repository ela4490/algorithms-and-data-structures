/* Given an m x n matrix, return all elements of the matrix in spiral order.

Example 1:
Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,3,6,9,8,7,4,5]

Example 2:
Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]

Constraints:
m == matrix.length
n == matrix[i].length
1 <= m, n <= 10
-100 <= matrix[i][j] <= 100
    
Link: https://leetcode.com/explore/challenge/card/september-leetcoding-challenge-2021/638/week-3-september-15th-september-21st/3977/ */

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int startRow = 0;
        int endRow = matrix.length - 1;
        int startColumn = 0;
        int endColumn = matrix[0].length - 1;
        
        if(matrix.length == 0) {
            return result;
        }
        
        while(startRow <= endRow && startColumn <= endColumn) {
            
            for(int i = startColumn; i <= endColumn; i++) {
                result.add(matrix[startRow][i]);
            }
            startRow++;
            
            for(int i = startRow; i <= endRow; i++) {
                result.add(matrix[i][endColumn]);
            }
            endColumn--;
            
            if(startRow <= endRow) {
                for(int i = endColumn; i >= startColumn; i--) {
                    result.add(matrix[endRow][i]);
                }
            }
            endRow--;
            
            if(startColumn <= endColumn) {
                for(int i = endRow; i>= startRow; i--) {
                    result.add(matrix[i][startColumn]);
                }
            }
            startColumn++;
        }
        
        return result;
    }
}