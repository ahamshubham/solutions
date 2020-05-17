#include <stdio.h>

int main() {
	long long int a, b;
	scanf("%lld %lld", &a, &b);
	int i = 1;
	while(i) {
		if(3 * a > 2 * b) {
			break;
		}
		else {
			a = 3*a;
			b = 2*b;
			i++;
		}
	}

	printf("%d", i);
	
}
