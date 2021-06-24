/* You are given a number N. Find the sum of all numbers from 1 to N.

Input:
First-line will contain the number N.

Output:
Print the answer in a single line.

Constraints
1≤N≤10^9

Sample Input 1:
4
Sample Output 1:
10

Sample Input 2:
8
Sample Output 2:
36

EXPLANATION:
In the first example, (1 + 2 + 3 + 4) = 10.
In the second example, (1 + 2 + 3 + 4 + 5 + 6 + 7 + 8) = 36.

Link: https://www.codechef.com/CCSTART2/problems/ADDNATRL */

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
		    long sum = 0;
		    for(int i=1; i<=N; i++){
		        sum += i;
		    }
		    System.out.println(sum);
		}
	}
}