/* You are given an integer array nums of length n where nums is a permutation of the numbers in the range [0, n - 1]. You should build a set s[k] = {nums[k], nums[nums[k]], nums[nums[nums[k]]], ... } subjected to the following rule:
The first element in s[k] starts with the selection of the element nums[k] of index = k.
The next element in s[k] should be nums[nums[k]], and then nums[nums[nums[k]]], and so on.
We stop adding right before a duplicate element occurs in s[k].
Return the longest length of a set s[k].

Example 1:
Input: nums = [5,4,0,3,1,6,2]
Output: 4
Explanation: 
nums[0] = 5, nums[1] = 4, nums[2] = 0, nums[3] = 3, nums[4] = 1, nums[5] = 6, nums[6] = 2.
One of the longest sets s[k]:
s[0] = {nums[0], nums[5], nums[6], nums[2]} = {5, 6, 2, 0}

Example 2:
Input: nums = [0,1,2]
Output: 1

Constraints:
1 <= nums.length <= 10^5
0 <= nums[i] < nums.length
All the values of nums are unique.
    
Link: https://leetcode.com/explore/challenge/card/september-leetcoding-challenge-2021/636/week-1-september-1st-september-7th/3960/ */

class Solution {
    public int arrayNesting(int[] nums) {
        int max = Integer.MIN_VALUE;
        
        for(int i=0; i<nums.length; i++) {
            if(nums[i]<0) {
                continue;
            } else {
                max = Math.max(max, calculateLength(nums, i));
            }
        }
        
        return max;
    }
    private int calculateLength(int[] nums, int start) {
        if(start<0 || start==nums.length || nums[start]<0) {
            return 0;
        }
        
        int next = nums[start];
        nums[start] = Integer.MIN_VALUE;
        
        return 1 + calculateLength(nums, next);
    }
}