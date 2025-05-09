package trees;

import java.util.ArrayList;
import java.util.List;

import common.Node;

public class DfsRecursive {

	public List<String> values = new ArrayList<String>();
	
	public void traverse(Node root) {

		if (root == null)
			return;
		
		values.add(root.val);
		
		if (root.left != null) {
			traverse(root.left);
		}
		
		if (root.right != null) {
			traverse(root.right);
		}
	}
	
	public static void main(String args[]) {
		Node a = new Node("a");
		a.left = new Node("b");
		a.right = new Node("c");
		a.left.left = new Node("d");
		a.left.right = new Node("e");
		a.right.right =new Node("f");
				
		DfsRecursive dfs1 = new DfsRecursive();
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
