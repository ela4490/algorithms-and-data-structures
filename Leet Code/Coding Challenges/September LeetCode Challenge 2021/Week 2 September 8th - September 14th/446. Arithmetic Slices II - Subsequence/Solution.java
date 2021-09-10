/* Given an integer array nums, return the number of all the arithmetic subsequences of nums. A sequence of numbers is called arithmetic if it consists of at least three elements and if the difference between any two consecutive elements is the same. For example, [1, 3, 5, 7, 9], [7, 7, 7, 7], and [3, -1, -5, -9] are arithmetic sequences. For example, [1, 1, 2, 5, 7] is not an arithmetic sequence. A subsequence of an array is a sequence that can be formed by removing some elements (possibly none) of the array. For example, [2,5,10] is a subsequence of [1,2,1,2,4,1,5,10]. The test cases are generated so that the answer fits in 32-bit integer.

Example 1:
Input: nums = [2,4,6,8,10]
Output: 7
Explanation: All arithmetic subsequence slices are:
[2,4,6]
[4,6,8]
[6,8,10]
[2,4,6,8]
[4,6,8,10]
[2,4,6,8,10]
[2,6,10]

Example 2:
Input: nums = [7,7,7,7,7]
Output: 16
Explanation: Any subsequence of this array is arithmetic.

Constraints:
1  <= nums.length <= 1000
-2^31 <= nums[i] <= 2^31 - 1
    
Link: https://leetcode.com/explore/challenge/card/september-leetcoding-challenge-2021/637/week-2-september-8th-september-14th/3970/ */

class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int result = 0;
        HashMap<Integer, Integer>[] map = new HashMap[nums.length];
        
        for(int i = 0; i < nums.length; i++) {
            map[i] = new HashMap<>();
        }
        
        for(int i = 1; i < map.length; i++) {
            for(int j = 0; j < i; j++) {
                long cd = (long)nums[i] - (long)nums[j];
                
                if(cd <= Integer.MIN_VALUE || cd >= Integer.MAX_VALUE) {
                    continue;
                }
                
                int APJ = map[j].getOrDefault((int)cd, 0);
                int API = map[i].getOrDefault((int)cd, 0);
                
                result += APJ;
                map[i].put((int)cd, API + APJ + 1);
            }
        }
        return result;
    }
}