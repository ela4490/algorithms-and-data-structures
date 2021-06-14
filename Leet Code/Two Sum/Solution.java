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