/* Given an array of N distinct elements, the task is to find all elements in array except two greatest elements in sorted order.

Example 1:
Input : 
a[] = {2, 8, 7, 1, 5}
Output :
1 2 5 
Explanation :
The output three elements have two or
more greater elements.   

Example 2:
Input :
a[] = {7, -2, 3, 4, 9, -1}
Output :
-2 -1 3 4

Your Task:  
You don't need to read input or print anything. Your task is to complete the function findElements() which takes the array A[] and its size N as inputs and return the vector sorted values denoting the elements in array which have at-least two greater elements than themselves.
Expected Time Complexity: O(N*Log(N))
Expected Auxiliary Space: O(N)

Constraints:
3 ≤ N ≤ 10^5
-106 ≤ Ai ≤ 10^6
    
Link: https://practice.geeksforgeeks.org/problems/at-least-two-greater-elements4625/1/?company[]=Amazon&company[]=Amazon&problemStatus=unsolved&difficulty[]=-2&page=1&query=company[]AmazonproblemStatusunsolveddifficulty[]-2page1company[]Amazon# */

// { Driver Code Starts
//Initial Template for Java

//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;


class GFG {
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            
            long n = Integer.parseInt(br.readLine().trim());
            long a[] = new long[(int)(n)];
            
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(inputLine[i]);
            }
            
            Solution obj = new Solution();
            long answer[] = obj.findElements( a, n);
            long sz = answer.length;
            
            StringBuilder output = new StringBuilder();
            for(int i=0;i<sz;i++)
            output.append(answer[i]+" ");
            System.out.println(output);
            
        }
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    public long[] findElements( long a[], long n)
    {
        Arrays.sort(a);
        ArrayList<Long> list = new ArrayList<>();
        long[] result = new long[(int)(n-2)];
        for(int i=0; i<(int)(n-2); i++){
            list.add(a[i]);
        }
        for(int i=0; i<list.size(); i++){
            result[i] = list.get(i);
        }
        return result;
    }
}