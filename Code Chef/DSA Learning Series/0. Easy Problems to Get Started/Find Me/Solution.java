/* You are given a list of N integers and a value K. Print 1 if K exists in the given list of N integers, otherwise print −1.

Input:
First-line will contain two numbers N and K.
Next line contains N space-separated numbers.

Output:
Print the answer in a new line.

Constraints
1≤N,K,Ai≤10^5

Sample Input 1:
4 2
1 2 3 4
Sample Output 1:
1

Sample Input 2:
4 4
1 2 6 9
Sample Output 2:
-1

EXPLANATION:
In the first example, as 2 is present in the list.
In the second example, 4 is not present in the list.

Link: https://www.codechef.com/CCSTART2/problems/FINDMELI */

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
		    int K = s.nextInt();
		    int[] a = new int[N];
		    for(int i=0; i<N; i++){
		        a[i] = s.nextInt();
		    }
		    for(int i=0; i<N; i++){
		        if(a[i]==K){
		            System.out.println("1");
		            return;
		        }
		    }
		    System.out.println("-1");
		}
	}
}