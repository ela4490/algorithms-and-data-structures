/* Chef went to a shop and buys a pens and b pencils. Each pen costs x units and each pencil costs y units. Now find what is the total amount Chef will spend to buy a pens and b pencils.

Input:
First-line will contain 4 space separated integers a, b, x and y respectively.

Output:
Print the answer in a new line.

Constraints
1≤a,b,x,y≤10^3

Sample Input 1:
2 4 4 5
Sample Output 1:
28

Sample Input 2:
1 1 4 8
Sample Output 2:
12

Link: https://www.codechef.com/CCSTART2/problems/BUYPLSE */

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
		    int a = s.nextInt();
		    int b = s.nextInt();
		    int x = s.nextInt();
		    int y = s.nextInt();
		    System.out.println((x*a)+(y*b));
		}
		s.close();
	}
}