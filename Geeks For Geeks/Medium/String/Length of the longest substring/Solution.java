/* Given a string S, find the length of the longest substring without repeating characters.

Example 1:
Input:
S = "geeksforgeeks"
Output:
7
Explanation:
Longest substring is
"eksforg".

Example 2:
Input:
S = "abdefgabef"
Output:
6
Explanation:
Longest substring are
"abdefg" , "bdefga" and "defgab".

Your Task:
You don't need to take input or print anything. Your task is to complete the function longestUniqueSubsttr() which takes a string S as and returns the length of the longest substring.

Expected Time Complexity: O(|S|).
Expected Auxiliary Space: O(K) where K is constant.

Constraints:
1 ≤ |S| ≤ 105
It is guaranteed that all characters of the String S will be lowercase letters from 'a' to 'z'    

Link: https://practice.geeksforgeeks.org/problems/length-of-the-longest-substring3036/1# */

// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String s = read.readLine().trim();

            Solution ob = new Solution();
            System.out.println(ob.longestUniqueSubsttr(s));
        }
    }
}// } Driver Code Ends


//User function Template for Java


class Solution{
    int longestUniqueSubsttr(String S){
        int a_pointer = 0;
        int b_pointer = 0;
        int max = Integer.MIN_VALUE;
        HashSet<Character> set = new HashSet<>();
        while(b_pointer<S.length()){
            char c = S.charAt(b_pointer);
            if(!set.contains(c)){
                set.add(c);
                max = Math.max(max, set.size());
                b_pointer++;
            }else{
                set.remove(S.charAt(a_pointer));
                a_pointer++;
            }
        }
        return max;
    }
}