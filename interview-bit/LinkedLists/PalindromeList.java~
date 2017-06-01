import java.util.*;
import java.io.*;

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class PalindromeList {
    public static void main(String args[]) throws IOException {
        ListNode c = new ListNode(1);
        ListNode b = new ListNode(2);
        b.next = c;
        ListNode a = new ListNode(1);
        a.next = b;
        ListNode o = new ListNode(4);
        o.next = a;
        ListNode x = new ListNode(6);
        x.next = o;
                
        System.out.println(lPalin(null));
        System.out.println(lPalin(c));
        System.out.println(lPalin(b));
        System.out.println(lPalin(a));
        System.out.println(lPalin(o));
        System.out.println(lPalin(x));
    }

    public static int lPalin(ListNode A) {
        String a = "";
        int i, palindrome = 1, length = 0, iteration = 0;
        ListNode B = A;
        ListNode C = A;
        ListNode F = null;
        ListNode M = null;
        ListNode CE = null;
        ListNode PE = null;
        ListNode TMP = null;
        ListNode FI = null;
        ListNode LA = null;
        
        System.out.println();
        System.out.println("Original list:");
        ListNode CPY1 = A;
        while(CPY1 != null) {
            System.out.print(CPY1.val+" ");
            CPY1 = CPY1.next;
        }
        System.out.println();
        
        while(B != null) {
            length++;
            F = B;
            B = B.next;
        }
        
        if(length >= 2) {
            
            while(iteration != (length+1)/2) {
                iteration++;
                M = C;
                C = C.next;
            }
            
            System.out.println();
            System.out.println("Middle element:"+M.val);
        
            CE = M.next;
            PE = null;
            M.next = F;
        
            while(CE != F) {
                TMP = CE.next;
                CE.next = PE;
                PE = CE;
                CE = TMP;
            }
        
            if(CE != null)
                CE.next = PE;
                
            FI = A;
            LA = M.next;
            
            while(LA != null) {
                if(FI.val != LA.val) {
                    palindrome = 0;
                    break;
                }
                FI = FI.next;
                LA = LA.next;
            }
        }        
        
        ListNode CPY2 = A;
        System.out.println();
        System.out.println("New list:");
        while(CPY2 != null) {
            System.out.print(CPY2.val+ " ");
            CPY2 = CPY2.next;
        }
        
        System.out.println();
        
        return palindrome;
    }
}

