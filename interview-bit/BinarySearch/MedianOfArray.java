import java.util.*;
import java.io.*;

// position of first middle element = (size of array - 1) / 2
// position of element chosen in the first list + position of element chosen in the second list + 2 = position of first median + 1

//If any of the two arrays is empty return the median of the other array

class MedianOfArray {
        public static void main(String args[]) throws IOException {
                System.out.println("First test case");                
                System.out.println(findMedianSortedArrays(new ArrayList<Integer>(Arrays.asList(-50,-41,-40, -19, 5, 21, 28)),
                new ArrayList<Integer>(Arrays.asList(-50,-21,10))));
                
                System.out.println("Second test case");
                System.out.println(findMedianSortedArrays(new ArrayList<Integer>(Arrays.asList(-43, -25, -18, -15, -10, 9, 39, 40)),
                new ArrayList<Integer>(Arrays.asList(-2))));
        }
        
        public static double findMedianSortedArrays(final List<Integer> a, final List<Integer> b) {
                int size_of_a = a.size();
                int size_of_b = b.size();
                
                if(size_of_a == 0 && size_of_b == 0)
                        return -1;
                        
                if(size_of_a == 0)
                        return size_of_b % 2 == 0? (b.get(size_of_b/2) + b.get(size_of_b/2 -1)) / 2.0: b.get(size_of_b/2);
                
                if(size_of_b == 0)
                        return size_of_a % 2 == 0? (a.get(size_of_a/2) + a.get(size_of_a/2 -1)) / 2.0: a.get(size_of_a/2);
                
                int position_of_first_middle_element = (size_of_a + size_of_b - 1) / 2;
                if(size_of_a > size_of_b) {
                        int lower = -1, upper = size_of_a - 1;
                        int first_chosen, second_chosen;
                        while(lower <= upper) {
                                first_chosen = (lower + upper) / 2;
                                second_chosen = position_of_first_middle_element - 1 - first_chosen;
                                int ul = Integer.MIN_VALUE, ll = Integer.MIN_VALUE, ur = Integer.MAX_VALUE, lr = Integer.MAX_VALUE;
                                if(first_chosen >= 0 && first_chosen < size_of_a)
                                        ul = a.get(first_chosen);
                                if(first_chosen + 1 >= 0 && first_chosen + 1 < size_of_a)
                                        ur = a.get(first_chosen + 1);
                                if(second_chosen >= 0 && second_chosen < size_of_b)
                                        ll = b.get(second_chosen);
                                if(second_chosen+1 >= 0 && second_chosen+1 < size_of_b)                                
                                        lr = b.get(second_chosen + 1);
                                
                                System.out.println(ul+ "," + ur + "," + ll + "," + lr);
                                
                                if(second_chosen >= size_of_b) {
                                        lower = first_chosen + 1;
                                        continue;
                                }
                                
                                if(second_chosen < -1) {
                                        upper = first_chosen -1;
                                        continue;
                                }
                                
                                if(ul <= lr && ll <= ur) {
                                        if((size_of_a + size_of_b) % 2 == 0)
                                                return (minimum(ur,lr) + maximum(ll, ul))/2.0;
                                        else
                                                return maximum(ll, ul);
                                }
                                
                                else if(ul > lr)
                                        upper = first_chosen - 1;
                                else
                                        lower = first_chosen + 1;
                       }
                } else {
                        int lower = -1, upper = size_of_b - 1;
                        int first_chosen, second_chosen;
                        while(lower <= upper) {
                                first_chosen = (lower + upper) / 2;
                                second_chosen = position_of_first_middle_element - 1 - first_chosen;
                                int ul = Integer.MIN_VALUE, ll = Integer.MIN_VALUE, ur = Integer.MAX_VALUE, lr = Integer.MAX_VALUE;
                                if(first_chosen >= 0 && first_chosen < size_of_b)
                                        ul = b.get(first_chosen);
                                if(first_chosen + 1 >= 0 && first_chosen + 1 < size_of_b)
                                        ur = b.get(first_chosen + 1);
                                if(second_chosen >= 0 && second_chosen < size_of_a)
                                        ll = a.get(second_chosen);
                                if(second_chosen+1 >= 0 && second_chosen+1 < size_of_a)                                
                                        lr = a.get(second_chosen + 1);
                                
                                
                                if(second_chosen >= size_of_a) {
                                        lower = first_chosen + 1;
                                        continue;
                                }
                                
                                if(second_chosen < -1) {
                                        upper = first_chosen - 1;
                                        continue;
                                }
                                
                                System.out.println(ul+ "," + ur + "," + ll + "," + lr);
                                
                                if(ul <= lr && ll <= ur) {
                                        if((size_of_a + size_of_b) % 2 == 0)
                                                return (minimum(ur,lr) + maximum(ll, ul))/2.0;
                                        else
                                                return maximum(ll, ul);
                                }
                                else if(ul > lr)
                                        upper = first_chosen - 1;
                                else
                                        lower = first_chosen + 1;
                        }
                }
                
                return -1;
        }
        
        public static int maximum(int a, int b) {
                if(a > b)
                        return a;
                else
                        return b;
        }
        
        public static int minimum(int a, int b) {
                if(a < b)
                        return a;
                else
                        return b;
        }
}
