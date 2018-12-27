package com.interviewbit.arrays;

import java.util.ArrayList;

//https://www.interviewbit.com/problems/flip/


/*
Flip

    Asked in:  
    VMWare

You are given a binary string(i.e. with characters 0 and 1) S consisting of characters S1, S2, …, SN. In a single operation, you can choose two indices L and R such that 1 ≤ L ≤ R ≤ N and flip the characters SL, SL+1, …, SR. By flipping, we mean change character 0 to 1 and vice-versa.

Your aim is to perform ATMOST one operation such that in final string number of 1s is maximised. If you don’t want to perform the operation, return an empty array. Else, return an array consisting of two elements denoting L and R. If there are multiple solutions, return the lexicographically smallest pair of L and R.

Notes:

    Pair (a, b) is lexicographically smaller than pair (c, d) if a < c or, if a == c and b < d.

For example,

S = 010

Pair of [L, R] | Final string
_______________|_____________
[1 1]          | 110
[1 2]          | 100
[1 3]          | 101
[2 2]          | 000
[2 3]          | 001

We see that two pairs [1, 1] and [1, 3] give same number of 1s in final string. So, we return [1, 1].

Another example,

If S = 111

No operation can give us more than three 1s in final string. So, we return empty array [].

*/

public class Flip {

	public static void main(String[] args) {
		
		String s = "010";
		System.out.println(flip(s));

	}
	
	public static ArrayList<Integer> flip(String A) {
        
	       
	       int left = -1;
	       int right = 0;
	       int maxSum = -1;
	       
	       int prevSum = -1;
	       int sum = 0;
	       int tempLeft = -1;
	       for(int i = 0; i<A.length(); i++){
	           int a = A.charAt(i)-'0';
	           int value = 1;
	           if(a == 1){
	               value = -1;
	           }
	           if(sum+value >= value){
	               sum += value;
	           }
	           else{
	               sum = value;
	           }
	           
	           if(sum == 1 && prevSum < 0){
	               tempLeft = i;
	           }
	           
	           prevSum = sum;
	           
	           if(sum > maxSum){
	               maxSum = sum;
	               left = tempLeft;
	               right = i;
	           }
	           //System.out.println(left + " : " + right);
	       }
	       
	       ArrayList result = new ArrayList<>();
	       
	       if(left > -1){
	           result.add(left+1);
	           result.add(right+1);
	       }
	       
	       return result;
	      
	    }

}
