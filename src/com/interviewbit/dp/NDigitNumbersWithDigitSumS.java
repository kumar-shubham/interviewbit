package com.interviewbit.dp;

import com.interviewbit.util.Printer;

public class NDigitNumbersWithDigitSumS {

	public static void main(String[] args) {

		System.out.println(solve(2,2));

	}

	public static int solve(int A, int B) {

		int count = 0;

		int[][] dp = new int[A][B];

		for (int i = 0; i < A; i++) {
			for (int j = 0; j < B; j++) {
				dp[i][j] = -1;
			}
		}
		
		if (A == 1) {
			if (B >= 0 && B <= 9) {
				return 1;
			}
			return 0;
		}
		
		int mod = 1000000007;

		for (int i = 1; i < 10; i++) {
			count = (count + getCount(A-1, B-i, dp))%mod;
		}

		Printer.printArr2D(dp);
		return count;

	}

	private static int getCount(int A, int B, int[][] dp) {
        
		int mod = 1000000007;
       
		if(A == 0) {
			return B == 0 ? 1:0;
		}
		
		if(B < 0) {
			return 0;
		}
		
		if(dp[A][B] != -1) {
			return dp[A][B];
		}
        
        int count = 0;
        for(int i = 0; i<10; i++){
        	if(B-i >= 0) {
        		count = (count + getCount(A-1, B-i, dp))%mod;
        	}
        }
        
        dp[A][B] = (count%mod);
        return dp[A][B];
        
    }

}
