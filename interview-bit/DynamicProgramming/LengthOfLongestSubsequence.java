public class Solution {
       int length_of_longest_increasing_decreasing_subsequence[];
       int length_of_longest_decreasing_subsequence[];
       
       public int longestSubsequenceLength(final List<Integer> A) {
               int n = A.size();
               length_of_longest_increasing_decreasing_subsequence = new int[n];
               length_of_longest_decreasing_subsequence = new int[n];
               
               int max = 0, i;
               
               for(i = 0; i < n; i++) {
                       length_of_longest_increasing_decreasing_subsequence[i] = -1;
                       length_of_longest_decreasing_subsequence[i] = -1;
               }
                               
               for(i = 0; i < n; i++) {
                       int current = find_length_of_longest_increasing_decreasing_subsequence(i, n, A);
                       if(current > max)
                               max = current;
               }
               
               return max;
       }
       
       public int find_length_of_longest_increasing_decreasing_subsequence(int start_index, int n, List<Integer> A) {
               if(length_of_longest_increasing_decreasing_subsequence[start_index] != -1)
                       return length_of_longest_increasing_decreasing_subsequence[start_index];
               
               if(start_index == n-1)
                       return 1;
               
               int max = 0, present_max_length;
                       
               for(int i = start_index + 1; i < n; i++) {
                       if(A.get(i) > A.get(start_index)) {
                               present_max_length = find_length_of_longest_increasing_decreasing_subsequence(i, n, A);
                               length_of_longest_increasing_decreasing_subsequence[i] = present_max_length;

//System.out.println("LID:i,count:"+ i +","+present_max_length);
                               if(present_max_length > max)
                                       max = present_max_length;
                       }
                       
                       if(A.get(i) < A.get(start_index)) {
                               present_max_length = find_length_of_longest_decreasing_subsequence(i, n, A);
                               length_of_longest_decreasing_subsequence[i] = present_max_length;

//System.out.println("LD:i,count:"+ i +","+present_max_length);
                               if(present_max_length > max)
                                       max = present_max_length;
                       }
               }
               
               return 1 + max;
       }
       
       public int find_length_of_longest_decreasing_subsequence(int start_index, int n, List<Integer> A) {
               if(length_of_longest_decreasing_subsequence[start_index] != -1)
                       return length_of_longest_decreasing_subsequence[start_index];
               
               if(start_index == n-1)
                       return 1;
               
               int max = 0, present_max_length;
                       
               for(int i = start_index + 1; i < n; i++) {
                       if(A.get(i) < A.get(start_index)) {
                               present_max_length = find_length_of_longest_decreasing_subsequence(i, n, A);
                               length_of_longest_decreasing_subsequence[i] = present_max_length;

//System.out.println("LD:i,count:"+ i +","+present_max_length);
                               if(present_max_length > max)
                                       max = present_max_length;
                       }
               }
               
               return 1 + max;
       }
}

