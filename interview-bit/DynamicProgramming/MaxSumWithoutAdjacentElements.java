import java.io.*;
import java.util.*;

class MaxSumWithoutAdjacentElements {
        public static void main(String args[]) throws IOException {
               ArrayList<ArrayList<Integer>> input = new ArrayList<ArrayList<Integer>>();
               input.add(new ArrayList<Integer>(Arrays.asList(0,0,0,0,0)));
               input.add(new ArrayList<Integer>(Arrays.asList(0,0,0,0,0)));
               System.out.println(adjacent(input)); 
        }
        
        static int maximum_possible_sum_from_index[];
        
        public static int adjacent(ArrayList<ArrayList<Integer>> a) {
                ArrayList<Integer> maximum_value_in_each_column_in_a = new ArrayList<Integer>();
                int i;
                int size_of_a = a.get(0).size();
                maximum_possible_sum_from_index = new int[size_of_a];
                
                
                for(i = 0; i < size_of_a; i++) {
                        maximum_possible_sum_from_index[i] = -1;
                        maximum_value_in_each_column_in_a.add(maximum(a.get(0).get(i), a.get(1).get(i)));
                }
                
                return maximum_sum_possible_in_subsequence(maximum_value_in_each_column_in_a, 0);
        }
        
        public static int maximum_sum_possible_in_subsequence(ArrayList<Integer> a, int current_index) {
                if(current_index >= a.size())
                        return 0;
                if(current_index + 1 >= a.size())
                        return a.get(current_index);
                if(maximum_possible_sum_from_index[current_index] != -1)
                        return maximum_possible_sum_from_index[current_index];
                
                maximum_possible_sum_from_index[current_index] = maximum(a.get(current_index) + 
                maximum_sum_possible_in_subsequence(a, current_index + 2), a.get(current_index + 1) +
                maximum_sum_possible_in_subsequence(a, current_index + 3));
                
                return maximum_possible_sum_from_index[current_index];
        }
        
        public static int maximum(int a, int b) {
                if(a > b)
                        return a;
                else
                        return b;
        }
        
}
