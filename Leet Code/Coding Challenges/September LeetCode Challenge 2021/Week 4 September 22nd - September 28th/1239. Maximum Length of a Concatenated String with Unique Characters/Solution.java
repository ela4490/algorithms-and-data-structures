/* Given an array of strings arr. String s is a concatenation of a sub-sequence of arr which have unique characters. Return the maximum possible length of s.

Example 1:
Input: arr = ["un","iq","ue"]
Output: 4
Explanation: All possible concatenations are "","un","iq","ue","uniq" and "ique".
Maximum length is 4.

Example 2:
Input: arr = ["cha","r","act","ers"]
Output: 6
Explanation: Possible solutions are "chaers" and "acters".

Example 3:
Input: arr = ["abcdefghijklmnopqrstuvwxyz"]
Output: 26

Constraints:
1 <= arr.length <= 16
1 <= arr[i].length <= 26
arr[i] contains only lower case English letters.
    
Link: https://leetcode.com/explore/challenge/card/september-leetcoding-challenge-2021/639/week-4-september-22nd-september-28th/3984/ */

class Solution {
    public int maxLength(List<String> arr) {
        List<String> result = new ArrayList<>();
        int ans = 0;
        
        result.add("");
        
        for(String str : arr) {
            if(!validate(str)) continue;
            List<String> tempList = new ArrayList<>();
            
            for(String s : result) {
                String temp = s + str;
                
                if(validate(temp)) {
                    tempList.add(temp);
                    ans = Math.max(ans, temp.length());
                }
                
            }
            
            result.addAll(tempList);
        }
        
        return ans;
    }
    
    private boolean validate(String str) {
        int[] freq = new int[26];
        
        for(char ch : str.toCharArray()) {
            if(freq[ch - 'a']++ > 0) {
                return false;
            }
        }
        
        return true;
    }
}