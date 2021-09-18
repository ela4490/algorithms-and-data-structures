/* Given a string num that contains only digits and an integer target, return all possibilities to add the binary operators '+', '-', or '*' between the digits of num so that the resultant expression evaluates to the target value.

Example 1:
Input: num = "123", target = 6
Output: ["1*2*3","1+2+3"]

Example 2:
Input: num = "232", target = 8
Output: ["2*3+2","2+3*2"]

Example 3:
Input: num = "105", target = 5
Output: ["1*0+5","10-5"]

Example 4:
Input: num = "00", target = 0
Output: ["0*0","0+0","0-0"]

Example 5:
Input: num = "3456237490", target = 9191
Output: []

Constraints:
1 <= num.length <= 10
num consists of only digits.
-2^31 <= target <= 2^31 - 1
    
Link: https://leetcode.com/explore/challenge/card/september-leetcoding-challenge-2021/638/week-3-september-15th-september-21st/3979/ */

class Solution {
    private List<String> result = new ArrayList<>();
    
    public List<String> addOperators(String num, int target) {
        dfs(0, "", 0, 0, num, target);
        return result;
    }
    
    private void dfs(int index, String path, long rsf, long previous, String num, int target) {
        
        if(index == num.length()) {
            if(rsf == target) result.add(path);
            return;
        }
        
        for(int i = index; i < num.length(); i++) {
            if( i > index && num.charAt(index) == '0') break;
            long current = Long.parseLong(num.substring(index, i + 1));
            
            if(index == 0) {
                dfs(i + 1, path + current, current, current, num, target);
            } else {
                dfs(i + 1, path + "+" + current, rsf + current, current, num, target);
                dfs(i + 1, path + "-" + current, rsf - current, - current, num, target);
                dfs(i + 1, path + "*" + current, rsf - previous + previous * current, previous * current, num, target);
            }
        }
    }
}