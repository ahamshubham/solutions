import java.util.*;
import java.io.*;

class PalindromeString {
	public static void main(String args[]) throws IOException {
		System.out.println(isPalindrome("abcba"));
		System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
		System.out.println(isPalindrome("race a car"));
	}
	
	public static int isPalindrome(String a) {
		a = a.toLowerCase();
		int n = a.length();		
		int i = 0, j = n - 1;
		int is_palindrome = 1;		
		while(i <= j) {
			char c1 = a.charAt(i);
			char c2 = a.charAt(j);
			if(!( ((int)c1 >= 65 && (int)c1 <= 90) || ((int)c1 >= 97 && (int)c1 <= 122) || ((int)c1 >= 48 && (int)c1 <= 57) )) {
				i++;
				continue;
			}

			if(!( ((int)c2 >= 65 && (int)c2 <= 90) || ((int)c2 >= 97 && (int)c2 <= 122) || ((int)c2 >= 48 && (int)c2 <= 57) )) {
				j--;
				continue;
			}
			
			if(c1 == c2) {
				i++;
				j--;
			}
			else {
				is_palindrome = 0;
				break;
			}
		}
		return is_palindrome;
	}
}
