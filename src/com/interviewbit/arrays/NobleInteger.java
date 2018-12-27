package com.interviewbit.arrays;

import java.util.Arrays;

//https://www.interviewbit.com/problems/noble-integer/

/*
Noble Integer

Given an integer array, find if an integer p exists in the array such that the number of integers greater than p in the array equals to p
If such an integer is found return 1 else return -1.
*/


public class NobleInteger {

	public static void main(String[] args) {
		
		
		int[] A = {1,1,1,0,0,0,3,3,3};
		int res = solve(A);
		System.out.println(res);
	}

	public static int solve(int[] A) {
		
		int n = A.length;

		if (A == null || n == 0) {
			return -1;
		}

		Arrays.sort(A);

		int prev = A[n - 1];
		if (prev == 0) {
			return 1;
		}
		for (int i = 1; i < n; i++) {
			int num = A[n - 1 - i];

			if (i == num) {
				if (num != prev) {
					return 1;
				}
			} else if (i > num) {
				int count = i;
				for (int j = n - i; j < n; j++) {
					if (num == A[j]) {
						count--;
					} else {
						if (count == num) {
							return 1;
						} else {
							continue;
						}
					}
				}
			}
			prev = num;
		}

		return -1;
	}

}
