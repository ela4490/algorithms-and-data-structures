/* Given a m * n matrix of distinct numbers, return all lucky numbers in the matrix in any order. A lucky number is an element of the matrix such that it is the minimum element in its row and maximum in its column.

Example 1:
Input: matrix = [[3,7,8],[9,11,13],[15,16,17]]
Output: [15]
Explanation: 15 is the only lucky number since it is the minimum in its row and the maximum in its column

Example 2:
Input: matrix = [[1,10,4,2],[9,3,8,7],[15,16,17,12]]
Output: [12]
Explanation: 12 is the only lucky number since it is the minimum in its row and the maximum in its column.

Example 3:
Input: matrix = [[7,8],[1,2]]
Output: [7]

Constraints:
m == mat.length
n == mat[i].length
1 <= n, m <= 50
1 <= matrix[i][j] <= 10^5.
All elements in the matrix are distinct.
    
Link: https://leetcode.com/problems/lucky-numbers-in-a-matrix/ */

class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        List<Integer> minValues = new ArrayList<Integer>();
        List<Integer> maxValues = new ArrayList<Integer>();
        List<Integer> result = new ArrayList();
        for(int row=0; row<matrix.length; row++){
            for(int col=0; col<matrix[row].length; col++){
                min = Math.min(min, matrix[row][col]);
            }
            minValues.add(min);
            min = Integer.MAX_VALUE;
        }
        for(int col=0; col<matrix[0].length; col++){
            for(int row=0; row<matrix.length; row++){
                max = Math.max(max, matrix[row][col]);
            }
            maxValues.add(max);
            max = Integer.MIN_VALUE;
        }
        
        for(int i=0; i<minValues.size(); i++){
            for(int j=0; j<maxValues.size(); j++){
                if(minValues.get(i).equals(maxValues.get(j))){
                    result.add(minValues.get(i));
                }
            }
        }
        return result;
    }
}
