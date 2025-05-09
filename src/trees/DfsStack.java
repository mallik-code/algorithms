package trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import common.Node;

public class DfsStack {
	
	public List<String> values = new ArrayList<>();
	
	public void traverse(Node root) {
		
		if(root==null) return;
		
		Deque<Node> stack = new ArrayDeque<Node>();
		stack.push(root);
		
		while(!stack.isEmpty()) {
			Node current = stack.pop();
			values.add(current.val);
			if(current.right !=null) stack.push(current.right);
			if(current.left !=null) stack.push(current.left);
			
		}
		values.forEach(v->System.out.println(v+", "));
	}

	public static void main(String args[]) {
		Node a = new Node("a");
		a.left = new Node("b");
		a.right = new Node("c");
		a.left.left = new Node("d");
		a.left.right = new Node("e");
		a.right.right =new Node("f");
				
		DfsStack dfs1 = new DfsStack();
		dfs1.traverse(a);
		dfs1.values.forEach(v->System.out.print(v +", "));
				//				  a
				//				 / \	
				//				b 	c
				//			   / \   \			
				//			  d	  e   f
				// a b d e c f
	}
}
