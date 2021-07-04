/* Given an integer n, your task is to count how many strings of length n can be formed under the following rules:
Each character is a lower case vowel ('a', 'e', 'i', 'o', 'u')
Each vowel 'a' may only be followed by an 'e'.
Each vowel 'e' may only be followed by an 'a' or an 'i'.
Each vowel 'i' may not be followed by another 'i'.
Each vowel 'o' may only be followed by an 'i' or a 'u'.
Each vowel 'u' may only be followed by an 'a'.
Since the answer may be too large, return it modulo 10^9 + 7.

Example 1:
Input: n = 1
Output: 5
Explanation: All possible strings are: "a", "e", "i" , "o" and "u".

Example 2:
Input: n = 2
Output: 10
Explanation: All possible strings are: "ae", "ea", "ei", "ia", "ie", "io", "iu", "oi", "ou" and "ua".

Example 3:
Input: n = 5
Output: 68

Constraints:
1 <= n <= 2 * 10^4
    
Link: https://leetcode.com/explore/challenge/card/july-leetcoding-challenge-2021/608/week-1-july-1st-july-7th/3802/ */

class Solution {
    HashMap<String, Long> map = new HashMap();
    public int countVowelPermutation(int n) {
        long a = solve(n, 'a');
        long e = solve(n, 'e');
        long i = solve(n, 'i');
        long o = solve(n, 'o');
        long u = solve(n, 'u');
        
        return (int)((a+e+i+o+u)%1_000_000_007);
    }
    public long solve(int n, char c){
        if(map.containsKey(n+","+c)) return map.get(n+","+c);
        
        if(n==1) return 1;
        
        long res;
        if(c=='a'){
            res = solve(n-1, 'e')%1_000_000_007;
        }else if(c=='e'){
            res = (solve(n-1, 'a') + solve(n-1, 'i'))%1_000_000_007;
        }else if(c=='i'){
            res = (solve(n-1, 'a') + solve(n-1, 'e') + solve(n-1, 'o') + solve(n-1, 'u'))%1_000_000_007;
        }else if(c=='o'){
            res = (solve(n-1, 'i') + solve(n-1, 'u'))%1_000_000_007;
        }else{
            res = (solve(n-1, 'a'))%1_000_000_007;
        }
        map.put(n+","+c, res);
        return res;
    }
}