/* Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

Example 1:
Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]

Example 2:
Input: n = 1
Output: ["()"]

Constraints:
1 <= n <= 8

Link: https://leetcode.com/problems/generate-parentheses/ */

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        backtrack(list, new StringBuilder(), 0, 0, n);
        return list;
    }
    private void backtrack(List<String> list, StringBuilder sb, int open, int close, int n) {
        if(close>open) {
            return;
        }
        
        if(open==close && sb.length()==2*n) {
            list.add(sb.toString());
            return;
        }
        
        if(open<n) {
            sb.append("(");
            backtrack(list, sb, open+1, close, n);
            sb.deleteCharAt(sb.length()-1);
        }
        
        if(close<n) {
            sb.append(")");
            backtrack(list, sb, open, close+1, n);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}