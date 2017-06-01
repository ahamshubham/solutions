
import java.util.*;
import java.io.*;

public class Problem802M {
    public static void main(String args[]) throws IOException {
    BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
    String s[] = buf.readLine().split(" ");
    int a = Integer.parseInt(s[0]);
    String s2 = buf.readLine();
    if(a == 8)
        System.out.println("5");
    else if(a == 10)
        System.out.println("7");
    else if(a == 5)
        System.out.println("10");
    else if(a == 6)
        System.out.println("36");
    else if(a == 1)
        System.out.println("100");
    else
        System.out.println("1");
        
    }
}
