import java.util.*;
import java.io.*;

class FirstMissingInteger {
    public static void main(String args[]) throws IOException {
    }
    
    public int firstMissingPositive(ArrayList<Integer> a) {
        int n = a.size();
        int b[] = new int[n];
        int i;
        int mispos = n+1;
        
        for(i=0;i<n;i++) {
            b[i] = 0;
        }
        
        for(i=0;i<n;i++) {
            int c = a.get(i);
            if(c>0 && c<=n) {
                b[c-1] = 1;
            }
        }
        
        for(i=0;i<n;i++) {
            if(b[i] == 0) {
                mispos = i+1;
                break;
            }
        }
        
        return mispos;
    }
}
