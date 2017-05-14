import java.io.*;
import java.util.*;

class PalindromeInteger {
    public static void main(String args[]) throws IOException {
        System.out.println(isPalindrome(12021));
    }
    
    public static boolean isPalindrome(int a) {
        String s = Integer.toString(a);
        int i = 0;
        int l = s.length();
        
        for(i = 0; i < l/2; i++) {
            if(s.charAt(i) != s.charAt(l-1-i))
                return false;
        }
        return true;
    }
}
