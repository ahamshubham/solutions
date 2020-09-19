#include<stdio.h>

int main() {
	int i;
	int n;
	
	FILE *fp, *fp2;

	fp = fopen("sort.in", "r");
	fp2 = fopen("sort.txt", "w+");
	
	fscanf(fp, "%d", &n);
	
	int curr_value, total_values = 0;
	bool value_presence[1000000];
	int value_count[1000000];
	
	for(i = 0; i < 1000000; i++) {
		value_presence[i] = 0;
		value_count[i] = 0;
	}
	
	for(i = 0; i < n; i++) {
		fscanf(fp, "%d", &curr_value);	
		value_presence[curr_value] = 1;
		value_count[curr_value]++;
	}

	for(i = 0; i < 1000000; i++) {
		while(value_count[i] > 0) {
			total_values++;
			fprintf(fp2, "%d ", i);
			value_count[i]--;
		}
	}

	fprintf(fp2, "\n");
	printf("%d %d", n, total_values);

	fclose(fp);
	fclose(fp2);
}
