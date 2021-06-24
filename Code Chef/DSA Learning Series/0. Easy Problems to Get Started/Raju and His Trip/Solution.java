/* Raju is planning to visit his favourite restaurant. He shall travel to it by bus. Only the buses whose numbers are divisible by 5 or by 6 shall take him to his destination. You are given a bus number N. Find if Raju can take the bus or not. Print YES if he can take the bus, otherwise print NO.

Input:
The first and only line of the input shall contain an integer N, denoting the bus number.

Output:
Print YES if Raju can take that bus, else print NO.

Constraints
1≤N≤10^6

Sample Input 1:
60
Sample Output 1:
YES

Sample Input 2:
16
Sample Output 2:
NO

Sample Input 3:
20
Sample Output 3:
YES

EXPLANATION:
In the first example, 60 is divisible by 5 and 6 both, so he can take the bus.
In the second example, 16 is divisible by neither 5 nor 6, so he can't take the bus.
In the third example, 20 is divisible by 5, so he can take the bus.

Link: https://www.codechef.com/CCSTART2/problems/VALTRI */

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
		    if(N%5==0 || N%6==0){
		        System.out.println("YES");
		    }else{
		        System.out.println("NO");
		    }
		}
	}
}