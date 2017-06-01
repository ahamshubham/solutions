/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode reverseList(ListNode A, int B) {
        
        
        ListNode CE = A; 
        ListNode first_element = null;
        
        ListNode previous_row_last_element = null;
        ListNode current_row_first_element = null;
        ListNode current_row_last_element = null;
        
        while(CE != null) {
            
            current_row_first_element = CE;
            current_row_last_element = null;
            int length = 0;
            
            while(length != B) {
                length++;
                current_row_last_element = CE;
                CE = CE.next;
            }
            
            if(previous_row_last_element == null) {
                first_element = current_row_last_element;
            } else {
                previous_row_last_element.next = current_row_last_element;
            }
            
            previous_row_last_element = current_row_first_element;
            
            ListNode current_element = current_row_first_element.next;
            ListNode previous_element = current_row_first_element;
            
            length = 1;
            
            
            while(length != B) {
                length++;
                ListNode tmp = current_element.next;
                current_element.next = previous_element;
                previous_element = current_element;
                current_element = tmp;
            }
            
        }
        
        if(current_row_first_element != null)
            current_row_first_element.next = null;
        
        return first_element;
        
    }
}
