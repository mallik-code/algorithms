package trees;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import common.Node;

public class BfsQueue {

	public List<String> values = new ArrayList<>();
	
	/*
	 * Here queue is used to achieve BFS (read all elements at each level)
	 * The first root is inserted into queue then reads its left node and and adds into into the queue
	 * and again it reads the right node then adds into the queue 
	 * this means the roots left and right nodes are read and inserted into the values array (level 2) is done
	 * 
	 */

	public void traverse(Node root) {

		if (root == null)
			return;

		Deque<Node> queue = new LinkedList<Node>();
		queue.offer(root);  //adds into the queue
		
		while(!queue.isEmpty()) {
			Node endNode = queue.remove(); //removes from queue
			values.add(endNode.val);
			if(endNode.left!=null) queue.offer(endNode.left); //inserts into queue
			if(endNode.right!=null) queue.offer(endNode.right); //inserts into queue
		}
	}

	public static void main(String args[]) {
		Node a = new Node("a");
		a.left = new Node("b");
		a.right = new Node("c");
		a.left.left = new Node("d");
		a.left.right = new Node("e");
		a.right.right = new Node("f");

		BfsQueue bfs = new BfsQueue();
		bfs.traverse(a);
		bfs.values.forEach(v -> System.out.print(v + ", "));
		//		  		  a
		//				 / \	
		//				b 	c
		//			   / \   \			
		//			  d	  e   f
		//
		// a b c d e f
	}
}
