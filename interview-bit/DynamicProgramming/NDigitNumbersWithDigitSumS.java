import java.util.*;
import java.io.*;

class NDigitNumbersWithDigitS {
        public static void main(String args[]) throws IOException {
                System.out.println(solve(1,0));
                System.out.println(solve(3,2));
        }

        static int sum[][];
        static int starting_digit = 1;
        static int count = 0;
        
        public static int solve(int A, int B) {
                sum = new int[A+1][B+1];
                if(A == 0)
                        return 0;
                else {
                        if(A == 1 && B == 0) {
                                return 1;
                        } else if(B == 0) {
                                return 0;
                        } else {
                                for(int i = 0; i <= A; i++)
                                        for(int j = 0; j <= B; j++)
                                                sum[i][j] = -1;
                                getCount(A,B);
                        }
                }
                
                return count;
        }
        
        public static int getCount(int A, int B) {
                int local_count = 0;
                if(sum[A][B] != -1) {
                        count = (count + sum[A][B]) % 1000000007;
                        return sum[A][B];
                } 
                if(A == 0) {
                        //System.out.println(B);
                        if(B == 0) {
                                count = (count + 1) % 1000000007;
                                return 1;
                        } else return 0;
                }
                else {
                        int i;
                        for(i = starting_digit; i < 10; i++) {
                                starting_digit = 0;
                                //System.out.println("Digit, Number of digits left, Sum left:"+ i +","+ B +","+ A);
                                if(B-i >= 0) {
                                        sum[A-1][B-i] = getCount(A-1,B-i);
                                        local_count = (local_count + sum[A-1][B-i]) % 1000000007;
                                }
                                else
                                        break;
                        }
                        
                }
                
                return local_count;
        }
}
