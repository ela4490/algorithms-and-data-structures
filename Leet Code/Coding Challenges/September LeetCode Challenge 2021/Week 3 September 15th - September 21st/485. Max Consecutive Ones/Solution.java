/* Given a binary array nums, return the maximum number of consecutive 1's in the array.

Example 1:
Input: nums = [1,1,0,1,1,1]
Output: 3
Explanation: The first two digits or the last three digits are consecutive 1s. The maximum number of consecutive 1s is 3.

Example 2:
Input: nums = [1,0,1,1,0,1]
Output: 2

Constraints:
1 <= nums.length <= 10^5
nums[i] is either 0 or 1.
    
Link: https://leetcode.com/explore/challenge/card/september-leetcoding-challenge-2021/638/week-3-september-15th-september-21st/3982/ */

//Optimized Solution with Time Complexity : O(n)
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = nums[0];
        
        for(int i = 1; i < nums.length; i++) {
            
            if(nums[i] == 1) {
                nums[i] += nums[i - 1];
            }
            
            count = Math.max(count, nums[i]);
        }
        
        return count;
    }
}

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 1) {
                int j = i + 1;
            
                while(j < nums.length && nums[i] == nums[j]) {
                    j++;
                }
            
                count = Math.max(count, j - i);
            }
            
        }
        
        return count;
    }
}