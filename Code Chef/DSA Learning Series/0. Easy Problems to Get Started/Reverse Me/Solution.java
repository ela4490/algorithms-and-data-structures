/* You are given a list of N integers and you need to reverse it and print the reversed list in a new line.

Input:
First-line will contain the number N.
Second line will contain N space-separated integers.

Output:
Print the reversed list in a single line.

Constraints
1≤N,Ai≤10^5

Sample Input 1:
4
1 3 2 4
Sample Output 1:
4 2 3 1

Sample Input 2:
2
9 8
Sample Output 2:
8 9

EXPLANATION:
In the first example, the reverse of the [1,3,2,4] is [4,2,3,1].
In the second example, the reverse of [9,8] is [8,9].

Link: https://www.codechef.com/CCSTART2/problems/REVMEE */

/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner s = new Scanner(System.in);
		while(s.hasNext()){
		    int N = s.nextInt();
		    int[] a = new int[N];
		    for(int i=0; i<N; i++){
		        a[i] = s.nextInt();
		    }
		    for(int i=N-1; i>=0; i--){
		        System.out.println(a[i]);
		    }
		}
	}
}