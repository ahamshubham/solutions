import java.util.*;
import java.io.*;

class ZigzagString {
        public static void main(String args[]) throws IOException {
                System.out.println(convert("PAYPALISHIRING",3));
        }
        
        public static String convert(String a, int b) {
                String c = "";
                int length_of_string = a.length();
                for(int i = b-1; i >= 0; i--) {
                        for(int j = b-1; j < length_of_string + b - 1; j = j + (2*b - 1)) {
                                if(j - i < length_of_string) {
                                        System.out.println(j-i);
                                        c += a.charAt(j-i);
                                }
                                
                                if(j + i < length_of_string) {
                                        System.out.println(j+i);
                                        c += a.charAt(j+i);
                                }
                        }
                }
                
                return c;
        }
}
