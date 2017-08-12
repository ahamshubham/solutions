import java.util.*;
import java.io.*;

class IntersectingChordsInACircle {
        public static void main(String args[]) throws IOException {
                System.out.println(ChordCnt(1000));
        }
        
        static Long dp[];
        
        public static int ChordCnt(int A) {
                dp = new Long[A+1];
                for(int i = 0; i < A+1; i++)
                        dp[i] = -1L;
                        
                return countNumberOfWays(A).intValue();
        }
        
        public static Long countNumberOfWays(int N) {
                Long numberOfWaysForN = 0L;
                if(N <= 1)
                        return 1L;
                
                if(dp[N] != -1)
                        return dp[N];
                
                for(int i = 0; i < N; i++)
                        numberOfWaysForN = (numberOfWaysForN + (countNumberOfWays(i)*countNumberOfWays(N-i-1))%1000000007)%1000000007;
                        
                dp[N] = numberOfWaysForN;
                
                return numberOfWaysForN;
        }
}
