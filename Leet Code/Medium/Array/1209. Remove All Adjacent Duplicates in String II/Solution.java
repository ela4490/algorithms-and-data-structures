/* You are given a string s and an integer k, a k duplicate removal consists of choosing k adjacent and equal letters from s and removing them, causing the left and the right side of the deleted substring to concatenate together. We repeatedly make k duplicate removals on s until we no longer can. Return the final string after all such duplicate removals have been made. It is guaranteed that the answer is unique.

Example 1:
Input: s = "abcd", k = 2
Output: "abcd"
Explanation: There's nothing to delete.

Example 2:
Input: s = "deeedbbcccbdaa", k = 3
Output: "aa"
Explanation: 
First delete "eee" and "ccc", get "ddbbbdaa"
Then delete "bbb", get "dddaa"
Finally delete "ddd", get "aa"

Example 3:
Input: s = "pbbcggttciiippooaais", k = 2
Output: "ps"

Constraints:
1 <= s.length <= 10^5
2 <= k <= 10^4
s only contains lower case English letters.

Link: https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/ */

class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<Pair<Character, Integer>> st = new Stack<>();
        
        for(char c : s.toCharArray()) {
            
            if(st.isEmpty() || st.peek().getKey() != c) {
                st.push(new Pair<>(c, 1));
            } else {
                Pair<Character, Integer> head = st.pop();
                st.push(new Pair<>(head.getKey(), head.getValue() + 1));
                
                if(st.peek().getValue() == k) {
                    st.pop();
                }
            }
        }
        
        StringBuilder result = new StringBuilder();
        
        while(!st.isEmpty()) {
            Pair<Character, Integer> head = st.pop();
            int freq = head.getValue();
            
            while(freq-- > 0) {
                result.append(head.getKey());
            }
        }
        
        return result.reverse().toString();
    }
}