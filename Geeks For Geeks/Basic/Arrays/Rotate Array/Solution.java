/* Given an unsorted array arr[] of size N, rotate it by D elements (clockwise).

Input:
The first line of the input contains T denoting the number of testcases. First line of each test case contains two space separated elements, N denoting the size of the array and an integer D denoting the number size of the rotation. Subsequent line will be the N space separated array elements.
Output:
For each testcase, in a new line, output the rotated array.

Constraints:
1 <= T <= 200
1 <= N <= 10^7
1 <= D <= N
0 <= arr[i] <= 10^5

Example:
Input:
2
5 2
1 2 3 4 5 
10 3
2 4 6 8 10 12 14 16 18 20
Output:
3 4 5 1 2
8 10 12 14 16 18 20 2 4 6

Explanation :
Testcase 1: 1 2 3 4 5  when rotated by 2 elements, it becomes 3 4 5 1 2.
    
Link: https://practice.geeksforgeeks.org/problems/rotate-array-by-n-elements/0/?problemStatus=unsolved&problemType=full&difficulty[]=-1&page=1&query=problemStatusunsolvedproblemTypefulldifficulty[]-1page1# */

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
	            int d = s.nextInt();
	            int[] a = new int[n];
	            for(int j=0; j<n; j++){
	                a[j] = s.nextInt();
	            }
	            int[] temp = new int[d];
	            for(int j=0; j<d; j++){
	                temp[j] = a[j];
	            }
	            for(int j=d; j<n; j++){
	                a[j-d] = a[j];
	            }
	            for(int j=0; j<d; j++){
	                a[j-d+n] = temp[j];
	            }
	            for(int j=0; j<n; j++){
	                System.out.print(a[j] + " ");
	            }
	            System.out.println();
	        }
	    }
	}
}