import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LevelOrderTraversal2 {
	/* this not only covers reversal of level order 
	 * you can use level order to print deepest node 
	 * by printing the last nodeValues being added which
	 * indicates the last level
	 */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
    	
    	List<List<Integer>> al = new ArrayList<List<Integer>>();
        List<Integer> nodeValues = new ArrayList<Integer>();
        List<List<Integer>> alR = new ArrayList<List<Integer>>();
        if(root == null)
            return alR;
     
        LinkedList<TreeNode> current = new LinkedList<TreeNode>();
        LinkedList<TreeNode> next = new LinkedList<TreeNode>();
        current.add(root);
     
        while(!current.isEmpty()){
            TreeNode node = current.remove();
     
            if(node.left != null)
                next.add(node.left);
            if(node.right != null)
                next.add(node.right);
     
            nodeValues.add(node.val);
            if(current.isEmpty()){
                current = next;
                next = new LinkedList<TreeNode>();
                al.add(nodeValues);
                nodeValues = new ArrayList<Integer>();
            }
     
        }
        
        for (int i = al.size() - 1; i >= 0; i--){
        	alR.add(al.get(i));
        }
        
        return alR;
        
    }
	
	

}
