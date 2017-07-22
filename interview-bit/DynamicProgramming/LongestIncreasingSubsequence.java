//length_of_lis(i, element(i)) = max(1 + length_of_lis(i+k, element(i+k)) for all k such that element(i+k) >= element(i))
import java.util.*;
import java.io.*;

class LongestIncreasingSubsequence {
        public static void main(String args[]) throws IOException {
                System.out.println(lis(
                new ArrayList<Integer>(Arrays.asList(0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15))
                ));
                
                System.out.println(lis(
                new ArrayList<Integer>(Arrays.asList(14, 24, 18, 46, 55, 53, 82, 18, 101, 20, 78, 35, 68, 9, 16, 93, 101, 85, 81, 28, 78))
                ));
        }
        
        static int length_of_longest_increasing_subsequence[];
        static List<Integer> b;
        public static int lis(final List<Integer> a) {
                int i;
                b = a;
                length_of_longest_increasing_subsequence = new int[a.size()];
                for(i = 0; i < length_of_longest_increasing_subsequence.length; i++)
                        length_of_longest_increasing_subsequence[i] = -1;
                
                int length_of_lis = 0;
                for(i = 0; i < a.size(); i++)
                        if(length_of_longest_increasing_subsequence(i) > length_of_lis)
                                length_of_lis = length_of_longest_increasing_subsequence[i];
                
                for(i = 0; i < a.size(); i++)
                                System.out.print(length_of_longest_increasing_subsequence[i] + " ");
                
                return length_of_lis;
        }
        
        public static int length_of_longest_increasing_subsequence(int i) {
                if(length_of_longest_increasing_subsequence[i] != -1)
                        return length_of_longest_increasing_subsequence[i];
                else {
                        int j = i+1;
                        int maximum = 0;
                        for(; j < b.size(); j++)
                                if(b.get(i) < b.get(j))
                                        if(maximum < length_of_longest_increasing_subsequence(j))
                                                maximum = length_of_longest_increasing_subsequence[j];
                        
                        length_of_longest_increasing_subsequence[i] = 1 + maximum;
                        
                        return length_of_longest_increasing_subsequence[i];
                }
        }
}
