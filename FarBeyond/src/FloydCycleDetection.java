
public class FloydCycleDetection {
	/* This is Floyd Cycle Detection test
	 * We have two pointers, one a slow pointer which moves one pace
	 * where as another pointer fast, which moves two paces at a time.
	 * If they meet, a loop exists.
	 */
    public boolean hasCycle(ListNode head) {
    	ListNode slowPtr = head;
    	ListNode fastPtr = head;
    	while ((slowPtr != null) && (fastPtr != null) && (fastPtr.next != null)) {
    		slowPtr = slowPtr.next;
    		fastPtr = fastPtr.next.next;
    		if (slowPtr == fastPtr) return true;
    	}
        return false;
    }

}
