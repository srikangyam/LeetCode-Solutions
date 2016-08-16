
public class InvertBinaryTreeSol {
	
    public TreeNode invertTree(TreeNode root) {
    	if (root != null){
    		//1. Swap the left and right nodes of the root
    		
    		swapNode(root);
    		
    		//2. If the root has a left, run the invert on the left node
    		if (root.left != null){
    			invertTree(root.left);
    		}
    		
    		//3. If the root has a right, run the invert on the right node
    		if (root.right != null){
    			invertTree(root.right);
    		}
    	}
    	return root;
    }
    
    public static TreeNode swapNode(TreeNode root){
    	TreeNode temp = root.left;
    	root.left = root.right;
    	root.right = temp;
    	
    	return root;
    }

}
