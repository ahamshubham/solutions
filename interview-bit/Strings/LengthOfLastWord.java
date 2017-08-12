import java.util.*;
import java.io.*;

class LengthOfLastWord {
        public static void main(String args[]) throws IOException {
                System.out.println(lengthOfLastWord(""));
                System.out.println(lengthOfLastWord("  "));
                System.out.println(lengthOfLastWord("  hello"));
                System.out.println(lengthOfLastWord("hello hell"));
                System.out.println(lengthOfLastWord(" hello hell"));
                System.out.println(lengthOfLastWord(" hello jello mellow"));
        }
        
        public static int lengthOfLastWord(final String a) {
                int i = 0, length_of_previous_word = 0, length_of_current_word = 0, previous_character_alphabet = 0;
                for(i = 0; i < a.length(); i++) {
                        char current_character = a.charAt(i);
                        
                        if(current_character != ' ') {
                                length_of_current_word++;
                                previous_character_alphabet = 1;
                        } else {
                                if(previous_character_alphabet == 1) {
                                        length_of_previous_word = length_of_current_word;
                                }
                                length_of_current_word = 0;
                                previous_character_alphabet = 0;
                        }
                }
                
                if(previous_character_alphabet == 1)
                        length_of_previous_word = length_of_current_word;
                
                return length_of_previous_word;
        } 
}
