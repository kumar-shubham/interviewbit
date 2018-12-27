package com.interviewbit.arrays;

//https://www.interviewbit.com/problems/max-sum-contiguous-subarray/

/*
Max Sum Contiguous Subarray

    Asked in:  
    Facebook
    Paypal
    Yahoo
    Microsoft
    LinkedIn
    Amazon
    Goldman Sachs

Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

For example:

Given the array [-2,1,-3,4,-1,2,1,-5,4],

the contiguous subarray [4,-1,2,1] has the largest sum = 6.

For this problem, return the maximum sum.

*/


public class MaxSumContiguousSubarray {

	public static void main(String[] args) {
		
		int[] A = {-2,1,-3,4,-1,2,1,-5,4};
		int result = maxSubArray(A);
		System.out.println(result);

	}
	
	 public static int maxSubArray(final int[] A) {
	        
	        int maxSum = A[0];
	        int maxCurrent = A[0];
	        
	        for(int i = 1; i<A.length; i++){
	            
	            if(A[i] > (maxCurrent + A[i])){
	                maxCurrent = A[i];
	            }
	            else{
	                maxCurrent += A[i];
	            }
	            
	            if(maxCurrent > maxSum){
	                maxSum = maxCurrent;
	            }
	            
	        }
	        
	        return maxSum;
	        
	    }

}
