//f(s) denotes the count of characters from the starting position of string to its middle part which do not lead to symmetry

//Solutions
//Palindromes of odd size
import java.util.*;
import java.io.*;

class Problem798A {
    public static void main(String args[]) throws IOException {
        
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int n = s.length();
        
        int symmetry_score = symmetry_calc(s,n);
        //System.out.println(symmetry_score);
        
        if( (n%2 == 1 && symmetry_score == 0) || symmetry_score == 1)
            System.out.println("YES");
        else
            System.out.println("NO");
    
    }
    
    public static int symmetry_calc(String s, int n) {
        int flag = 0;
        for(int i = 0; i < n/2; i++) {
            if(s.charAt(i) != s.charAt(n-i-1))
                flag++;
        }
        return flag;
    }
}
