package com.interviewbit.arrays;

import com.interviewbit.util.Printer;

//https://www.interviewbit.com/problems/spiral-order-matrix-ii/?ref=random-problem


/*
Spiral Order Matrix II

    Asked in:  
    Microsoft
    JP Morgan
    Amazon

Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

Example:

Given n = 3,

You should return the following matrix:

[
  [ 1, 2, 3 ],
  [ 8, 9, 4 ],
  [ 7, 6, 5 ]
]

*/

public class SpiralOrderMatrix2 {

	public static void main(String[] args) {
		
		int[][] a = generateMatrix(80);
		
		Printer.printArr2D(a);

	}
	
	
	public static int[][] generateMatrix(int A) {
        int n = A-1;
        int[][] a = new int[A][A];
        int count = 0;
        int i = 0;
        int j = 0;
        int start = 0;
        int max = A*A;
        while(count < max){
            count++;
            a[i][j] = count;
            System.out.println(start + ", " + n + ", " + i + ", " + j);
            if(i == start && j<n ){
                j++;
                continue;
            }
            if(j == n && i <n){
                i++;
                continue;
            }
            if(i == n && j > start){
                j--;
                continue;
            }
            if(j == start && i > start+1){
                i--;
                continue;
            }
            System.out.println();
            start++;
            n--;
            i = start;
            j = start;
        }
        
        return a;
    }

}
