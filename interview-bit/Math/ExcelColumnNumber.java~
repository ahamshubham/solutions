import java.util.*;
import java.io.*;

class ExcelColumnNumber {
    public static void main(String args[]) throws IOException {
        System.out.println(titleToNumber("AA"));
    }
    
    public static int titleToNumber(String a) {
        int l = a.length();
        int i = 0;
        int sum = 0;
        for(i = 0; i < l; i++) {
            sum = sum*26 + (a.charAt(i) - 64);
        }
        return sum;
    }
}
