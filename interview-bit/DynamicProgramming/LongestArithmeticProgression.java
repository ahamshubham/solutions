import java.io.*;
import java.util.*;
import java.util.stream.*;

public class LongestArithmeticProgression {
        public static void main(String args[]) throws IOException {
                System.out.println(solve(Arrays.asList(9,2,2,2,2)));
        }
        
        public static int solve(final List<Integer> A) {
                int n = A.size();
                int difference_between_pairs[][] = new int[n][n];
                int length_of_longest_sequence[][] = new int[n][n];
                int i,j;
                int longest = 0;
                ArrayList<ArrayList<Integer>> difference_values = new ArrayList<ArrayList<Integer>>();
                
                for(i = 1; i < n; i ++) {
                        
                        for(j = 0; j < i; j++) {
                                length_of_longest_sequence[i][j] = 0;
                                difference_between_pairs[i][j] = A.get(i) - A.get(j);
                        }
                }
                
                
                ArrayList<Map<Integer, ArrayList<Integer>>> difference_values_count_list = new ArrayList();
                
                for(j = 0; j < n; j++) {
                        
                        difference_values_count_list.add(new HashMap());
                        
                        for(i = j + 1; i < n; i ++) {
                                int diff = difference_between_pairs[i][j];
                                if(difference_values_count_list.get(j).containsKey(diff))
                                        difference_values_count_list.get(j).get(diff).add(i);
                                else {
                                        difference_values_count_list.get(j).put(diff,new ArrayList(Arrays.asList(i)));
                                }
                        }
                        
                }                
                
                
                for(i = 1; i < n; i ++) {
                        for(j = 0; j < i; j++) {
                                int longest_for_this_pair = findOutLengthOfLongestSequence(difference_values_count_list, difference_between_pairs[i][j], difference_between_pairs, length_of_longest_sequence, i, j, n);
                                if(longest_for_this_pair > longest)
                                        longest = longest_for_this_pair;
                                
                        }
                }
                
                if(A.size() == 0)
                        return 0;
                else
                        return longest+1;
                
        }
        
        public static int findOutLengthOfLongestSequence(ArrayList<Map<Integer, ArrayList<Integer>>> diff_positions, int difference, int[][] diff, int[][] longest, int i, int j, int n) {
        
                if(longest[i][j] != 0)
                        return longest[i][j];
                
                int k,l;
                int max = 1;
                
                ArrayList<Integer> diff_positions_for_each_column = diff_positions.get(i).get(difference);
                
                if(diff_positions_for_each_column != null) {
                        for(k = 0; k < diff_positions_for_each_column.size(); k ++) {
                        
                                int longest_for_this_pair = findOutLengthOfLongestSequence(diff_positions, difference, diff, longest, diff_positions_for_each_column.get(k), i, n);
                                if(longest_for_this_pair + 1 > max)
                                        max = longest_for_this_pair + 1;
                        }
                }
                
                longest[i][j] = longest[i][j] + max;
                return longest[i][j];
        }
}
