import java.util.*;
import java.io.*;
import java.util.stream.*;

public class LargestNumber {
    public static void main(String args[]) throws IOException {
        List<Integer> a = new ArrayList<Integer>();
        a.add(1);
        a.add(932);
        a.add(9329);
        //System.out.println(a);
        System.out.println(largestNumber(a));
    }
    
    public static String largestNumber(final List<Integer> a) {
        ArrayList<Integer> ar = new ArrayList<Integer>();
        int i;
        
        int non_zero = 0; 
        
        for(i = 0; i < a.size(); i++) {
            if(a.get(i) != 0) {
                non_zero = 1;
                break;
            }
        }
        
        if(non_zero == 0)
            return "0";
        
        //Convert the list into an arraylist
        for(i = 0; i < a.size(); i++) {
            ar.add(a.get(i));
        }
        
        //Sort the arraylist based on the algorithm designed
        Collections.sort(ar, new Comparator<Integer>(){
            @Override
            public int compare(Integer n1, Integer n2) {
                String s1 = n1.toString();
                String s2 = n2.toString();
                
                String s3 = s1 + s2;
                String s4 = s2 + s1;
                
                int l = s3.length();
                
                int loop = 0;
                
                while(loop < l) {
                    if(s3.charAt(loop) < s4.charAt(loop)) {
                        return 1; //swap
                    } else if(s3.charAt(loop) > s4.charAt(loop)) {
                        return -1; //don't swap
                    } else {
                        loop++;
                    }
                }
                
                return 1;
            }
        });
        
        //System.out.println(ar);
        
        //Convert the arraylist to a string
        String result = ar.stream().map(Object::toString).collect(Collectors.joining(""));
        
        return result;       
    }
}
