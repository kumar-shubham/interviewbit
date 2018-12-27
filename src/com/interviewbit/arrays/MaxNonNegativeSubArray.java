package com.interviewbit.arrays;

import com.interviewbit.util.Printer;

//https://www.interviewbit.com/problems/max-non-negative-subarray/

/*
Max Non Negative SubArray

    Asked in:  
    Google

Find out the maximum sub-array of non negative numbers from an array.
The sub-array should be continuous. That is, a sub-array created by choosing the second and fourth element and skipping the third element is invalid.

Maximum sub-array is defined in terms of the sum of the elements in the sub-array. Sub-array A is greater than sub-array B if sum(A) > sum(B).

Example:

A : [1, 2, 5, -7, 2, 3]
The two sub-arrays are [1, 2, 5] [2, 3].
The answer is [1, 2, 5] as its sum is larger than [2, 3]

NOTE: If there is a tie, then compare with segment's length and return segment which has maximum length
NOTE 2: If there is still a tie, then return the segment with minimum starting index

		*/

public class MaxNonNegativeSubArray {

	public static void main(String[] args) {
		
		int[] A = {1, 2, 5, -7, 2, 3};
		int[] res = maxset(A);
		Printer.printArr(res);

	}

	public static int[] maxset(int[] A) {

		int left = -1;
		int right = 0;
		int maxSum = -1;

		int tempLeft = -1;
		int sum = 0;
		int prev = -1;
		for (int i = 0; i < A.length; i++) {

			int value = A[i];

			if (value >= 0) {
				if (prev >= 0) {
					sum += value;
				} else {
					sum = value;
					tempLeft = i;
				}
			} else {
				sum = value;
			}

			if (sum > maxSum) {
				maxSum = sum;
				left = tempLeft;
				right = i;
			} else if (sum == maxSum && value == 0 && (right - left < i - tempLeft)) {
				left = tempLeft;
				right = i;
			}

			prev = value;
		}

		System.out.println(left + " : " + right);

		if (left == -1) {
			return new int[0];
		}

		int result[] = new int[right - left + 1];
		for (int i = left; i <= right; i++) {
			result[i - left] = A[i];
		}

		return result;

	}

}
