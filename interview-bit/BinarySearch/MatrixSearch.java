import java.util.*;
import java.io.*;

class MatrixSearch {
        public static void main(String args[]) throws IOException {
                ArrayList<ArrayList<Integer>> a = new ArrayList<ArrayList<Integer>>();
                a.add(new ArrayList<Integer>(Arrays.asList(3)));
                a.add(new ArrayList<Integer>(Arrays.asList(29)));
                a.add(new ArrayList<Integer>(Arrays.asList(41)));
                a.add(new ArrayList<Integer>(Arrays.asList(63)));
                a.add(new ArrayList<Integer>(Arrays.asList(67)));
                a.add(new ArrayList<Integer>(Arrays.asList(72)));
                a.add(new ArrayList<Integer>(Arrays.asList(74)));
                a.add(new ArrayList<Integer>(Arrays.asList(78)));
                a.add(new ArrayList<Integer>(Arrays.asList(85)));
                
                System.out.println(searchMatrix(a,41));
        }
        
        public static int searchMatrix(ArrayList<ArrayList<Integer>> a, int b) {
                ArrayList<Integer> c = new ArrayList<Integer>();
                int i, j;
                
                if(a.size() == 0)
                        return 0;
                
                if(a.get(0).size() == 0)
                        return 0;
                
                int greater_than_or_equal_to = -1;
                
                for(i = 0; i < a.size(); i++)
                        if(b >= a.get(i).get(0))
                                greater_than_or_equal_to = i;
                        else
                                break;
                                
                if(greater_than_or_equal_to == -1)
                        return 0;
                                
                return searchList(a.get(greater_than_or_equal_to), b); 
        }
        
        public static int searchList(ArrayList<Integer> a, int b) {
                int i, lower = 0, upper = a.size() - 1;
                int mid = (lower + upper)/2;
                
                while(lower <= upper) {
                        if(b > a.get(mid))
                                lower = mid + 1;
                        if(b < a.get(mid))
                                upper = mid - 1;
                        if(b == a.get(mid))
                                return 1;
                        mid = (lower + upper)/2;
                }
                
                return 0;
        }
}
