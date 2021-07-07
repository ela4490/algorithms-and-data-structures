/* Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).

Example 1:
Input: root = [1,2,2,3,4,4,3]
Output: true

Example 2:
Input: root = [1,2,2,null,3,null,3]
Output: false

Constraints:
The number of nodes in the tree is in the range [1, 1000].
-100 <= Node.val <= 100
 
Follow up: Could you solve it both recursively and iteratively?
    
Link: https://leetcode.com/problems/symmetric-tree/ */

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] values = new int[2];
        for(int i = 0; i < nums.length; i++) {
            for(int j = i+1; j < nums.length; j++) {
                if (target == (nums[i] + nums[j])) {
                    values[0] = i;
                    values[1] = j;
                }
            }
        }
        return values;
    }
}