/* Given an array A of size N, print the reverse of it.

Input:
First line contains an integer denoting the test cases 'T'. T testcases follow. Each testcase contains two lines of input. First line contains N the size of the array A. The second line contains the elements of the array.
Output:
For each testcase, in a new line, print the array in reverse order.

Constraints:
1 <= T <= 100
1 <= N <=100
0 <= Ai <= 100

Example:
Input:
1
4
1 2 3 4
Output:
4 3 2 1
    
Link: https://practice.geeksforgeeks.org/problems/reverse-an-array/0/?problemType=full&difficulty[]=-2&page=1&query=problemTypefulldifficulty[]-2page1# */

/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner s = new Scanner(System.in);
		while(s.hasNext()){
		    int testcases = s.nextInt();
		    for(int i=0; i<testcases; i++){
		        int n = s.nextInt();
		        int[] a = new int[n];
		        for(int j=0; j<n; j++){
		            a[j] = s.nextInt();
		        }
		        int[] reverse = new int[n];
		        for(int j=0, k=n-1; j<n && k>=0; j++,k--){
		            reverse[j] = a[k];
		        }
		        for(int j=0; j<n; j++){
		            System.out.print(reverse[j] + " ");
		        }
		        System.out.println();
		    }
		}
	}
}