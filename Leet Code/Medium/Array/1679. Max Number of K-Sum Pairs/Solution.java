/* You are given an integer array nums and an integer k. In one operation, you can pick two numbers from the array whose sum equals k and remove them from the array. Return the maximum number of operations you can perform on the array.

Example 1:
Input: nums = [1,2,3,4], k = 5
Output: 2
Explanation: Starting with nums = [1,2,3,4]:
- Remove numbers 1 and 4, then nums = [2,3]
- Remove numbers 2 and 3, then nums = []
There are no more pairs that sum up to 5, hence a total of 2 operations.

Example 2:
Input: nums = [3,1,3,4,3], k = 6
Output: 1
Explanation: Starting with nums = [3,1,3,4,3]:
- Remove the first two 3's, then nums = [1,4,3]
There are no more pairs that sum up to 6, hence a total of 1 operation.

Constraints:
1 <= nums.length <= 10^5
1 <= nums[i] <= 10^9
1 <= k <= 10^9
    
Link: https://leetcode.com/problems/max-number-of-k-sum-pairs/ */

Time Complexity : O(N)
class Solution {
    public int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        
        for(int i : nums) {
            if(map.containsKey(k - i)) {
                int freq = map.get(k - i);
                count++;
                
                if(freq == 1) {
                    map.remove(k - i);
                } else {
                    map.put(k - i, freq - 1);
                }
            } else {
                map.put(i, map.getOrDefault(i, 0) + 1);
            }
        }
        
        return count;
    }
}

Time Complexity : O(NLogN)
class Solution {
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int start = 0;
        int end = nums.length - 1;
        int count = 0;
        
        while(start < end) {
            int sum = nums[start] + nums[end];
            
            if(sum < k) {
                start++;
            } else if(sum > k){
                end--;
            } else {
                end--;
                start++;
                count++;
            }
        }
        
        return count;
    }
}