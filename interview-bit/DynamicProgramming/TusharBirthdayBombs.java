import java.io.*;
import java.util.*;

class TusharBirthdayBombs {
        public static void main(String args[]) throws IOException {
                System.out.println(solve(3682,new ArrayList<Integer>(Arrays.asList(13511, 9286, 6132))));
                System.out.println(solve(3682,new ArrayList<Integer>(Arrays.asList(13511, 9286, 6132, 2958, 21799, 5160, 22244, 5969, 14955, 12808, 3456, 11238, 6511, 4637, 2558, 18808, 15537, 5598, 14022, 4885, 17572, 3775, 23999, 21993, 22203, 24768, 22045, 10785, 11393, 7080, 12218, 16247, 7709))));
        }
        
        public static ArrayList<Integer> solve(int A, ArrayList<Integer> B) {
                if(B.size() == 0)
                        return new ArrayList<Integer>();
                else {
                        ArrayList<Integer> kicks = new ArrayList<Integer>();
                        ArrayList<Integer> C = new ArrayList<Integer>();
                        ArrayList<Integer> original_indices = new ArrayList<Integer>(); 
                        
                        int i, j, k;
                        
                        int min = B.get(0);
                        
                        int current = B.get(0);
                        C.add(current);
                        original_indices.add(0);
                        
                        
                        for(i = 0; i < B.size(); i++)
                                if(current > B.get(i)) {
                                        current = B.get(i);
                                        C.add(current);
                                        original_indices.add(i);
                                }
                                
                        B = C;
                        
                        for(i = 0; i < B.size(); i++)
                                if(min > B.get(i))
                                        min = B.get(i);
                        
                        int number_of_kicks = A/min;
                        int number_of_kicks_left = number_of_kicks;
                        
                        System.out.println(number_of_kicks);
                        
                        for(i = 0; i < B.size(); i++) {
                                int number_of_kicks_for_this_index = 0;
                                if(B.get(i) != min)
                                        number_of_kicks_for_this_index = minimum((A - min * number_of_kicks_left)/(B.get(i) - min), number_of_kicks_left);
                                else
                                        number_of_kicks_for_this_index = number_of_kicks_left;
                                for(j = 0; j < number_of_kicks_for_this_index; j++)
                                        kicks.add(original_indices.get(i));
                                number_of_kicks_left -= number_of_kicks_for_this_index;
                                A -= B.get(i) * number_of_kicks_for_this_index;
                        }
                        
                        return kicks;
                        
                }                        
        }
        
        public static int minimum(int A, int B) {
                if(A < B)
                        return A;
                else
                        return B;
        }
}
