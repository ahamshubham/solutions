import java.util.*;
import java.io.*;
import java.lang.*;

class NumberGame {
    public static void main(String args[]) throws IOException {
        System.out.println(solve(new ArrayList<Integer>(Arrays.asList(0,1,5)),1,2));
        System.out.println(solve(new ArrayList<Integer>(Arrays.asList(0,1,2,5)),2,21));
        System.out.println(solve(new ArrayList<Integer>(Arrays.asList(2,4,5)),2,362));
        System.out.println(solve(new ArrayList<Integer>(Arrays.asList(2,4,5)),3,362));
        System.out.println(solve(new ArrayList<Integer>(Arrays.asList(2,4,5)),3,252));
    }
    
    public static int solve(ArrayList<Integer> A, int B, int C) {
        String c = Integer.toString(C);
        int max_elem_size = c.length();
        int set_size = A.size();
        
        int i;
        int sum = 0;
        
        if(set_size == 0)
            return 0;
        
        if(max_elem_size < B)
            return 0;
            
        if(c.length() > B) {
            if(A.get(0) == 0  && B!=1)
                sum = sum + (set_size - 1)*(int)(Math.pow(set_size, B-1));
            else
                sum = sum + (int)(Math.pow(set_size,B));
                
            if(sum > 0)
                return sum;
            else
                return 0;
        }
        
        for(i = 0; i < B; i++) {
            int d = c.charAt(i)-48;
            int k = greaterThanOrEqual(A,d);
            if(k != -1) {
                
                if(A.get(k) == d) {
                    if(i == 0 && A.get(i) == 0 && B!=1)
                        k = k - 1;
                    sum = sum + k * (int)(Math.pow(set_size,(B - i - 1)));
                    continue;
                } else {
                    if(i == 0 && A.get(i) == 0  && B!=1)
                        k = k - 1;
                    sum = sum + (k+1) * (int)(Math.pow(set_size,(B - i - 1)));
                    break;
                }
            } else {
                break;
            }
        }
        
        if(sum < 0)
            return 0;
        else
            return sum;
    }
    
    public static int greaterThanOrEqual(ArrayList<Integer> A, int a) {
        int n = A.size();
        int first = 0;
        int last = n-1;
        int mid;
        
        while(first<=last) {
            mid = (first+last)/2;
            if(a == A.get(mid))
                return mid;
            if(a > A.get(mid))
                first = mid + 1;
            if(a < A.get(mid))
                last = mid - 1;
        }
        return last;
    }
}
