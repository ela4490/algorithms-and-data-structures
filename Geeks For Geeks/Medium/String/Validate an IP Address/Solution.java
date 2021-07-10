/* Write a program to Validate an IPv4 Address. According to Wikipedia, IPv4 addresses are canonically represented in dot-decimal notation, which consists of four decimal numbers, each ranging from 0 to 255, separated by dots, e.g., 172.16.254.1 . The generalized form of an IPv4 address is (0-255).(0-255).(0-255).(0-255). Here we are considering numbers only from 0 to 255 and any additional leading zeroes will be considered invalid. Your task is  to complete the function isValid which returns 1 if the ip address is valid else returns 0. The function takes a string s as its only argument .

Example 1:
Input:
ip = 222.111.111.111
Output: 1

Example 2:
Input:
ip = 5555..555
Output: 0
Explanation: 5555..555 is not a valid
ip address, as the middle two portions
are missing.

Your Task:
Complete the function isValid() which takes the string s as an input parameter and returns 1 if this is a valid ip address otherwise returns 0.
Expected Time Complexity: O(N), N = length of string.
Expected Auxiliary Space: O(1)

Constraints:
1<=length of string <=50

Note:The Input/Ouput format and Example given are used for system's internal purpose, and should be used by a user for Expected Output only. As it is a function problem, hence a user should not read any input from stdin/console. The task is to complete the function specified, and not to write the full code.
    
Link: https://practice.geeksforgeeks.org/problems/validate-an-ip-address-1587115621/1# */

// { Driver Code Starts
// Initial Template for Java

// Initial Template for Java

import java.util.*;
import java.io.*;

  public class validip {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            String s = sc.next();
            Solution obj = new Solution();

            if (obj.isValid(s))
                System.out.println(1);
            else
                System.out.println(0);
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solution {

    public boolean isValid(String s) {
        boolean flag = false;
        int count = 0;
        String[] str = s.split("\\.");
        
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='.'){
                count++;
            }
        }
        
        if(count!=3 || str.length!=4){
            return false;
        }
        
        for(int i=0; i<str.length; i++){
            try{
                int num = Integer.parseInt(str[i]);
                
                if(num>=0 && num<=255){
                    flag = true;
                }else{
                    return false;
                }
                
                if(str[i].length()==0 || str[i].length()>3 || Integer.toString(num).length()!=str[i].length()){
                    return false;
                }
                
            }catch(NumberFormatException e){
                return false;
            }
        }
        return flag;
    }
}