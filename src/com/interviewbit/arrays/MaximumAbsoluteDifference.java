package com.interviewbit.arrays;

import java.util.ArrayList;

//https://www.interviewbit.com/problems/maximum-absolute-difference/

/*

Maximum Absolute Difference

You are given an array of N integers, A1, A2 ,…, AN. Return maximum value of f(i, j) for all 1 ≤ i, j ≤ N.
f(i, j) is defined as |A[i] - A[j]| + |i - j|, where |x| denotes absolute value of x.

For example,

A=[1, 3, -1]

f(1, 1) = f(2, 2) = f(3, 3) = 0
f(1, 2) = f(2, 1) = |1 - 3| + |1 - 2| = 3
f(1, 3) = f(3, 1) = |1 - (-1)| + |1 - 3| = 4
f(2, 3) = f(3, 2) = |3 - (-1)| + |2 - 3| = 5

So, we return 5.

*/

public class MaximumAbsoluteDifference {

	public static void main(String[] args) {
		
		int[] A = {1, 3, -1};
		int res = maxArr(A);
		System.out.println(res);

	}

	public static int maxArr(int[] A) {

		ArrayList<Integer> B = new ArrayList<Integer>();
		ArrayList<Integer> C = new ArrayList<Integer>();

		int count = -1;

		for (Integer i : A) {
			count++;

			B.add(i + count);
			C.add(i - count);

		}

		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		int diff = 0;
		for (Integer i : B) {

			if (i > max) {
				max = i;
			}

			if (i < min) {
				min = i;
			}
		}

		if (max - min > diff) {
			diff = max - min;
		}

		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;
		for (Integer i : C) {

			if (i > max) {
				max = i;
			}

			if (i < min) {
				min = i;
			}
		}

		if (max - min > diff) {
			diff = max - min;
		}

		return diff;
	}

}
