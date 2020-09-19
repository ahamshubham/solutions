// The question is rife with logical inconsistencies
// Petya likes gifts but more than receiving gifts Petya likes watching others giving gifts to somebody else. But, what can be more pleasant than giving somebody gifts?

// Let us denote the transaction of friend i giving the gift j to friend k as (gj, fi -> fk)
// Then, a collection of transactions can be called a gift ceremony
// Let us consider the gift ceremony among three friends f1, f2 and f3, ((g1, f1 -> f2), (g1, f2 -> f3), (g1, f3 -> f1)). This is a valid transaction according to the problem.
// If we do not focus on which gift is being passed along, we can move further.
// All the friends received exactly one gift which means that there is an arrow towards each friend. This arrow must originate somewhere and actually it originates from another or same person.
// Since, one person can give a gift only to one person, it is not possible that a person gives gifts to two or more people. Let us consider the possibility that some person does not give gift to someone else. If this was true, someone will not receive a gift too and that is not possible. So, the only relevant conclusion is that each person gives a gift to one person.

// Maths:
// f(i) = j
// g(j) = i

#include <stdio.h>

int main() {
	int n, i, j;
	scanf("%d", &n);
	int g[100];
	for(i = 0; i < n; i++) {
		scanf("%d", &j);
		g[j-1] = i+1;
	}

	for(i = 0; i < n; i++) {
		printf("%d ", g[i]);
	}
}
