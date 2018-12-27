package com.interviewbit.dp;

import java.util.Stack;
import java.util.concurrent.locks.Lock;

//https://www.interviewbit.com/problems/max-rectangle-in-binary-matrix/

public class MaxRectangleInBinaryMatrix {

	public static void main(String[] args) {

		int[][] A = { { 0, 0, 1, 0, 0, 0, 1, 0, 1 }, { 0, 1, 1, 0, 0, 0, 0, 0, 0 }, { 0, 0, 1, 0, 1, 0, 1, 0, 1 },
				{ 0, 1, 0, 0, 0, 1, 1, 0, 1 }, { 0, 1, 0, 0, 0, 0, 1, 1, 1 }, { 1, 0, 1, 1, 1, 0, 1, 1, 1 },
				{ 1, 1, 1, 1, 0, 1, 1, 1, 1 }, { 1, 1, 1, 0, 1, 0, 1, 0, 1 } };

		System.out.println(maximalRectangle(A));
		
		Lock lock = null;

	}

	public static int maximalRectangle(int[][] A) {

		int maxArea = 0;

		int[] dp = new int[A[0].length];

		for (int i = 0; i < A.length; i++) {
			int[] a = A[i];
			for (int j = 0; j < a.length; j++) {
				dp[j] = a[j] == 0 ? 0 : dp[j] + 1;
			}
			int area = getMaxArea(dp);
			if (area > maxArea) {
				maxArea = area;
			}
		}

		return maxArea;
	}

	private static int getMaxArea(int[] a) {

//		Printer.printArr(a);

		Stack<Integer> s = new Stack<>();

		int maxArea = 0;
		int i = 0;
		for (; i < a.length;) {

			if (s.isEmpty() || a[i] >= a[s.peek()]) {
				s.push(i++);
				continue;
			}

			int top = s.pop();
			int area = 0;
			if (s.isEmpty()) {
				area = a[top] * i;
			} else {
				area = a[top] * (i - s.peek() - 1);
			}
			if (area > maxArea) {
				maxArea = area;
			}

		}

		while (!s.isEmpty()) {
			int top = s.pop();
			int area = 0;
			if (s.isEmpty()) {
				area = a[top] * i;
			} else {
				area = a[top] * (i - s.peek() - 1);
			}
			if (area > maxArea) {
				maxArea = area;
			}
		}

//		System.out.println(maxArea);

		return maxArea;
	}

}
