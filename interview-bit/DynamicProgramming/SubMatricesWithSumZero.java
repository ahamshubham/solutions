import java.util.*;
import java.io.*;

class SubMatricesWithSumZero {
        public static void main(String args[])throws IOException {
                System.out.println(solve(new ArrayList<ArrayList<Integer>>(Arrays.asList(new ArrayList<Integer>(Arrays.asList(1,-1)),
                new ArrayList<Integer>(Arrays.asList(-1,1))))));
        }
        
        static HashMap<String, Integer> sum = new HashMap<String, Integer>();
        
        public static int solve(ArrayList<ArrayList<Integer>> A) {
                int n = A.size(),i,j,k;
                if(n > 0) {
                        int m = A.get(0).size();
                        int total_count = 0;
                        for(i = 0; i < n; i++) {
                                for(j = i; j < n; j++) {
                                        HashMap<String, Integer> count_distinct = new HashMap<String, Integer>();
                                        for(k = 0; k < m; k++) {
                                        
                                                System.out.println("Current index: (" + i + ",0)-(" + j + "," + k +")");
                                                int sum_at_this_index = getSum(i,0,j-1,k) + 
                                                getSum(i,0,j,k-1) - getSum(i,0,j-1,k-1) + A.get(j).get(k);
                                                sum.put(constructKey(i,0,j,k), sum_at_this_index);
                                                
                                                if(count_distinct.get(Integer.toString(sum_at_this_index)) == null)
                                                        count_distinct.put(Integer.toString(sum_at_this_index),1);
                                                else
                                                        count_distinct.put(Integer.toString(sum_at_this_index),
                                                        count_distinct.get(Integer.toString(sum_at_this_index))+1);
                                                
                                        }
                                        
                                        System.out.println(count_distinct);
                                        
                                        List<String> values = new ArrayList(count_distinct.keySet());
                                        
                                        for(k = 0; k < values.size(); k++) {
                                                int count_at_this_index = count_distinct.get(values.get(k));
                                                if(values.get(k).equals("0"))
                                                        total_count = total_count + count_at_this_index;
                                                total_count = total_count + (count_at_this_index * (count_at_this_index - 1))/2;
                                        }
                                }
                        }
                        
                        return total_count;
                        
                } else {
                        return 0;
                }
        }
        
        
        
        public static String constructKey(int start_x, int start_y, int end_x, int end_y) {
                String end_points = "(" + start_x + "," + start_y + ") - (" + end_x + "," + end_y + ")";
                System.out.println(end_points);
                return end_points;
        }
        
        public static int getSum(int start_x, int start_y, int end_x, int end_y) {
                if(end_x < 0 || end_y < 0 || end_x < start_x)
                        return 0;
                else
                        return sum.get(constructKey(start_x, start_y, end_x, end_y));
        }
}
