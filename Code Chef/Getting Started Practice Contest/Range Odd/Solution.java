/* You're given two numbers L and R. Print all odd numbers between L and R(both inclusive) in a single line separated by space, in ascending (increasing) order.

Input:
First-line will contain two numbers L and R.

Output:
Print all odd numbers in a single line separated by space, in ascending (increasing) order.

Constraints
1≤L<R≤10^6

Sample Input 1:
2 9
Sample Output 1:
3 5 7 9

Sample Input 2:
3 4
Sample Output 2:
3

EXPLANATION:
In the first example, odd numbers between 2 and 9 are 3,5,7,9.
In the second example, the only odd number in the range is 3.

Link: https://www.codechef.com/CCSTART2/problems/RNGEODD */

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
		    int L = s.nextInt();
		    int R = s.nextInt();
		    for(int i=L; i<=R; i++){
		        if(i%2!=0){
		            System.out.println(i);
		        }
		    }
		}
	}
}