#include <stdio.h>

//Maths:
//Non-decreasing subsegment means that a(i+1) >= a(i) for
//all the consecutive elements a(i) and a(i+1) inside the subsegment

//Approach to find the non-decreasing subsequence
//In the sequence, until, a(i+1) < a(i), add the element a(i) to a list
//and increment i. When the condition fails, you find a non-decreasing
//subsequence. Reset the list to an empty list

//But since we just need to find the maximum length among the lengths of
//all the non-decreasing subsequences in the sequence, we can have a variable
//which increments with the same approach as given above to find the length
//of the non-decreasing subsequences among the sequence. We need to find the
//maximum among these lengths

//Approach2
//Run code with the condition: For the last element, put a(i+1) = Inf

//Approach1
//Run code without this condition

int main() {
	int i, n, l = 0, l_max = 0;
	scanf("%d", &n);

	int ar, prev = 0;

	for(i = 0; i < n; i++) {
		scanf("%d", &ar);
		if(ar >= prev) {
			l++;
		} else {
			if(l > l_max)
				l_max = l;
			l = 1;
		}

		prev = ar;
	}

	//Approach2
	if(l > l_max)
	 l_max = l;

	printf("%d", l_max);

}
