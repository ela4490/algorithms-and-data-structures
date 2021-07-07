/* Given an integer numRows, return the first numRows of Pascal's triangle. In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:

Example 1:
Input: numRows = 5
Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]

Example 2:
Input: numRows = 1
Output: [[1]]

Constraints:
1 <= numRows <= 30
    
Link: https://leetcode.com/problems/pascals-triangle/ */

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList();
        if(numRows==0){
            return result;
        }
        List<Integer> first_row = new ArrayList();
        first_row.add(1);
        result.add(first_row);
        
        for(int i=1; i<numRows; i++){
            List<Integer> prev_row = result.get(i-1);
            List<Integer> row = new ArrayList();
            
            row.add(1);
            for(int j=1; j<i; j++){
                row.add(prev_row.get(j-1)+prev_row.get(j));
            }
            row.add(1);
            result.add(row);
        }
        return result;
    }
}