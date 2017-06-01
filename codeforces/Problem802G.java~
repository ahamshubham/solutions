import java.util.*;
import java.io.*;

public class Problem802G {
    public static void main(String args[]) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        
        String input_string = buf.readLine();
        char string_to_be_matched[] = {'h','e','i','d','i'};
        int count_matches = 0, i;
        for(i = 0; i < input_string.length(); i++)
            if(string_to_be_matched[count_matches] == input_string.charAt(i)) {
                count_matches++;
                if(count_matches == string_to_be_matched.length)
                    break;
            }
        
        if(count_matches == string_to_be_matched.length)
            System.out.println("YES");
        else
            System.out.println("NO");
    }
}
