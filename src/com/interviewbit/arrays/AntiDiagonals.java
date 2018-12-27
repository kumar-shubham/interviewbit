package com.interviewbit.arrays;

import java.util.ArrayList;

//https://www.interviewbit.com/problems/anti-diagonals/

/*
Anti Diagonals

    Asked in:  
    Microsoft
    Adobe

Give a N*N square matrix, return an array of its anti-diagonals. Look at the example for more details.

Example:

		
Input: 	

1 2 3
4 5 6
7 8 9

Return the following :

[ 
  [1],
  [2, 4],
  [3, 5, 7],
  [6, 8],
  [9]
]


*/

public class AntiDiagonals {

	public static void main(String[] args) {
		
		int[][] A = {
				{1,2,3},
				{4,5,6},
				{7,8,9}
		};
		
		ArrayList<ArrayList<Integer>> res = diagonal(A);
		
		for(ArrayList<Integer> r : res) {
			System.out.println(r);
		}
		

	}

	public static ArrayList<ArrayList<Integer>> diagonal(int[][] A) {

		int n = A.length;

		ArrayList<ArrayList<Integer>> result = new ArrayList<>();

		for (int k = 0; k < n; k++) {
			ArrayList<Integer> res = new ArrayList<>();
			ArrayList<Integer> res1 = new ArrayList<>();
			for (int i = 0, j = k, i1 = (n - 1 - j), j1 = (n - 1); i < n && j >= 0; i++, j--, i1++, j1--) {
				res.add(A[i][j]);
				if (k < n - 1) {
					res1.add(A[i1][j1]);
				}
			}
			result.add(k, res);
			if (k < n - 1) {
				result.add(k + 1, res1);
			}
		}

		return result;
	}

}
