#include<stdio.h>
#include<malloc.h>

struct neighbour_list_node {
	int neighbour_index;
	struct neighbour_list_node* next_neighbour;
};

struct graph_node {
	int node_index;
	struct neighbour_list_node* neighbours;
};

int node_can_be_colored(int current_node_index, struct graph_node* current_node, int color_of_nodes[]) {
	int can_be_colored = 1;
	
	if(current_node != NULL) {
		struct neighbour_list_node* current_neighbour_in_the_list = current_node -> neighbours;
		while(current_neighbour_in_the_list != NULL) {
			if(color_of_nodes[current_neighbour_in_the_list -> neighbour_index] == 1)
				can_be_colored = 0;
			current_neighbour_in_the_list = current_neighbour_in_the_list -> next_neighbour;
		}
	}
	
	color_of_nodes[current_node_index] = can_be_colored;
	
	return can_be_colored;
}

int main() {

	int i, j, n, m, a, b;
	
	FILE *fo, *fo2;

	fo = fopen("b1.in", "r");
	fo2 = fopen("b1_out.txt", "w");
	
	fscanf(fo, "%d", &n);
	fscanf(fo, "%d", &m);
	
	//Initialization of the graph 
	struct graph_node* graph[n+1];
	struct graph_node* universe = (struct graph_node*)malloc(sizeof(struct graph_node));
	graph[0] = universe;
	graph[0] -> node_index = 0;
	struct neighbour_list_node* new_neighbour_list_node = (struct neighbour_list_node*)malloc(sizeof(struct neighbour_list_node));
	graph[0] -> neighbours = new_neighbour_list_node;
	graph[0] -> neighbours -> neighbour_index = -1;
	graph[0] -> neighbours -> next_neighbour = NULL;

	//A few variable declarations
	struct graph_node* new_node;
	struct neighbour_list_node* current_neighbour_in_the_list;

	for(i = 1; i <= n; i++)
		graph[i] = NULL;
	

	/*
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
	*/

	for(i = 0; i < m; i++) {
		fscanf(fo, "%d", &a);
		fscanf(fo, "%d", &b);
		//printf("%d, %d: ", a, b);
		if(graph[a] == NULL) {
			new_node = (struct graph_node*)malloc(sizeof(struct graph_node));
			graph[a] = new_node;
			graph[a] -> node_index = a;
			new_neighbour_list_node = (struct neighbour_list_node*)malloc(sizeof(struct neighbour_list_node));
			graph[a] -> neighbours = new_neighbour_list_node;
			graph[a] -> neighbours -> neighbour_index = b;
			graph[a] -> neighbours -> next_neighbour = NULL;
			//printf("<%d> ", graph[a] -> neighbours -> neighbour_index);

			if(i == 0) {
				graph[0] -> neighbours -> neighbour_index = a;
			}
		} else {
			current_neighbour_in_the_list = graph[a] -> neighbours;
		
			while(current_neighbour_in_the_list != NULL) {
				//printf("<%d> ", current_neighbour_in_the_list-> neighbour_index);
				if(current_neighbour_in_the_list-> next_neighbour == NULL) {
					new_neighbour_list_node = (struct neighbour_list_node*)malloc(sizeof(struct neighbour_list_node));
					current_neighbour_in_the_list-> next_neighbour = new_neighbour_list_node;
					current_neighbour_in_the_list-> next_neighbour -> neighbour_index = b;
					current_neighbour_in_the_list-> next_neighbour -> next_neighbour = NULL;
					//printf("<%d> ", current_neighbour_in_the_list-> next_neighbour -> neighbour_index);
					break;
				}

				current_neighbour_in_the_list = current_neighbour_in_the_list -> next_neighbour;
			}
		}

		if(graph[b] == NULL) {
			new_node = (struct graph_node*)malloc(sizeof(struct graph_node));
			graph[b] = new_node;
			graph[b] -> node_index = b;
			new_neighbour_list_node = (struct neighbour_list_node*)malloc(sizeof(struct neighbour_list_node));
			graph[b] -> neighbours = new_neighbour_list_node;
			graph[b] -> neighbours -> neighbour_index = a;
			graph[b] -> neighbours -> next_neighbour = NULL;
			//printf("<%d> ", graph[b] -> neighbours -> neighbour_index);

		} else {
			current_neighbour_in_the_list = graph[b] -> neighbours;
			
			while(current_neighbour_in_the_list != NULL) {
				//printf("<%d> ", current_neighbour_in_the_list-> neighbour_index);				
				if(current_neighbour_in_the_list-> next_neighbour == NULL) {
					new_neighbour_list_node = (struct neighbour_list_node*)malloc(sizeof(struct neighbour_list_node));
					current_neighbour_in_the_list-> next_neighbour = new_neighbour_list_node;
					current_neighbour_in_the_list-> next_neighbour -> neighbour_index = a;
					current_neighbour_in_the_list-> next_neighbour -> next_neighbour = NULL;
					//printf("<%d> ", current_neighbour_in_the_list-> next_neighbour -> neighbour_index);
					break;
				}
				
				current_neighbour_in_the_list = current_neighbour_in_the_list -> next_neighbour;
			}
		}
		//printf("\n");
	}

	for(i = 0; i <= n; i++) {
		printf("%d: ", i);
		if(graph[i] != NULL) {
			current_neighbour_in_the_list = graph[i] -> neighbours;
			while(current_neighbour_in_the_list != NULL) {
				printf("%d, ", current_neighbour_in_the_list -> neighbour_index);
				current_neighbour_in_the_list = current_neighbour_in_the_list -> next_neighbour;
			}
		}
		printf("\n");
	}

	fclose(fo);

	int attempts = 100;
	int color_of_nodes[attempts][n+1];
	int total_nodes_colored[attempts];
	int optimal_attempt;
	int num_of_nodes_in_optimal_attempt = 0;
	
	for(j = 0; j < attempts; j++) {
		total_nodes_colored[j] = 0;
		for(i = 0; i <= n; i++)
			color_of_nodes[j][i] = 0;
	}
	
	for(j = 0; j < attempts; j++) {
		for(i = 1; i <= n; i++) {
			int si = (i + j - 1) % n + 1;
			int can_be_colored = node_can_be_colored(si, graph[si], color_of_nodes[j]);
			total_nodes_colored[j] = total_nodes_colored[j] + can_be_colored;
		}
		if(total_nodes_colored[j] > num_of_nodes_in_optimal_attempt) {
			optimal_attempt = j;
			num_of_nodes_in_optimal_attempt = total_nodes_colored[j];
		}
		printf("%d ", total_nodes_colored[j]);
	}
	
		

	fprintf(fo2, "%d\n", total_nodes_colored[optimal_attempt]);
	for(i = 1; i <= n; i++) {
		fprintf(fo2, "%d ", color_of_nodes[optimal_attempt][i]);
	}

	fclose(fo2);
}
