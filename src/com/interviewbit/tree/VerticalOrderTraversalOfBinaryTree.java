package com.interviewbit.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

//https://www.interviewbit.com/problems/vertical-order-traversal-of-binary-tree/

/*
Vertical Order traversal of Binary Tree

    Asked in:  
    Amazon

Problem Setter: yashpal1995 Problem Tester: RAMBO_tejasv

Given a binary tree, return a 2-D array with vertical order traversal of it.
Go through the example and image for more details.

Example :
Given binary tree:

      6
    /   \
   3     7
  / \     \
 2   5     9

returns

[
    [2],
    [3],
    [6 5],
    [7],
    [9]
]

Note : If 2 Tree Nodes shares the same vertical level then the one with lesser depth will come first.

*/

public class VerticalOrderTraversalOfBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode A) {

		HashMap<Integer, ArrayList<NodeX>> map = new HashMap<>();

		traverse(A, 0, 0, map);

		List<Integer> keys = new ArrayList<>(map.keySet());
		Collections.sort(keys);

		ArrayList<ArrayList<Integer>> result = new ArrayList<>();

		for (int key : keys) {
			ArrayList<NodeX> list = map.get(key);
			Collections.sort(list);
			ArrayList<Integer> list1 = new ArrayList<>();
			for (NodeX nodex : list) {
				list1.add(nodex.val);
			}
			result.add(list1);
		}

		return result;

	}

	public void traverse(TreeNode a, int index, int level, HashMap<Integer, ArrayList<NodeX>> map) {

		if (a == null) {
			return;
		}
		ArrayList<NodeX> list = null;
		if (map.containsKey(index)) {
			list = map.get(index);
		} else {
			list = new ArrayList<NodeX>();
			map.put(index, list);
		}
		list.add(new NodeX(a.val, level));

		traverse(a.left, index - 1, level + 1, map);
		traverse(a.right, index + 1, level + 1, map);

	}

}

class NodeX implements Comparable<NodeX> {
	public int val;
	public int level;

	public NodeX(int val, int level) {
		this.val = val;
		this.level = level;
	}

	public int compareTo(NodeX that) {
		if (this.level > that.level) {
			return 1;
		} else if (this.level < that.level) {
			return -1;
		}
		return 0;
	}

}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
		left = null;
		right = null;
	}
}
