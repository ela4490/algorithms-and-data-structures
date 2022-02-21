/* Given an array nums of size n, return the majority element. The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.

Example 1:
Input: nums = [3,2,3]
Output: 3

Example 2:
Input: nums = [2,2,1,1,1,2,2]
Output: 2

Constraints:
n == nums.length
1 <= n <= 5 * 104
-2^31 <= nums[i] <= 2^31 - 1
    
Link: https://leetcode.com/problems/majority-element/ */

// Time Complexity : O(NlogN)
class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}

// Time Complexity : O(N)
class Solution {
    public int majorityElement(int[] nums) {
        int majority = nums[0];
        int count = 1;
        
        for(int i = 1; i < nums.length; i++) {
            
            if(majority == nums[i]) count++;
            else count--;
            
            if(count == 0) {
                majority = nums[i];
                count = 1;
            }
            
        }
        
        return majority;
    }
}