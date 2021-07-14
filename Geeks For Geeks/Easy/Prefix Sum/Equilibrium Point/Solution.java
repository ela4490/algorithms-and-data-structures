/* Given an array A of n positive numbers. The task is to find the first Equilibium Point in the array. Equilibrium Point in an array is a position such that the sum of elements before it is equal to the sum of elements after it.

Example 1:
Input:
n = 1
A[] = {1}
Output: 1
Explanation: Since its the only element hence its the only equilibrium point. 

Example 2:
Input:
n = 5
A[] = {1,3,5,2,2}
Output: 3
Explanation: For second test case equilibrium point is at position 3 as elements before it (1+3) = elements after it (2+2).

Your Task:
The task is to complete the function equilibriumPoint() which takes the array and n as input parameters and returns the point of equilibrium. Return -1 if no such point exists.

Expected Time Complexity: O(n)
Expected Auxiliary Space: O(1)

Constraints:
1 <= n <= 10^6
1 <= A[i] <= 10^8
    
Link: https://practice.geeksforgeeks.org/problems/equilibrium-point-1587115620/1/?company[]=Amazon&company[]=Amazon&problemStatus=unsolved&problemType=functional&difficulty[]=0&page=2&sortBy=submissions&query=company[]AmazonproblemStatusunsolvedproblemTypefunctionaldifficulty[]0page2sortBysubmissionscompany[]Amazon# */

// { Driver Code Starts
import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {
            
            //taking input n
            int n = Integer.parseInt(br.readLine().trim());
            long arr[] = new long[n];
            String inputLine[] = br.readLine().trim().split(" ");
            
            //adding elements to the array
            for (int i = 0; i < n; i++) {
                arr[i] = Long.parseLong(inputLine[i]);
            }

            Solution ob = new Solution();
            
            //calling equilibriumPoint() function
            System.out.println(ob.equilibriumPoint(arr, n));
        }
    }
}// } Driver Code Ends


class Solution {

    
    // a: input array
    // n: size of array
    // Function to find equilibrium point in the array.
    public static int equilibriumPoint(long arr[], int n) {
        long[] temp = new long[n];
        long sum = 0;
        long left = 0;
        long right = 0;
        if(n==1){
            return 1;
        }
        if(n==0 || n==2){
            return -1;
        }
        for(int i=0; i<n; i++){
            sum += arr[i];
            temp[i] = sum;
        }
        for(int i=0; i<n; i++){
            left = temp[i] - arr[i];
            right = temp[n-1] - temp[i];
            if(left==right){
                return i+1;
            }
        }
        return -1;
    }
}