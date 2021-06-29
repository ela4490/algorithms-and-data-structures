/* Given an array nums of non-negative integers, return an array consisting of all the even elements of nums, followed by all the odd elements of nums. You may return any answer array that satisfies this condition.

Example 1:
Input: nums = [3,1,2,4]
Output: [2,4,3,1]
The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.

Note:
1 <= nums.length <= 5000
0 <= nums[i] <= 5000
    
Link: https://leetcode.com/problems/sort-array-by-parity/ */

class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int[] result = new int[nums.length];
        List<Integer> list = new ArrayList();
        for(int i=0; i<nums.length; i++){
            if(nums[i]%2==0){
                list.add(nums[i]);
            }
        }
        for(int i=0; i<nums.length; i++){
            if(nums[i]%2!=0){
                list.add(nums[i]);
            }
        }
        for(int i=0; i<nums.length; i++){
            result[i] = list.get(i);
        }
        return result;
    }
}
