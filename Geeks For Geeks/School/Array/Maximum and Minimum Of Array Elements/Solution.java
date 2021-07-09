/* Given an array A[ ], find maximum and minimum elements from the array.
Input:
The first line of input contains an integer T, denoting the number of testcases. The description of T testcases follows. The first line of each testcase contains a single integer N denoting the size of array. The second line contains N space-separated integers A1, A2, ..., AN denoting the elements of the array.
Output:
For each testcase in a new line, print the maximum and minimum element in a single line with space in between.

Constraints:
1 ≤ T ≤ 30
1 ≤ N ≤ 100
0 ≤A[i]<100

Example:
Input:
2
4
5 4 2 1
1
8
Output:
5 1
8 8
Explanation:
Testcase 1:
Maximum element is: 5 
Minimum element is: 1
    
Link: https://practice.geeksforgeeks.org/problems/maximum-and-minimum-of-array-elements/0/?category[]=Arrays&category[]=Arrays&problemType=full&difficulty[]=-2&page=1&query=category[]ArraysproblemTypefulldifficulty[]-2page1category[]Arrays# */

/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner s = new Scanner(System.in);
		while(s.hasNext()){
		    int testCases = s.nextInt();
		    for(int i=0; i<testCases; i++){
		        int n = s.nextInt();
		        int[] a = new int[n];
		        for(int j=0; j<n; j++){
		            a[j] = s.nextInt();
		        }
		        int min = Integer.MAX_VALUE;
		        int max = Integer.MIN_VALUE;
		        for(int k=0; k<a.length; k++){
		            min = Math.min(min, a[k]);
		            max = Math.max(max, a[k]);
		        }
		        System.out.println(max + " " + min);
		    }
		}
	}
}