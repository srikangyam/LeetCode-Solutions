

public class MaxDepthSol {
    public int maxDepth(TreeNode root) {
    	int sumL = 0, sumR = 0;
    	if (root != null){
    		if ((root.left == null) && (root.right == null)) return 1;
    		else {
    			if (root.left != null){
    				sumL = 1 + maxDepth(root.left);
    			}
    			if (root.right != null){
    				sumR = 1 + maxDepth(root.right);
    			}
    			return Math.max(sumL, sumR);
    		}
    	}
    	return 0;
        
    }
    
   
}