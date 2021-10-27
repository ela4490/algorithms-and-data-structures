/* Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue. We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively. You must solve this problem without using the library's sort function.

Example 1:
Input: nums = [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]

Example 2:
Input: nums = [2,0,1]
Output: [0,1,2]

Example 3:
Input: nums = [0]
Output: [0]

Example 4:
Input: nums = [1]
Output: [1]

Constraints:
n == nums.length
1 <= n <= 300
nums[i] is 0, 1, or 2.

Follow up: Could you come up with a one-pass algorithm using only constant extra space?

Link: https://leetcode.com/problems/sort-colors/ */

//One Pass
class Solution {
    public void sortColors(int[] nums) {
        int zeroIndex = 0;
        int twoIndex = nums.length - 1;
        
        for(int i = zeroIndex; i <= twoIndex;) {
            
            if(nums[i] == 0) {
                swap(nums, zeroIndex, i);
                i++;
                zeroIndex++;
            } else if(nums[i] == 2) {
                swap(nums, twoIndex, i);
                twoIndex--;
            } else {
                i++;
            }
        }
    }
    
    private void swap(int[] nums, int start, int end) {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }
}

//Two Pass
class Solution {
    public void sortColors(int[] nums) {
        int zero = 0;
        int one = 0;
        int two = 0;
        
        for(int i = 0; i < nums.length; i++) {
            
            if(nums[i] == 0) zero++;
            else if(nums[i] == 1) one++;
            else two++;
        
        }
        
        int index = 0;
        while(zero > 0) {
            nums[index] = 0;
            zero--;
            index++;
        }
            
        while(one > 0) {
            nums[index] = 1;
            one--;
            index++;
        }
            
        while(two > 0) {
            nums[index] = 2;
            two--;
            index++;
        }
        
    }
}