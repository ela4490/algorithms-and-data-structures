/* You are given an integer array nums and you have to return a new counts array. The counts array has the property where counts[i] is the number of smaller elements to the right of nums[i].

Example 1:
Input: nums = [5,2,6,1]
Output: [2,1,1,0]
Explanation:
To the right of 5 there are 2 smaller elements (2 and 1).
To the right of 2 there is only 1 smaller element (1).
To the right of 6 there is 1 smaller element (1).
To the right of 1 there is 0 smaller element.

Example 2:
Input: nums = [-1]
Output: [0]

Example 3:
Input: nums = [-1,-1]
Output: [0,0]

Constraints:
1 <= nums.length <= 10^5
-10^4 <= nums[i] <= 10^4
    
Link: https://leetcode.com/problems/count-of-smaller-numbers-after-self/ */

class Solution {
    public List<Integer> countSmaller(int[] nums) {
        if(nums == null || nums.length == 0) return new ArrayList();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        for(int i=0; i<nums.length; i++){
           min = Math.min(min, nums[i]);
        }
        
        for(int i=0; i<nums.length; i++){
            nums[i] = nums[i]-min+1;
            max = Math.max(max, nums[i]);
        }
        List<Integer> res = new ArrayList();
        int[] fenwickTree = new int[max+1];
        
        for(int i=nums.length-1; i>=0; i--){
            res.add(0, getSum(fenwickTree, nums[i]-2));
            updateFenwickTree(fenwickTree, nums[i]-1, 1);
        }
        return res;
    }
    public int getSum(int[] fenwickTree, int index){
        int sum = 0;
        for(int i=index+1; i>0; i-=i & (-i)){
            sum += fenwickTree[i];
        }
        return sum;
    }
    public void updateFenwickTree(int[] fenwickTree, int index, int value){
        for(int i=index+1; i<fenwickTree.length; i+=i & (-i)){
            fenwickTree[i] += value;
        }
    }
}