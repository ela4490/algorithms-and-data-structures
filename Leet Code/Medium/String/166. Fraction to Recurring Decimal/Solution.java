/* Given two integers representing the numerator and denominator of a fraction, return the fraction in string format. If the fractional part is repeating, enclose the repeating part in parentheses. If multiple answers are possible, return any of them. It is guaranteed that the length of the answer string is less than 104 for all the given inputs.

Example 1:
Input: numerator = 1, denominator = 2
Output: "0.5"

Example 2:
Input: numerator = 2, denominator = 1
Output: "2"

Example 3:
Input: numerator = 2, denominator = 3
Output: "0.(6)"

Example 4:
Input: numerator = 4, denominator = 333
Output: "0.(012)"

Example 5:
Input: numerator = 1, denominator = 5
Output: "0.2"

Constraints:
-2^31 <= numerator, denominator <= 2^31 - 1
denominator != 0

Link: https://leetcode.com/problems/fraction-to-recurring-decimal/ */

class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        StringBuilder sb = new StringBuilder();
        
        if((numerator < 0 && denominator > 0) || (numerator > 0 && denominator < 0)){
            sb.append("-");
        }
        
        long num = Math.abs((long)numerator);
        long den = Math.abs((long)denominator);
        long q = num / den;
        long r = num % den;
        sb.append(q);
        
        if(r != 0) {
            sb.append(".");
            HashMap<Long, Integer> map = new HashMap<>();
            
            while(r != 0) {
                
                if(map.containsKey(r)) {
                    long len = map.get(r);
                    sb.insert((int)len, "(");
                    sb.append(")");
                    break;
                } else {
                    map.put(r, sb.length());
                    r = r * 10;
                    q = r / den;
                    r = r % den;
                    sb.append(q);
                }
                
            }
            
        }
        
        return sb.toString();
    }
}