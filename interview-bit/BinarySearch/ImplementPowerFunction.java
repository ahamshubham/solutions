import java.util.*;
import java.io.*;
import java.math.*;

class ImplementPowerFunction {
        public static void main(String args[]) throws IOException {
                System.out.println(pow(71045970, 41535484, 64735492));
                System.out.println(pow(10000, 10000, 9999));
        }
        
        /*
        public static int pow(int x, int n, int d) {
                x = x % d;
                
                BigInteger x_big = BigInteger.valueOf(x);
                BigInteger n_big = BigInteger.valueOf(n);
                BigInteger d_big = BigInteger.valueOf(d);
                
                int prod = calcPower(x_big,n_big,d_big).intValue();
                
                if(prod % d < 0) 
                        return d + prod % d;
                else
                        return prod % d;
        }
        
        public static BigInteger calcPower(BigInteger x, BigInteger n, BigInteger d) {
                //System.out.println(x + "," + n + "," + d);
                if(n.intValue() == 0)
                        return BigInteger.valueOf(1).mod(d);
                
                if(n.mod(BigInteger.valueOf(2)).intValue() == 0) {
                        BigInteger power = calcPower(x, n.divide(BigInteger.valueOf(2)), d);
                        return (power.multiply(power)).mod(d);
                }
                else {
                        BigInteger power = calcPower(x, n.subtract(BigInteger.valueOf(1)).divide(BigInteger.valueOf(2)), d);
                        return (((power.multiply(power)).mod(d)).multiply(x)).mod(d);
                }
        }
        */
        
        public static int pow(int x, int n, int d) {
                x = x % d;
                
                int prod = calcPower(new Long(x),new Long(n),new Long(d)).intValue();
                
                if(prod % d < 0)
                        return d + prod % d;
                else
                        return prod % d;
        }
        
        public static Long calcPower(Long x, Long n, Long d) {
                //System.out.println(x + "," + n + "," + d);
                if(n == 0)
                        return 1L % d;
                
                if(n % 2L == 0) {
                        Long power = calcPower(x, n/2, d);
                        return (power * power) % d;
                }
                else {
                        Long power = calcPower(x, (n-1)/2, d);
                        return (((power * power) % d)* x) % d;
                }
        }
        
}
