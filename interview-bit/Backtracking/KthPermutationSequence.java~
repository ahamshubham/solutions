import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class KthPermutationSequence {
    
    public static void main(String args[]) throws IOException {
        int i;
        for(i = 4; i < 40; i++)
            System.out.println(getPermutation(i,1));
    }
    
	public static String getPermutation(int n, int k) {
		ArrayList<Integer> used_elems = new ArrayList();
		ArrayList<Integer> solution = new ArrayList();		
		String sol = "";		
		int i, j, count_unused_elems, skip_elems;
		BigInteger fact;	
		k--;

		for(i = 0; i < n; i++)
			used_elems.add(0);
	
		for(i = 0; i < n; i++) {
			fact = factorial(n-i-1);
			skip_elems = ((BigInteger.valueOf(k)).divide(fact)).intValue();
			k = ((BigInteger.valueOf(k)).remainder(fact)).intValue();
			
			count_unused_elems = 0;
			j = -1;
			while(count_unused_elems < skip_elems+1) {
				j++;				
				if(used_elems.get(j) == 0)
					count_unused_elems ++;
			}
			
			used_elems.set(j,1);
			solution.add(j+1);
		}

		for(i = 0; i < n; i++)
			sol += solution.get(i);
		
		return sol;
	}
	
	public static BigInteger factorial(int n) {
		
		int i;
		BigInteger fact = new BigInteger("1");
		for(i = 1; i <= n; i++)
			fact = fact.multiply(BigInteger.valueOf(i));
		
		return fact;
	}


}

