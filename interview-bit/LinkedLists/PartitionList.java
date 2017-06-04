import java.io.*;
import java.util.*;

class PartitionList {
        public static void main(String args[]) throws IOException {
                
        }
        
        public static ListNode partition(ListNode a, int b) {
                ListNode FE = a;
                ListNode LSE = null;
                
                if(FE != null) {
                        ListNode PE = FE;
                        ListNode CE = FE.next;
                        
                        if(PE.val < b)
                                LSE = PE;
                        
                        while(CE != null) {
                                if(CE.val < b && LSE != PE) {
                                        if(LSE == null) {
                                                PE.next = CE.next;
                                                CE.next = FE;
                                                FE = CE;
                                                LSE = FE;
                                                CE = PE.next;
                                        } else {
                                                PE.next = CE.next;
                                                CE.next = LSE.next;
                                                LSE.next = CE;
                                                LSE = CE;
                                                CE = PE.next;
                                        }
                                        
                                }
                                else if(CE.val < b && LSE == PE) {
                                        LSE = CE;
                                        PE = PE.next;
                                        CE = CE.next;
                                }
                                else {
                                        PE = PE.next;
                                        CE = CE.next;
                                }
                        }
                        
                }
                return FE;
        }
}
