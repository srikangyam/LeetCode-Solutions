/**
 * Definition for singly-linked list.
 */
  public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; next=null;}
      
      void printList(ListNode node) {
          while (node != null) {
              System.out.print(node.val + " ");
              node = node.next;
          }
      }
  }
 

