/* Given an array of integers arr of even length, return true if and only if it is possible to reorder it such that arr[2 * i + 1] = 2 * arr[2 * i] for every 0 <= i < len(arr) / 2.

Example 1:
Input: arr = [3,1,3,6]
Output: false

Example 2:
Input: arr = [2,1,2,6]
Output: false

Example 3:
Input: arr = [4,-2,2,-4]
Output: true
Explanation: We can take two groups, [-2,-4] and [2,4] to form [-2,-4,2,4] or [2,4,-2,-4].

Example 4:
Input: arr = [1,2,4,16,8,4]
Output: false

Constraints:
0 <= arr.length <= 3 * 10^4
arr.length is even.
-10^5 <= arr[i] <= 10^5
    
Link: https://leetcode.com/explore/challenge/card/august-leetcoding-challenge-2021/614/week-2-august-8th-august-14th/3877/ */

class Solution {
    public boolean canReorderDoubled(int[] arr) {
        Map<Integer, Integer> map = new TreeMap<>();
        
        for(int el : arr){
            map.put(el, map.getOrDefault(el, 0)+1);
        }
        
        for(int el : map.keySet()){
            if(map.getOrDefault(el, 0)>0){
                int target = el<0 ? el/2 : el*2;
                
                if(el<0 && el%2!=0){
                    return false;
                }
                
                if(map.get(el)>map.getOrDefault(target, 0)){
                    return false;
                }
                map.put(target, map.get(target)-map.get(el));
            }
        }
        return true;
    }
}