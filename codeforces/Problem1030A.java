import java.util.Scanner;

public class Problem1030A {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(), i;

		for(i = 0; i < n; i++)
			if(sc.nextInt() == 1) {
				System.out.println("HARD");
				return;
			}

		System.out.println("EASY");
	}
}
