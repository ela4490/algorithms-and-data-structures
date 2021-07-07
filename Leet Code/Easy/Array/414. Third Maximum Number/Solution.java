/* Given integer array nums, return the third maximum number in this array. If the third maximum does not exist, return the maximum number.

Example 1:
Input: nums = [3,2,1]
Output: 1
Explanation: The third maximum is 1.

Example 2:
Input: nums = [1,2]
Output: 2
Explanation: The third maximum does not exist, so the maximum (2) is returned instead.

Example 3:
Input: nums = [2,2,3,1]
Output: 1
Explanation: Note that the third maximum here means the third maximum distinct number.
Both numbers with value 2 are both considered as second maximum.

Constraints:
1 <= nums.length <= 10^4
-2^31 <= nums[i] <= 2^31 - 1
    
Link: https://leetcode.com/problems/third-maximum-number/ */

class Solution {
    public int thirdMax(int[] nums) {
        List<Integer> list = new ArrayList();
        Set<Integer> set = new LinkedHashSet();
        for(int i=0; i<nums.length; i++){
            list.add(nums[i]);
        }
        Collections.sort(list);
        Collections.reverse(list);
        for(int i=0; i<list.size(); i++){
            set.add(list.get(i));
        }
        Iterator<Integer> i = set.iterator();
        int element = 0;
        if(set.size()<3){
            element = i.next();
        }else{
            int index = 0;
            while(i.hasNext()){
                if(index==3){
                    break;
                }
                element = i.next();
                index++;
            }
        }
        return element;
    }
}