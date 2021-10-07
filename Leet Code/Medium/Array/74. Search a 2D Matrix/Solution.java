/* Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.

Example 1:
Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
Output: true

Example 2:
Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
Output: false

Constraints:
m == matrix.length
n == matrix[i].length
1 <= m, n <= 100
-10^4 <= matrix[i][j], target <= 10^4
    
Link: https://leetcode.com/problems/search-a-2d-matrix/ */

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = findRow(matrix, target);
        
        if(row == -1) {
            return false;
        }
        
        return binarySearch(matrix, target, row);
    }
    private int findRow(int[][] matrix, int target) {
        int low = 0;
        int high = matrix.length - 1;
        int lc = matrix[0].length - 1;
        
        while(low <= high) {
            int mid = low + (high - low)/2;
            
            if(matrix[mid][0] <= target && matrix[mid][lc] >= target) {
                return mid;
            } else if(matrix[mid][0] < target) {
                low = mid + 1;
            } else if(matrix[mid][0] > target) {
                high = mid - 1;
            }
            
        }
        
        return -1;
    }
    private boolean binarySearch(int[][] matrix, int target, int row) {
        int low = 0;
        int high = matrix[0].length - 1;
        
        while(low <= high) {
            int mid = low + (high - low)/2;
            
            if(matrix[row][mid] == target) {
                return true;
            } else if(matrix[row][mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
            
        }
        
        return false;
    }
}