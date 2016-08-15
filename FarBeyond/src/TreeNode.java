/**
 * Definition for a binary tree node.
 */
  public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      
      TreeNode(){
    	  left = null;
    	  right = null;
    	  val = -1;
      }
      
      TreeNode(int x) {
    	  left = null;
    	  right = null;
    	  val = x; 
      }
      
      /* Function to set left node */
      public void setLeft(TreeNode n)
      {
          left = n;
      }
      /* Function to set right node */ 
      public void setRight(TreeNode n)
      {
          right = n;
      }
      /* Function to get left node */
      public TreeNode getLeft()
      {
          return left;
      }
      /* Function to get right node */
      public TreeNode getRight()
      {
          return right;
      }
      /* Function to set data to node */
      public void setData(int d)
      {
          val = d;
      }
      /* Function to get data from node */
      public int getData()
      {
          return val;
      }      
  }


