
public class LinkedListPalindrome {
	/* Function to check if given linked list is
    palindrome or not 
    This method takes O(n) time and O(1) extra space.
1) Get the middle of the linked list.
2) Reverse the second half of the linked list.
3) Check if the first half and second half are identical.
4) Construct the original linked list by reversing the second half again and attaching it back to the first half
*/
	
	ListNode slow_ptr, fast_ptr, second_half;
 boolean isPalindrome(ListNode head) 
 {   
     slow_ptr = head; fast_ptr = head;
     ListNode prev_of_slow_ptr = head;
     ListNode midnode = null;  // To handle odd size list
     boolean res = true; // initialize result

     if (head != null && head.next != null) 
     {
         /* Get the middle of the list. Move slow_ptr by 1
            and fast_ptrr by 2, slow_ptr will have the middle
            node */
         while (fast_ptr != null && fast_ptr.next != null) 
         {
             fast_ptr = fast_ptr.next.next;

             /*We need previous of the slow_ptr for
               linked lists  with odd elements */
             prev_of_slow_ptr = slow_ptr;
             slow_ptr = slow_ptr.next;
         }

         /* fast_ptr would become NULL when there are even elements 
            in the list and not NULL for odd elements. We need to skip  
            the middle node for odd case and store it somewhere so that
            we can restore the original list */
         if (fast_ptr != null) 
         {
             midnode = slow_ptr;
             slow_ptr = slow_ptr.next;
         }

         // Now reverse the second half and compare it with first half
         second_half = slow_ptr;
         prev_of_slow_ptr.next = null; // NULL terminate first half
         reverse();  // Reverse the second half
         res = compareLists(head, second_half); // compare

         /* Construct the original list back */
         reverse(); // Reverse the second half again
          
         if (midnode != null) 
         {
             // If there was a mid node (odd size case) which                                                         
             // was not part of either first half or second half.
             prev_of_slow_ptr.next = midnode;
             midnode.next = second_half;
         } else
             prev_of_slow_ptr.next = second_half;
     }
     return res;
 }

 /* Function to reverse the linked list  Note that this
    function may change the head */
 void reverse() 
 {
     ListNode prev = null;
     ListNode current = second_half;
     ListNode next;
     while (current != null) 
     {
         next = current.next;
         current.next = prev;
         prev = current;
         current = next;
     }
     second_half = prev;
 }

 /* Function to check if two input lists have same val*/
 boolean compareLists(ListNode head1, ListNode head2) 
 {
     ListNode temp1 = head1;
     ListNode temp2 = head2;

     while (temp1 != null && temp2 != null) 
     {
         if (temp1.val == temp2.val) 
         {
             temp1 = temp1.next;
             temp2 = temp2.next;
         } else
             return false;
     }

     /* Both are empty reurn 1*/
     if (temp1 == null && temp2 == null)
         return true;

     /* Will reach here when one is NULL
        and other is not */
     return false;
 }

}
