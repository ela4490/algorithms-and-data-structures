/* Given string num representing a non-negative integer num, and an integer k, return the smallest possible integer after removing k digits from num.

Example 1:
Input: num = "1432219", k = 3
Output: "1219"
Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.

Example 2:
Input: num = "10200", k = 1
Output: "200"
Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.

Example 3:
Input: num = "10", k = 2
Output: "0"
Explanation: Remove all the digits from the number and it is left with nothing which is 0.

Constraints:
1 <= k <= num.length <= 10^5
num consists of only digits.
num does not have any leading zeros except for the zero itself.
    
Link: https://leetcode.com/problems/remove-k-digits/ */

class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();
        
        for(int i = 0; i < num.length(); i++) {
            char ch = num.charAt(i);
            
            while(k > 0 && !stack.isEmpty() && stack.peek() > ch) {
                stack.pop();
                k--;
            }
            
            stack.push(ch);
        }
        
        while(k > 0) {
            stack.pop();
            k--;
        }
        
        char[] digits = new char[stack.size()];
        int index = digits.length - 1;
        
        while(!stack.isEmpty()) {
            digits[index--] = stack.pop();
        }
        
        int j = 0;
        while(j < digits.length && digits[j] == '0') {
            j++;
        }
        
        StringBuilder sb = new StringBuilder();
        while(j < digits.length) {
            sb.append(digits[j++]);
        }
        
        if(sb.length() == 0) {
            sb.append(0);
        }
        
        return sb.toString();
    }
}