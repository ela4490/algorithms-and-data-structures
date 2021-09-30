/* Given an integer array nums and an integer k, return true if it is possible to divide this array into k non-empty subsets whose sums are all equal.

Example 1:
Input: nums = [4,3,2,3,5,2,1], k = 4
Output: true
Explanation: It's possible to divide it into 4 subsets (5), (1, 4), (2,3), (2,3) with equal sums.

Example 2:
Input: nums = [1,2,3,4], k = 3
Output: false

Constraints:
1 <= k <= nums.length <= 16
1 <= nums[i] <= 10^4
The frequency of each element is in the range [1, 4].

Link: https://leetcode.com/problems/partition-to-k-equal-sum-subsets/ */

class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int total = 0;
        boolean[] visited = new boolean[nums.length];
        
        for(int i : nums) {
            total += i;
        }
        
        if(total % k != 0) return false;
        if(nums.length < k) return false;
        
        int subsetSum = total/k;
        
        return partition(nums, visited, 0, k, 0, subsetSum);
    }
    
    private boolean partition(int[] nums, boolean[] visited, int start, int k, int currentSum, int subsetSum) {
        if(k == 0) return true;
        if(currentSum > subsetSum) return false;
        if(currentSum == subsetSum) return partition(nums, visited, 0, k - 1, 0, subsetSum);
        
        for(int i = start; i < nums.length; i++) {
            if(visited[i]) continue;
            visited[i] = true;
            if(partition(nums, visited, i + 1, k, currentSum + nums[i], subsetSum)) return true;
            visited[i] = false;
        }
        
        return false;
    }
}