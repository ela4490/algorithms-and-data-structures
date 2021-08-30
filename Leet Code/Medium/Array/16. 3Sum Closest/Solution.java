/* Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

Example 1:
Input: nums = [-1,2,1,-4], target = 1
Output: 2
Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).

Example 2:
Input: nums = [0,0,0], target = 1
Output: 0

Constraints:
3 <= nums.length <= 1000
-1000 <= nums[i] <= 1000
-104 <= target <= 10^4
    
Link: https://leetcode.com/problems/3sum-closest/ */

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closestSum = nums[0]+nums[1]+nums[nums.length-1];
        int start = 0;
        int end = 0;
        
        for(int i=0; i<nums.length-2; i++) {
            start = i+1;
            end = nums.length-1;
            
            while(start<end) {
                int currentSum = nums[i] + nums[start] + nums[end];
                if(currentSum<target) {
                    start++;
                } else {
                    end--;
                }
                if(Math.abs(target-currentSum)<Math.abs(target-closestSum)) {
                    closestSum = currentSum;
                }
            }
        }
        return closestSum;
    }
}