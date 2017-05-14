import java.io.*;
import java.lang.*;
import java.util.*;

public class PrimeSum {
    public static void main(String args[]) throws IOException {
        int i;
        for(i=0;i<10000;i++)
            System.out.println(primeSum(i));
    }
    
    public static ArrayList<Integer> primeSum(int a) {
        int i = 2;
        for(;i <= a/2;i++) {
            if(isPrime(i) == 1)
                if(isPrime(a-i) == 1)
                    return new ArrayList<Integer>(Arrays.asList(i,a-i));
        }
        
        return new ArrayList<Integer>();
    }
    
    public static int isPrime(int n) {
        if(n == 1)
            return 0;
        
        int is_prime = 1;
        int i = 2;
        for(;i <= Math.sqrt(n); i++) {
            if(n % i == 0) {
                is_prime = 0;
                break;
            }
        }
        
        return is_prime;
    }
}
