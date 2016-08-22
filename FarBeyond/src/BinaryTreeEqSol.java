/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
public class BinaryTreeEqSol {
	public boolean isSameTree(TreeNode p, TreeNode q) {
		if ((p == null) && (q == null)) {
			return true;
		} else {
			if ((p != null) && (q != null)) {
				if (isNodeEqual(p, q)) {
					if (isSameTree(p.left, q.left) && isSameTree(p.right, q.right)) {
						return true;
					}
				}
			}
			return false;
		}

	}

	private boolean isNodeEqual(TreeNode p, TreeNode q) {
		/*
		 * 1. Check if the values at the node are equal 2. Check if p has a left
		 * node, q should have a left node 3. Check if p has a right node, q
		 * should have a right node 4. If none of the conditions match, return
		 * FALSE
		 */

		if (p.val == q.val) {
			if (hasLeftNode(p, q) && hasRightNode(p, q)) {
				return true;
			}
		}
		return false;
	}

	private boolean hasRightNode(TreeNode p, TreeNode q) {
		if (!((p.right != null) ^ (q.right != null))) {
			return true;
		}
		return false;
	}

	private boolean hasLeftNode(TreeNode p, TreeNode q) {
		if (!((p.left != null) ^ (q.left != null))) {
			return true;
		}
		return false;
	}

}
