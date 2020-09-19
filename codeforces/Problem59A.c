#include <stdio.h>

int main() {
	char ch;
	char Up[100], Down[100];
	short i, l = 0, ct = 0;

	while(1) {
		scanf("%c", &ch);
		if(ch == '\n')
			break;
		if(ch >= 97 && ch <= 122) {
			Down[l] = ch;
			Up[l++] = (char)(ch - 32);
			ct--;
		}
		else {
			Up[l] = ch;
			Down[l++] = (char)(ch + 32);
			ct++;
		}
	}

	if(ct > 0) {
		for(i = 0; i < l; i++)
			printf("%c", Up[i]);
	} else {
		for(i = 0; i < l; i++)
                        printf("%c", Down[i]);
	}
}
