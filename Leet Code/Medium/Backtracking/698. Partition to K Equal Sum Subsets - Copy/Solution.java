/* Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.

Example 1:
Input: nums = [1,1,2]
Output:
[[1,1,2],
 [1,2,1],
 [2,1,1]]

Example 2:
Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

Constraints:
1 <= nums.length <= 8
-10 <= nums[i] <= 10

Link: https://leetcode.com/problems/permutations-ii/ */

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        boolean[] visited = new boolean[nums.length];
        
        if(nums.length == 0) {
            return result;
        }
        
        permuteUniqueHelper(set, nums, visited, new ArrayList<>());
        for(List<Integer> list : set) {
            result.add(list);
        }
        return result;
    }
    
    private void permuteUniqueHelper(Set<List<Integer>> result, int[] nums, boolean[] visited, List<Integer> subList) {
        if(subList.size() == nums.length) {
            result.add(new ArrayList(subList));
            return;
        }
        
        for(int i = 0; i < nums.length; i++) {
            if(!visited[i]) {
                subList.add(nums[i]);
                visited[i] = true;
                permuteUniqueHelper(result, nums, visited, subList);
                visited[i] = false;
                subList.remove(subList.size() - 1);
            }
        }
    }
}