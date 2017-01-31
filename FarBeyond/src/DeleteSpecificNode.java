
public class DeleteSpecificNode {
	/* just given an access to a node, simply copy the contents of the
	 * next node to it.
	 */
    public void deleteNode(ListNode node) {
    	ListNode temp = node.next;
        node.val = temp.val;
        node.next = temp.next;
    }

}
