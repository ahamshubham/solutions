/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
	public ListNode addTwoNumbers(ListNode a, ListNode b) {
	    
	    ListNode prev_node = new ListNode((a.val + b.val) % 10);
	    int carry = (a.val + b.val)/10;
	    a = a.next;
	    b = b.next;
	    
	    ListNode first_node = prev_node;
	    
	    while(a != null || b != null) {
	        if(a == null) {
	            ListNode new_node = new ListNode((b.val + carry) % 10);
	            carry = (b.val + carry) / 10;
	            b = b.next;
	            prev_node.next = new_node;
	            prev_node = new_node;
	            
	        } else if(b == null) {
	            ListNode new_node = new ListNode((a.val + carry) % 10);
	            carry = (a.val + carry) / 10;
	            a = a.next;
	            prev_node.next = new_node;
	            prev_node = new_node;
	            
	        } else {
	            ListNode new_node = new ListNode((a.val + b.val + carry) % 10);
	            carry = (a.val + b.val + carry) / 10;
	            a = a.next;
	            b = b.next;
	            prev_node.next = new_node;
	            prev_node = new_node;
	            
	        }
	    }
	    
	    if(carry != 0) {
	        ListNode new_node = new ListNode(carry);
	        prev_node.next = new_node;
	    }
	        
	    return first_node;
	    
	}
}

