import java.util.*;
import java.io.*;

public class Problem810A {
    public static void main(String args[]) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        
        String n_and_k = buf.readLine();
        int n = Integer.parseInt(n_and_k.split(" ")[0]);
        int k = Integer.parseInt(n_and_k.split(" ")[1]);
        
        String ar[] = buf.readLine().split(" ");
        int i;
        int sum = 0;
        
        for(i = 0; i < ar.length; i++)
            sum = sum + Integer.parseInt(ar[i]);
        
        if((2*k-1)*n-2*sum < 0)
            System.out.println(0);
        else
            System.out.println((2*k-1)*n-2*sum);
    }
}
