// Find the length of the string. Let us say the length is n.
// We need to list all possible ways of breaking n into whole numbers.
// Let us say the number is 4. 4 can be broken down in the following ways:
// 4 - [1,1,1,1]
// 4 - [1,1,2]
// 4 - [1,2,1]
// 4 - [1,3]
// 4 - [2,1,1]
// 4 - [2,2]
// 4 - [3,1]
// 4 - [4]

import java.util.*;
import java.io.*;

class PalindromePartioning {
    public static void main(String args[]) throws IOException {
        System.out.println(partition("aab"));
    }

    static ArrayList<ArrayList<String>> final_solutions;
    static ArrayList<String> solution = new ArrayList<String>();
    static String string_to_be_split;
    static int sum_elems = 0;

    public static ArrayList<ArrayList<String>> partition(String a) {
        final_solutions = new ArrayList<ArrayList<String>>();
        string_to_be_split = a;
        breakIt(a.length());
        return final_solutions;
	}
    
    public static void breakIt(int n) {
        int i;
        if(n == 0) {
            ArrayList<String> final_solution = new ArrayList<String>();
            
            for(i = 0; i < solution.size(); i++)
                final_solution.add(solution.get(i));

            final_solutions.add(final_solution);
        }
        
        if(n < 0)
            return;
        
        for(i = 1; i <= n; i++) {
            sum_elems += i;
            String sub_string = string_to_be_split.substring(sum_elems - i, sum_elems);
            if(isPalindrome(sub_string)) {
                solution.add(sub_string);
                breakIt(n-i);
                solution.remove(solution.size()-1);
            }
            sum_elems -= i;
        }
    }
    
    public static boolean isPalindrome(String string_to_check) {
        int i;
        int n = string_to_check.length();
        for(i = 0; i < n/2; i++) {
            if(string_to_check.charAt(i) != string_to_check.charAt(n-i-1))
                return false;
        }
        return true;
    }
}
