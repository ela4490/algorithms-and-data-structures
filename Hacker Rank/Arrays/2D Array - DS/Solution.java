/* Link: https://www.hackerrank.com/challenges/2d-array/problem */

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);

        int[][] arr = new int[6][6];

        for (int j = 0; j < 6; j++) {
            for (int i = 0; i < 6; i++) {
                arr[i][j] = s.nextInt();
            }
        }

        int maxHourGlass = hourglassSum(arr, 1, 1);
        for(int j = 1; j<5; j++)
        {
            for(int i=1; i<5; i++) {
                int result = hourglassSum(arr, i, j);
                if (result > maxHourGlass){
                    maxHourGlass = result;
                }
            }
        }

        System.out.println(maxHourGlass);
    }

    static int hourglassSum(int[][] array, int x, int y) {
        return array[x-1][y-1] + array[x][y-1] + array[x+1][y-1] + array[x][y] + array[x-1][y+1] + array[x][y+1] + array[x+1][y+1];
    }
}