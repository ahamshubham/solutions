import java.io.*;
import java.util.*;

class MaxSumWithoutAdjacentElements {
        public static void main(String args[]) throws IOException {
               ArrayList<ArrayList<Integer>> input = new ArrayList<ArrayList<Integer>>();
               ArrayList<Integer> row = new ArrayList<Integer>();
               
               Random rand = new Random();
               
               for(int i = 0; i < 10000; i++)
                        row.add(rand.nextInt(100));
               
               /*
               
               BufferedReader buf = new BufferedReader(new FileReader("MSWAE.txt"));
               String s = buf.readLine();
               String ar[] = s.split("],");
               String ar1[] = ar[0].replace("]","").replace("[","").replace(" ","").split(",");
               
               for(int i = 0; i < 10000; i++)
                        row.add(Integer.parseInt(ar1[i]));
               */       
               
               input.add(row);
               input.add(row);
               
               //System.out.println(input);
               System.out.println(adjacent(input));
                
        }
        
        static int maximum_possible_sum_from_index[];
        static ArrayList<Integer> c = new ArrayList<Integer>();
        
        public static int adjacent(ArrayList<ArrayList<Integer>> a) {
                ArrayList<Integer> maximum_value_in_each_column_in_a = new ArrayList<Integer>();
                int i;
                int size_of_a = a.get(0).size();
                maximum_possible_sum_from_index = new int[size_of_a];
                
                
                for(i = 0; i < size_of_a; i++) {
                        maximum_possible_sum_from_index[i] = -1;
                        maximum_value_in_each_column_in_a.add(maximum(a.get(0).get(i), a.get(1).get(i)));
                }
                
                c = maximum_value_in_each_column_in_a;
                
                int incl = 0;
                int excl = 0;
                
                for(i = 0; i < c.size(); i++) {
                        int next_incl = excl + c.get(i);
                        int next_excl = maximum(excl, incl);
                        
                        incl = next_incl;
                        excl = next_excl;
                }
                
                return maximum(incl, excl);
        }
        
        public static int maximum(int a, int b) {
                if(a > b)
                        return a;
                else
                        return b;
        }
        
}
