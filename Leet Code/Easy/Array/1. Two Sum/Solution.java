/* Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target. You may assume that each input would have exactly one solution, and you may not use the same element twice. You can return the answer in any order.

Example 1:
Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Output: Because nums[0] + nums[1] == 9, we return [0, 1].

Example 2:
Input: nums = [3,2,4], target = 6
Output: [1,2]

Example 3:
Input: nums = [3,3], target = 6
Output: [0,1]

Constraints:
2 <= nums.length <= 10^4
-10^9 <= nums[i] <= 10^9
-10^9 <= target <= 10^9
Only one valid answer exists.
    
Link: https://leetcode.com/problems/two-sum/ */

// Brute Force Approach with Time Complexity : O(N^2)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] values = new int[2];
        
        for(int i = 0; i < nums.length; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                if (target == (nums[i] + nums[j])) {
                    values[0] = i;
                    values[1] = j;
                }
            }
        }
        
        return values;
    }
}

// Using HashMap with Time Complexity : O(N)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < nums.length; i++) {
            int difference = target - nums[i];
            if(map.containsKey(difference)) {
                result[0] = i;
                result[1] = map.get(difference);
            }
            map.put(nums[i], i);
        }
        
        return result;
    }
}
