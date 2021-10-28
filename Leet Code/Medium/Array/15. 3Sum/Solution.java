/* Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0. Notice that the solution set must not contain duplicate triplets.

Example 1:
Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]

Example 2:
Input: nums = []
Output: []

Example 3:
Input: nums = [0]
Output: []

Constraints:
0 <= nums.length <= 3000
-10^5 <= nums[i] <= 10^5
    
Link: https://leetcode.com/problems/3sum/ */

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        
        Arrays.sort(nums);
        
        for(int i = 0; i < nums.length; i++) {
            
            int target = -nums[i];
            int j = i + 1;
            int k = nums.length - 1;
            
            while(j < k) {
                
                if(nums[j] + nums[k] == target) {
                    List<Integer> sub = new ArrayList<>();
                    sub.add(nums[i]);
                    sub.add(nums[j]);
                    sub.add(nums[k]);
                    set.add(sub);
                    j++;
                    k--;
                } else if(nums[j] + nums[k] > target) {
                    k--;
                } else{
                    j++;
                }
                
            }
        }
        
        return new ArrayList<>(set);
    }
}