#include <stdio.h>

int main() {
	char ch;
	int i;
	scanf("%d", &i);
	scanf("%c", &ch);
	i = 0;

	while(1) {
		scanf("%c", &ch);
		if(ch == '\n')
			break;
		if(ch == 'A')
			i++;
		else
			i--;
	}

	if(i == 0)
		printf("Friendship");
	else if(i < 0)
		printf("Danik");
	else
		printf("Anton");
}
