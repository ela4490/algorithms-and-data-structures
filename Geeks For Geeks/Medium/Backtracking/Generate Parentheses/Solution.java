/* Given an integer N representing the number of pairs of parentheses, the task is to generate all combinations of well-formed(balanced) parentheses.

Example 1:
Input:
N = 3
Output:
((()))
(()())
(())()
()(())
()()()

Example 2:
Input:
N = 1
Output:
()

Your Task:  
You don't need to read input or print anything. Complete the function AllParenthesis() which takes N as input parameter and returns the list of balanced parenthesis.

Expected Time Complexity: O(2N * N).
Expected Auxiliary Space: O(2*N*X), X = Number of valid Parenthesis.

Constraints:
1 ≤ N ≤ 12 
    
Link: https://practice.geeksforgeeks.org/problems/generate-all-possible-parentheses/1/?category[]=Backtracking&category[]=Backtracking&page=1&query=category[]Backtrackingpage1category[]Backtracking# */

// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        
        int t = Integer.parseInt(sc.next());
        while(t>0)
        {
            int n = Integer.parseInt(sc.next());
            Solution T = new Solution();
            List<String> ans = T.AllParenthesis(n);
            String[] sequences = ans.toArray(new String[0]);
            Arrays.sort(sequences);
            int k = sequences.length;
            for(int i=0;i<k;i++)
            {
                System.out.println(sequences[i]);
            }
            
            t--;
            
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    
    public List<String> AllParenthesis(int n) 
    {
        List<String> result = new ArrayList<String>();
        backtrack(result, "", 0, 0, n);
        return result;
    }
    private void backtrack(List<String> result, String pattern, int open, int close, int max){
        if(pattern.length()==2*max){
            result.add(pattern);
            return;
        }
        if(open<max) backtrack(result, pattern+"(", open+1, close, max);
        if(close<open) backtrack(result, pattern+")", open, close+1, max);
    }
}