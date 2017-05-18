import java.io.*;
import java.util.*;

class LetterPhone {
    public static void main(String args[]) throws IOException {
        System.out.println(letterCombinations("23"));
    }
    
    static ArrayList<String> solution;
    static int level = 0;
    static int final_level;
    static ArrayList<String> strings = new ArrayList(Arrays.asList("0","1","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"));
    
    public static ArrayList<String> letterCombinations(String a) {
        final_level = a.length();
        solution = new ArrayList();
        backtracking(a,"");
        return solution;
    }
    
    public static void backtracking(String a, String new_string) {
        if(level == final_level) {
            solution.add(new_string);
            return;
        }
        
        int i;
        String characters = strings.get(a.charAt(level) - 48);
        
        for(i = 0; i < characters.length(); i++) {
            level++;
            backtracking(a,new_string + characters.charAt(i));
            level--;
        }
    }
}
