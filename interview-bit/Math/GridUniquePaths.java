import java.util.*;
import java.io.*;
import java.math.BigInteger;

class GridUniquePaths {
    public static void main(String args[]) throws IOException {
        int i;
        for(i = 0; i < 100; i++) {
            System.out.println(i + " : " + uniquePaths(i,i));
        }
    }
    
    public static int uniquePaths(int a, int b) {
        int i = 0;
        BigInteger num = new BigInteger("1");
        BigInteger den = new BigInteger("1");
        for(i = 0; i < b-1; i++) {
            num = num.multiply(BigInteger.valueOf(a+i));
            den = den.multiply(BigInteger.valueOf(i+1));
        }
        
        return (num.divide(den)).intValue();
    }
}
