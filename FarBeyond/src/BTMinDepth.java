import java.util.LinkedList;
import java.util.Queue;

public class BTMinDepth {
    public int minDepth(TreeNode root) {
    	if (root == null) return 0;
    	Queue<TreeNode> q = new LinkedList<TreeNode>();
    	q.offer(root);
    	q.offer(null);
    	int count = 1;
    	while (!q.isEmpty()) {
    		TreeNode currentNode = q.poll();
    		if (currentNode != null) {
    			if (currentNode.left == null && currentNode.right == null) return count;
    			
    			if (currentNode.left != null) {
    				q.offer(currentNode.left);
    			}
    			
    			if (currentNode.right != null) {
    				q.offer(currentNode.right);
    			}
    		} else {
    			if (!q.isEmpty()) {
    				count++;
    				q.offer(null);
    			}
    		}
    	}
    	return count;
        
    }

}
