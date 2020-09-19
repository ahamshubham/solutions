#include<stdio.h>

int main() {
	char ch1[21];
	char ch2[21];
	int i, n = -1, scoreof1over2 = 0;
	do {
		n++;
		scanf("%c", &ch1[n]);
	} while(ch1[n] != '\n');

	n = n-1;

	for(i = 0; i <= n; i++) {
		scanf("%c", &ch2[i]);

		//printf("%c %c ", ch1[i], ch2[i]);

		if(i % 2 == 0) {
			if((ch1[i] == '8' && ch2[i] == '[') ||
				(ch1[i] == '[' && ch2[i] == '(') ||
				(ch1[i] == '(' && ch2[i] == '8'))
				scoreof1over2++;
			else if((ch2[i] == '8' && ch1[i] == '[') ||
                                (ch2[i] == '[' && ch1[i] == '(') ||
                                (ch2[i] == '(' && ch1[i] == '8'))
				scoreof1over2--;
		}
	}

	if(scoreof1over2 > 0)
		printf("TEAM 1 WINS");
	else if(scoreof1over2 < 0)
		printf("TEAM 2 WINS");
	else
		printf("TIE");
}
