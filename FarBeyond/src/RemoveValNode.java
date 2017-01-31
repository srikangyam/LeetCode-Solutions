
public class RemoveValNode {

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(3);
		head.next.next.next.next = new ListNode(4);
		head.next.next.next.next.next = new ListNode(3);
		head.next.next.next.next.next.next = new ListNode(5);
		ListNode newH = deleteDuplicates(head, 3);
		head.printList(newH);
	}
    public static ListNode deleteDuplicates(ListNode head, int val) {
    	if (head == null || head.next == null) return head;
    	ListNode newHead = null; 
    	ListNode node = head;
    	ListNode tmpNode = newHead;
    	while (node != null) {
    		if (val != node.val){
    			ListNode newNode = new ListNode(node.val);
    			newNode.next = null;
    			if (newHead == null) {
    			    newHead = newNode;    
    		    } else {
    		        tmpNode.next = newNode;
    		    }
    		    tmpNode = newNode;
    		}
    		    
    		node = node.next;
    	}
    	return newHead;
        
    }


}
