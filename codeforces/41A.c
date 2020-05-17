#include <stdio.h>

int main() {
	int i, max = 0;
	char ar[100], b;
	for(i = 1; i <= 101; i++) {
		if(max == 0) {
			scanf("%c", &ar[i-1]);
			if(ar[i-1] == '\n') {
                        	max = i;
                        	i = 1;
                        	continue;
                	}
		} else {
			scanf("%c", &b);
			if(b != ar[max - i]) {
				printf("NO");
				break;
			}
		}

		if(i == max) {
			printf("YES");
			break;
		}
	}
}
