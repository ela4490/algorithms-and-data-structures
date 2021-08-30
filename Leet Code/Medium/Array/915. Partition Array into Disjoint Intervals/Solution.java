/* Given an integer array nums, partition it into two (contiguous) subarrays left and right so that:
Every element in left is less than or equal to every element in right.
left and right are non-empty.
left has the smallest possible size.
Return the length of left after such a partitioning. Test cases are generated such that partitioning exists.

Example 1:
Input: nums = [5,0,3,8,6]
Output: 3
Explanation: left = [5,0,3], right = [8,6]

Example 2:
Input: nums = [1,1,1,0,6,12]
Output: 4
Explanation: left = [1,1,1,0], right = [6,12]

Constraints:
2 <= nums.length <= 10^5
0 <= nums[i] <= 10^6
There is at least one valid answer for the given input.
    
Link: https://leetcode.com/problems/partition-array-into-disjoint-intervals/ */

class Solution {
    public int partitionDisjoint(int[] nums) {
        int[] lmax = new int[nums.length];
        int[] rmax = new int[nums.length];
        
        int max = Integer.MIN_VALUE;
        for(int i=0; i<nums.length; i++) {
            max = Math.max(max, nums[i]);
            lmax[i] = max;
        }
        
        int min = Integer.MAX_VALUE;
        for(int i=nums.length-1; i>=0; i--) {
            min = Math.min(min, nums[i]);
            rmax[i] = min;
        }
        
        for(int i=1; i<nums.length; i++) {
            if(lmax[i-1]<=rmax[i]) {
                return i;
            }
        }
        
        return nums.length;
    }
}