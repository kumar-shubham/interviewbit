package com.interviewbit.arrays;

import java.util.ArrayList;

//https://www.interviewbit.com/problems/pascal-triangle/

/*
Pascal Triangle

    Asked in:  
    Google
    Amazon

Given numRows, generate the first numRows of Pascal’s triangle.

Pascal’s triangle : To generate A[C] in row R, sum up A’[C] and A’[C-1] from previous row R - 1.

Example:

Given numRows = 5,

Return

[
     [1],
     [1,1],
     [1,2,1],
     [1,3,3,1],
     [1,4,6,4,1]
]

*/

public class PascalTriangle {

	public static void main(String[] args) {
		
		ArrayList<ArrayList<Integer>> res = generate(5);
		
		for(ArrayList<Integer> r : res) {
			System.out.println(r);
		}

	}

	public static ArrayList<ArrayList<Integer>> generate(int a) {

		ArrayList<ArrayList<Integer>> tri = new ArrayList<ArrayList<Integer>>();

		ArrayList<Integer> last = null;
		for (int i = 0; i < a; i++) {
			ArrayList<Integer> list = new ArrayList<Integer>();

			if (i == 0) {
				list.add(1);
				tri.add(list);
				last = list;
				continue;
			}

			int length = last.size();

			list.add(1);

			for (int j = 1; j < length; j++) {

				list.add(last.get(j) + last.get(j - 1));

			}
			list.add(last.get(length - 1));
			tri.add(list);
			last = list;
			// System.out.println(last);
		}

		return tri;
	}

}
