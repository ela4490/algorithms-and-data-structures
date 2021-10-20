/* Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.

Example 1:
Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

Example 2:
Input: nums = [0,1]
Output: [[0,1],[1,0]]

Example 3:
Input: nums = [1]
Output: [[1]]

Constraints:
1 <= nums.length <= 6
-10 <= nums[i] <= 10
All the integers of nums are unique.

Link: https://leetcode.com/problems/permutations/ */

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), result);
        
        return result;
    }
    
    private void backtrack(int[] nums, int start, List<Integer> current, List<List<Integer>> result) {
        if(nums.length == current.size()) {
            result.add(new ArrayList(current));
            return;
        }
        
        for(int i = 0; i <= current.size(); i++) {
            current.add(i, nums[start]);
            backtrack(nums, start + 1, current, result);
            current.remove(i);
        }
    }
}