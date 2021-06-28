/* Given an integer num, repeatedly add all its digits until the result has only one digit, and return it.

Example 1:
Input: num = 38
Output: 2
Explanation: The process is
38 --> 3 + 8 --> 11
11 --> 1 + 1 --> 2 
Since 2 has only one digit, return it.

Example 2:
Input: num = 0
Output: 0

Constraints:
0 <= num <= 2^31 - 1

Link: https://leetcode.com/problems/add-digits/ */

class Solution {
    public int addDigits(int num) {
        StringBuilder sb = new StringBuilder(String.valueOf(num));
        int sum = 0;
        int result = num;
        while(sb.length()>1){
            for(int i=0; i<sb.length(); i++){
                sum += sb.charAt(i) - '0';
            }
            sb.delete(0, sb.length());
            sb.append(sum);
            result = sum;
            sum = 0;
        }
        return result;
    }
}