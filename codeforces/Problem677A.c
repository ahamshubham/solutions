#include <stdio.h>

int main() {
	int n, h, h2, i, w = 0;
	scanf("%d", &n);
	scanf("%d", &h);

	for(i = 0; i < n; i++) {
		scanf("%d", &h2);
		if(h2 > h)
			w+=2;
		else
			w++;
	}

	printf("%d", w);
}
