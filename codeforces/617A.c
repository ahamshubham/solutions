#include <stdio.h>

int main() {
	long long int x;
	//long long x;
	scanf("%lld", &x);
	//AP2
	printf("%lld", 1 + (x - 1) / 5);
	//AP1
	//printf("%lld", x/5 + (1 - x / 5 + (x - 1) / 5));
}
