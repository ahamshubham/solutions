import java.io.*;

public class POLY {
	public static void main(String args[]) {
		int a = 1000000000;
		System.out.println(a);

		int t1 = 1;
		int t2 = 1;
		
		for(int i = 0; i <= 100; i++) {
			int temp = t1;
			t1 = t1 + t2;
			t2 = temp;
			System.out.println(i + ": " + t2);
		}
	}
}
