package com.interviewbit.arrays;

//https://www.interviewbit.com/problems/longest-subarray-difference/?ref=random-problem

/*
Longest Subarray Difference

You are given an array A of N integers and an integer B.

You have to find the longest subarray of A such that the difference between the maximum and the minimum element of that subarray is strictly less than B.

 

Input Format

The first argument given is an Array A, having N integers.
The second argument is an integer B.

Output Format

Return an integer X, i.e size of the longest subarray

Constraints

1 <= N <= 1e5
1 <= A[i] <= 1e6
1 <= B <= 1e6

For Example

Input:
    A = [1, 2, 4]
    B = 2
Output:
    2
   
Explanation:
    only subarray which has a difference of maximum and minimum element strictly less than 2 is:
    [1, 2]

*/

public class LongestSubarrayDifference {

	public static void main(String[] args) {
		
		int[] A = {44, 99, 50, 7, 97, 100, 54, 51, 31, 64, 34, 25, 6, 8, 41, 48,
				40, 71, 37, 18, 8, 36, 91, 77, 28, 78, 4, 30, 56, 26, 6, 52, 10, 
				36, 44, 35, 38, 78, 81, 32, 77, 25, 33, 58, 38, 81, 63, 6, 29, 
				71, 33, 44, 64, 38, 43, 20, 34, 36, 75, 80, 77, 61, 30, 65};
		
		System.out.println(solve(A, 59));

	}

	public static int solve(int[] A, int B) {
        
        int n = A.length;
        int max = 0;
        for (int i = 0; i < n; i++) {
            int res = getMaxLength(i, A, B);
            max = Math.max(res, max);
        }
        
        return max;
        
    }
	
	private static int getMaxLength(int x, int[] A, int B) {
        int i = x;
        int n = A.length;
        int min = A[i];
        int max = A[i];
        while (i < n) {
            max = Math.max(max, A[i]);
            min = Math.min(min, A[i]);
            if(max-min < B){
                i++;
            }
            else{
                break;
            }
            
        }
        
        i--;
        return i - x + 1;
    }

}
