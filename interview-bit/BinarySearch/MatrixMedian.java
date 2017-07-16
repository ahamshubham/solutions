import java.util.*;
import java.io.*;

class MatrixMedian {
        public static void main(String args[]) throws IOException {
                ArrayList<ArrayList<Integer>> A = new ArrayList<ArrayList<Integer>>();
                A.add(new ArrayList<Integer>(Arrays.asList(1)));
                A.add(new ArrayList<Integer>(Arrays.asList(4)));
                A.add(new ArrayList<Integer>(Arrays.asList(3)));
                A.add(new ArrayList<Integer>(Arrays.asList(1)));
                A.add(new ArrayList<Integer>(Arrays.asList(2)));
                A.add(new ArrayList<Integer>(Arrays.asList(4)));
                A.add(new ArrayList<Integer>(Arrays.asList(4)));
                A.add(new ArrayList<Integer>(Arrays.asList(4)));
                A.add(new ArrayList<Integer>(Arrays.asList(2)));
                A.add(new ArrayList<Integer>(Arrays.asList(2)));
                A.add(new ArrayList<Integer>(Arrays.asList(1)));
                System.out.println(findMedian(A));
        }
        
        public static int findMedian(ArrayList<ArrayList<Integer>> A) {
                int i, j, prev_element_not_larger_than_median = -1, prev_element_not_smaller_than_median = A.get(0).get(0);
                int N = A.size();
                int M = A.get(0).size();
                int median_position = (N*M)/2 + 1;
                for(i = 0; i < N; i++)
                        for(j = 0; j < M; j++)
                                if(prev_element_not_smaller_than_median < A.get(i).get(j))
                                        prev_element_not_smaller_than_median = A.get(i).get(j);
                
                for(i = 0; i < N; i++)
                        for(j = 0; j < M; j++) {
                                if(prev_element_not_larger_than_median > A.get(i).get(j))
                                        continue;
                                if(prev_element_not_smaller_than_median < A.get(i).get(j))
                                        continue;
                                
                                int pos = findPosition(A, A.get(i).get(j), median_position);
                                if(pos == 0)
                                        return A.get(i).get(j);
                                else if(pos == 1)
                                        prev_element_not_smaller_than_median = A.get(i).get(j);
                                else
                                        prev_element_not_larger_than_median = A.get(i).get(j);
                        }
               return -1;
        }
        
        public static int findPosition(ArrayList<ArrayList<Integer>> A, int element, int median_position) {
                int lowest_position = 0;
                int highest_position = 0;
                for(int i = 0; i < A.size(); i++) {
                        int minimum_position = numberOfElementsLesserThanCurrentElementInRow(A.get(i), element);
                        int maximum_position = numberOfElementsGreaterThanOrEqualToCurrentElementInRow(A.get(i), element);
                        //System.out.println("Minimum possible position of "+element+" in row " + A.get(i) + " is " + minimum_position);
                        //System.out.println("Maximum possible position of "+element+" in row " + A.get(i) + " is " + maximum_position);
                        lowest_position += minimum_position;
                        highest_position += maximum_position;
                }
                
                lowest_position = lowest_position + 1;
                
                //System.out.println("Lowest possible position of "+element+" in matrix is " + lowest_position);
                //System.out.println("Highest possible position of "+element+" in matrix is " + highest_position);
                
                if(median_position > highest_position)
                        return -1;
                else if(median_position < lowest_position)
                        return 1;
                else
                        return 0;
        }
        
        public static int numberOfElementsGreaterThanOrEqualToCurrentElementInRow(ArrayList<Integer> row, int element) {
                int lower = 0, upper = row.size()-1;
                int mid = (lower + upper)/2;
                while(lower < upper) {
                        if(row.get(mid) > element)
                                upper = mid - 1;
                        if(row.get(mid) <= element)
                                lower = mid + 1;
                        mid = (lower + upper)/2;
                }
                
                if(row.get(mid) > element)
                	return mid;
               	else
               		return mid+1;
        }
        
        public static int numberOfElementsLesserThanCurrentElementInRow(ArrayList<Integer> row, int element) {
                int lower = 0, upper = row.size()-1;
                int mid = (lower + upper)/2;
                
                while(lower < upper) {
                        if(row.get(mid) >= element)
                                upper = mid - 1;
                        if(row.get(mid) < element)
                                lower = mid + 1;
                        mid = (lower + upper)/2;
                }
                
                if(row.get(mid) >= element)
                	return mid;
               	else
               		return mid+1;
        }
}
