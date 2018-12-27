package com.interviewbit.arrays;

import com.interviewbit.util.Printer;

//https://www.interviewbit.com/problems/add-one-to-number/


/*
Add One To Number

    Asked in:  
    Google

Given a non-negative number represented as an array of digits,

add 1 to the number ( increment the number represented by the digits ).

The digits are stored such that the most significant digit is at the head of the list.

Example:

If the vector has [1, 2, 3]

the returned vector should be [1, 2, 4]

as 123 + 1 = 124.

    NOTE: Certain things are intentionally left unclear in this question which you should practice asking the interviewer.
    For example, for this problem, following are some good questions to ask :

        Q : Can the input have 0’s before the most significant digit. Or in other words, is 0 1 2 3 a valid input?

        A : For the purpose of this question, YES
        Q : Can the output have 0’s before the most significant digit? Or in other words, is 0 1 2 4 a valid output?
        A : For the purpose of this question, NO. Even if the input has zeroes before the most significant digit.

*/

public class AddOneToNumber {

	public static void main(String[] args) {
		
		int[] A = {0,1,2,3};
		int[] res = plusOne(A);
		Printer.printArr(res);

	}

	public static int[] plusOne(int[] A) {

		int carry = 1;
		int size = A.length;
		for (int i = size - 1; i >= 0; i--) {
			int sum = A[i] + carry;
			A[i] = sum % 10;
			carry = sum / 10;
		}

		if (carry == 1) {
			int arr[] = new int[size + 1];
			arr[0] = carry;
			for (int i = 1; i <= size; i++) {
				arr[i] = A[i - 1];
			}
			return arr;
		}

		int zeros = 0;
		for (int i = 0; i < size; i++) {
			if (A[i] == 0) {
				zeros++;
			} else {
				break;
			}
		}

		if (zeros > 0) {
			int arr[] = new int[size - zeros];
			for (int i = zeros; i < size; i++) {
				arr[i - zeros] = A[i];
			}
			return arr;
		}

		return A;

	}

}
