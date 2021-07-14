/* Given a String S, reverse the string without reversing its individual words. Words are separated by dots.

Example 1:
Input:
S = i.like.this.program.very.much
Output: much.very.program.this.like.i
Explanation: After reversing the whole string(not individual words), the input string becomes much.very.program.this.like.i

Example 2:
Input:
S = pqr.mno
Output: mno.pqr
Explanation: After reversing the whole string, the input string becomes mno.pqr

Your Task:
You dont need to read input or print anything. Complete the function reverseWords() which takes string S as input parameter and returns a string containing the words in reversed order. Each word in the returning string should also be separated by '.' 

Expected Time Complexity: O(|S|)
Expected Auxiliary Space: O(|S|)

Constraints:
1 <= |S| <= 2000
    
Link: https://practice.geeksforgeeks.org/problems/reverse-words-in-a-given-string5459/1/?company[]=Amazon&company[]=Amazon&problemStatus=unsolved&problemType=functional&difficulty[]=0&page=3&sortBy=submissions&query=company[]AmazonproblemStatusunsolvedproblemTypefunctionaldifficulty[]0page3sortBysubmissionscompany[]Amazon# */

// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            String s = sc.next();
            Solution obj = new Solution();
            System.out.println(obj.reverseWords(s));
            t--;
        }
    }
}
// } Driver Code Ends

class Solution 
{
    //Function to reverse words in a given string.
    String reverseWords(String S)
    {
        StringBuilder sb = new StringBuilder();
        String[] arr = S.split("\\.");
        for(int i=arr.length-1; i>=0; i--){
            sb.append(arr[i]);
            if(i!=0){
                sb.append(".");
            }
        }
        return sb.toString();
    }
}