import java.util.Scanner;

public class Problem344A {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(), i;
		int prev = 0, curr;
		int groups = 0;
		for(i = 0; i < n; i++) {
			curr = sc.nextInt();
			if(prev != curr)
				groups++;
			prev = curr;
		}

		System.out.println(groups);
	}
}
