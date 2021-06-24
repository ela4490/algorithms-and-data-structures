/* Given three distinct integers A, B and C, print the second largest number among them.

Input:
The input consists of three lines.
The first line contains a single integer A.
The second line contains a single integer B.
The third line contains a single integer C.

Output:
Print the second largest number among A, B and C, in a separate line.

Constraints
1≤A,B,C≤10^9

Sample Input 1:
2
7
21
Sample Output 1:
7

Sample Input 2:
14
28
16
Sample Output 2:
16

EXPLANATION:
In the first example, 7 is the second largest number among the given three numbers.
In the second example, 16 is the second largest number among the given three numbers.

Link: https://www.codechef.com/CCSTART2/problems/SECLAR */

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
		    int[] a = new int[3];
		    for(int i=0; i<a.length; i++){
		        a[i] = s.nextInt();
		    }
		    Arrays.sort(a);
		    System.out.println(a[1]);
		}
	}
}