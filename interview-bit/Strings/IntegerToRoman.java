import java.util.*;
import java.io.*;

class IntegerToRoman {
        public static void main(String args[]) throws IOException {
                //Scanner sc = new Scanner(System.in);
                //System.out.println(intToRoman(sc.nextInt()));
                
                for(int i = 0; i < 3999; i++)
                        System.out.print(intToRoman(i) + ", ");
                
        }
        
        public static String intToRoman(int a) {
                String basic_roman_numerals[] = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
                int basic_roman_numerals_values[] = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
                String roman_numeral_representation = "";
                
                while(a > 0) {
                        for(int i = 0; i < basic_roman_numerals_values.length ; i++) {
                                if(a >= basic_roman_numerals_values[i]) {
                                        a -= basic_roman_numerals_values[i];
                                        roman_numeral_representation += basic_roman_numerals[i];
                                        break;
                                }
                        }
                }
                
                return roman_numeral_representation;
        }
}
