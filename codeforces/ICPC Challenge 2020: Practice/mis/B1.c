#include <stdio.h>

int main() {
	
	int i, j, n, m, a, b;	
	FILE *fo, *fo2;

	fo = fopen("b4.in", "r");
	fo2 = fopen("b4_out.txt", "w");
	
	fscanf(fo, "%d", &n);
	fscanf(fo, "%d", &m);

	//n = 500;
	//m = 100;
	
	//bool edge[n+1][n+1];
	//int sum_of_all_edges[n+1];	

	/*
	for(i = 0; i <= n; i++) {
		sum_of_all_edges[i] = 0;
		for(j = 0; j <= n; j++) {
			edge[i][j] = 0;
		}
	}
	
	for(i = 0; i < m; i++) {
		fscanf(fo, "%d", &a);
		fscanf(fo, "%d", &b);
		
		edge[a][b] = 1;
	}
	
	for(i = 0; i <= n; i++) {
		if(sum_of_all_edges[i] == 0)
			printf("%d\n", i);
	}
	*/

	int sum_of_all_edges_with_a_particular_node[n+1], count_of_all_individual_nodes = 0;

	for(i = 0; i <= n; i++) {
		sum_of_all_edges_with_a_particular_node[i] = 0;
	}

	for(i = 0; i < m; i++) {
		fscanf(fo, "%d", &a);
		fscanf(fo, "%d", &b);
		
		sum_of_all_edges_with_a_particular_node[a]++;
		sum_of_all_edges_with_a_particular_node[b]++;
	}

	for(i = 1; i <= n; i++) {
		if(sum_of_all_edges_with_a_particular_node[i] == 0)
			count_of_all_individual_nodes++;
	}
	
	fprintf(fo2, "%d\n", count_of_all_individual_nodes);

	for(i = 1; i <= n; i++) {
		if(sum_of_all_edges_with_a_particular_node[i] == 0)
			fprintf(fo2, "1 ");
		else
			fprintf(fo2, "0 ");
	}
	
	fprintf(fo2, "\n");

	fclose(fo);
	fclose(fo2);
}
