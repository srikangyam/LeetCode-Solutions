
public class OddEvenListSol {
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		ListNode newH = oddEvenList(head);
		head.printList(newH);
	}
    
	public static ListNode oddEvenList(ListNode head) {
    	if (head == null) return head;
    	
    	ListNode odd = head;
    	ListNode even = head.next;
    	
    	ListNode evenFirst = even;
    	
    	while (true){
    		// If there are no more nodes, then connect
    		// first node of even to last node of odd
    		if ( (odd == null) || (even == null) || (even.next == null)) {
    			odd.next = evenFirst;
    			break;
    		}
    		
    		//Join the odd nodes
        	odd.next = even.next;
        	odd = even.next;
        	
        	//If there are no more even nodes 
        	// after current odd node
        	if (odd.next == null){
        		even.next = null;
        		odd.next = evenFirst;
        		break;
        	}
        	
        	//Join even nodes
        	even.next = odd.next;
        	even = odd.next;
    	}
    	
    	
        return head;
    }

}
