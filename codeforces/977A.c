#include <stdio.h>

int main() {
	long long a;
	int k;
	
	scanf("%lld %d", &a, &k);
	
	while(1) {
		if(a%10 >= k) {
			printf("%lld", a - k);
			break;
		} else {
			k = k - a % 10 - 1;
			a = a / 10;
		}
	}
}
