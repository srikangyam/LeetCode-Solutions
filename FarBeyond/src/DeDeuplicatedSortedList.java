
public class DeDeuplicatedSortedList {
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(3);
		head.next.next.next.next = new ListNode(4);
		ListNode newH = deleteDuplicates(head);
		head.printList(newH);
	}
    public static ListNode deleteDuplicates(ListNode head) {
    	if (head == null || head.next == null) return head;
        int tempVal = head.val;
    	ListNode newHead = new ListNode(head.val);
    	newHead.next = null;
    	ListNode node = head.next;
    	ListNode tmpNode = newHead;
    	while (node != null) {
    		if (tempVal != node.val){
    			tempVal = node.val;
    			ListNode newNode = new ListNode(node.val);
    			newNode.next = null;
    			if (newHead.next == null) {
    			    newHead.next = newNode;    
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
