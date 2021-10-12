/* Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.

Example 1:
Input: nums = [-4,-1,0,3,10]
Output: [0,1,9,16,100]
Explanation: After squaring, the array becomes [16,1,0,9,100].
After sorting, it becomes [0,1,9,16,100].

Example 2:
Input: nums = [-7,-3,2,3,11]
Output: [4,9,9,49,121]

Constraints:
1 <= nums.length <= 10^4
-10^4 <= nums[i] <= 10^4
nums is sorted in non-decreasing order.
 
Follow up: Squaring each element and sorting the new array is very trivial, could you find an O(n) solution using a different approach?
    
Link: https://leetcode.com/problems/squares-of-a-sorted-array/ */

//Time Complexity : O(N)
class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];
        
        for(int k = 0; k < nums.length; k++) {
            nums[k] = nums[k] * nums[k];
        }
        
        int i = 0;
        int j = nums.length - 1;
        
        for(int k = nums.length - 1; k >= 0; k--) {
            if(nums[i] <= nums[j]) {
                result[k] = nums[j];
                j--;
            } else {
                result[k] = nums[i];
                i++;
            }
        }
        
        return result;
    }
}