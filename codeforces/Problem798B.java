//Duplicate each string to create strings with characters repeated twice in them.
//Place each string in the other strings and get the position
import java.io.*;
import java.util.*;

public class Problem798B {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int i,n = sc.nextInt();
        String ar[] = new String[n];
        String duplicatedar[] = new String[n];
        
        for(i=0;i<n;i++) {
            ar[i] = sc.next();
            duplicatedar[i] = ar[i] + ar[i];
            //System.out.println(duplicatedar[i]);
        }
        
        int flag = 0;
        int first = 1;
        int moves = -1;
        int l = ar[0].length();
        for(i=0;i<n;i++) {
            
            int tmp_moves = 0;
            
            for(int j = 0; j < n; j++) {
                
                int found = 0;
                
                if(ar[i].length() != ar[j].length()) {
                    break;    
                }
                
                flag = 0;
                
                for(int k = 0; k < l ; k++) {
                    //System.out.println(duplicatedar[j].substring(k,k+l));
                    //System.out.println(ar[i]);
                    //System.out.println(duplicatedar[j].substring(k,k+l).equals(ar[i]));
                    if((duplicatedar[j].substring(k,k+l)).equals(ar[i])){
                        flag = 1;
                        tmp_moves = tmp_moves + k;
                        break;
                    }
                }
            }
            
            //System.out.println(tmp_moves);
            
            //If the string chosen does not appear anywhere in the duplicated array, break and display -1
            if(flag == 0)
                break;
            
            if(first == 1 || tmp_moves < moves)
                moves = tmp_moves;
                
            first = 0;
        }
        
        if(flag == 0)
            System.out.println("-1");
        else
            System.out.println(moves);
    }
}
