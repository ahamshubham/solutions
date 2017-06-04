import java.util.*;
import java.util.io;

public class ListCycle {
        public static void main(String args[]) throws IOException {
                
        }
        
        public static ListNode detectCycle(ListNode a) {
                ListNode P1 = a;
                ListNode P2 = a;
                
                while(P1 != null && P2 != null) {
                        P1 = P1.next;
                        
                        if(P2.next == null){
                                P2 = null;
                                break;
                        } else P2 = P2.next.next;
                                
                        if(P1 == P2)
                                break;
                }
                
                if(P1 == null || P2 == null)
                        return null;
                else {
                        ListNode CE = a;
                        
                        while(CE.next != null) {
                                ListNode tmp = CE.next;
                                CE.next = null;
                                CE = tmp;
                        }
                        
                        return CE;
                }
        }
}
