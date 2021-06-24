/* You're given a number N. Print the first N lines of the below-given pattern.

    *
   **
  ***
 ****
*****

Input:
First-line will contain the number N.

Output:
Print the first N lines of the given pattern.

Constraints
1≤N≤200

Sample Input 1:
4
Sample Output 1:
   *
  **
 ***
****

Sample Input 2:
2

Sample Output 2:
 *
**

EXPLANATION:
In the first example, we'll print the first 4 lines of the given pattern.
In the second example, we'll print the first 2 lines of the given pattern

Link: https://www.codechef.com/CCSTART2/problems/REVSTRPT */

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
		    for(int i=0; i<N; i++){
		        for(int j=1; j<N-i; j++){
		            System.out.print(" ");
		        }
		        for(int k=0; k<=i; k++){
		            System.out.print("*");
		        }
		        System.out.println();
		    }
		}
	}
}