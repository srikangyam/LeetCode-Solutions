
public class ReverseListCheck {
	/**
	 * Definition for singly-linked list.
	 * public class ListNode {
	 *     int val;
	 *     ListNode next;
	 *     ListNode(int x) { val = x; }
	 * }
	 */
     public ListNode reverseListIterative(ListNode head) {
    	
    			 ListNode prev = null;
    			 ListNode newHead = head;
    			 while (head != null){ 
    				 newHead = newHead.next;
    				 head.next = prev;
    				 prev = head;
    				 head = newHead;
    			 }
    			 return prev;
	    }
     
     public ListNode reverseListRecursive(ListNode head) {
    	    if (head == null || head.next == null) return head;
    	    ListNode p = reverseListRecursive(head.next);
    	    head.next.next = head;
    	    head.next = null;
    	    return p;
    	}



}
