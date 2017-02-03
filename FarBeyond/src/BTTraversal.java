import java.util.ArrayList;
import java.util.List;

public class BTTraversal {
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> inList = new ArrayList<Integer>();
        if (root == null) return inList;
        if (root != null) {
           if (root.left != null) {
        	   inList.addAll(inorderTraversal(root.left));
           } 
           inList.add(root.val);
           if (root.right != null) {
            	inList.addAll(inorderTraversal(root.right));
           }
        }
        return inList;
    }
	
    public List<Integer> preorderTraversal(TreeNode root) {
    	List<Integer> preList = new ArrayList<Integer>();
        if (root == null) return preList;
        if (root != null) {
        	preList.add(root.val);
           if (root.left != null) {
        	   preList.addAll(preorderTraversal(root.left));
           } 
           
           if (root.right != null) {
            	preList.addAll(preorderTraversal(root.right));
           }
        }
        return preList;
        
    }
    
    public List<Integer> postorderTraversal(TreeNode root) {
    	List<Integer> postList = new ArrayList<Integer>();
        if (root == null) return postList;
        if (root != null) {
           if (root.left != null) {
        	   postList.addAll(postorderTraversal(root.left));
           } 
           
           if (root.right != null) {
            	postList.addAll(postorderTraversal(root.right));
           }
           postList.add(root.val);
        }
        return postList;
        
    }

}
