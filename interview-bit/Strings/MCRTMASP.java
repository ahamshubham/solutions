import java.util.*;
import java.io.*;

class MCRTMASP {
	public static void main(String args[]) throws IOException {
		System.out.println(solve("ABC"));
		System.out.println(solve("AACECAAAA"));
		System.out.println(solve("ABCBA"));
		System.out.println(solve("babb"));
	}

	public static int solve(String A) {
		int n = A.length(), i;
		if(n == 0)
			return 0;		
		String left_substring = A.substring(0,n/2);
		String right_substring = "";
		for(i = n-1; i >= n/2; i--)
			right_substring = right_substring + A.charAt(i);

		for(i = n-1; i >= 0; i--) {
			//System.out.println(left_substring + " " + right_substring);	
			if(i == 0) {
				return n-1;
			}		

			if(i % 2 == 0) {
				if(left_substring.equals(right_substring.substring(0,i/2)))
					return n - i - 1;
				right_substring = right_substring.substring(1);
			}
			else {
				if(left_substring.equals(right_substring))
					return n - i - 1;
				right_substring = right_substring.substring(1) + left_substring.charAt(i/2);
				left_substring = left_substring.substring(0,i/2);
			}			
		}
		return -1;
	}
}
