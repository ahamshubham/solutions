#include <stdio.h>

int main() {
	int i, j, T, N;
	scanf("%d", &T);

	for(i = 0; i < T; i++) {
		scanf("%d", &N);
		int edge_info[N][2];
		int count_neighbours[N+1];
		int distance_from_cycle[N+1];
		int neighbours[N+1][3];
		
		for(j = 0; j < N; j++) {
			count_neighbours[j+1] = 0;
			distance_from_cycle[j+1] = -1;
			neighbours[j+1][0] = -1;
			neighbours[j+1][1] = -1;
			neighbours[j+1][2] = -1;
		}

		for(j = 0; j < N; j++) {
			scanf("%d", &edge_info[j][0]);
			scanf("%d", &edge_info[j][1]);
			
			neighbours[edge_info[j][0]][count_neighbours[edge_info[j][0]]] = edge_info[j][1];
			count_neighbours[edge_info[j][0]]++;
			neighbours[edge_info[j][1]][count_neighbours[edge_info[j][1]]] = edge_info[j][0];
			count_neighbours[edge_info[j][1]]++;

			if(count_neighbours[edge_info[j][0]] == 3) {
				//printf(":%d:", edge_info[j][0]);
				distance_from_cycle[edge_info[j][0]] = 0;
			}

			if(count_neighbours[edge_info[j][1]] == 3) {
				//printf(":%d:", edge_info[j][1]);
				distance_from_cycle[edge_info[j][1]] = 0;
			}
		}
		
		/*
		printf("Case #%d:", i + 1);
		for(j = 0; j < N; j++) {
			printf(" %d", distance_from_cycle[j+1]);
		}
		printf("\n");
		*/

		for(j = 0; j < N; j++) {
			if(count_neighbours[edge_info[j][0]] == 1 && distance_from_cycle[edge_info[j][0]] == -1) {
				int node = edge_info[j][0];
				int node_neighbour = neighbours[node][0];				
				while(count_neighbours[node_neighbour] != 3) {
					if(neighbours[node_neighbour][0] == node) {
						node = node_neighbour;
						node_neighbour = neighbours[node_neighbour][1];
					} else {
						node = node_neighbour;
						node_neighbour = neighbours[node_neighbour][0];
					}
				}
				
				int temp_node_value = node;
				node = node_neighbour;
				node_neighbour = temp_node_value;
				int distance_of_node_neighbour_from_cycle = 1;
				distance_from_cycle[node_neighbour] = distance_of_node_neighbour_from_cycle;
				
				while(count_neighbours[node_neighbour] != 1) {
					distance_of_node_neighbour_from_cycle++;
					if(neighbours[node_neighbour][0] == node) {
						node = node_neighbour;
						node_neighbour = neighbours[node_neighbour][1];
					} else {
						node = node_neighbour;
						node_neighbour = neighbours[node_neighbour][0];
					}
					distance_from_cycle[node_neighbour] = distance_of_node_neighbour_from_cycle;
				}
			}
								
			if(count_neighbours[edge_info[j][1]] == 1 && distance_from_cycle[edge_info[j][1]] == -1) {
				int node = edge_info[j][1];
				int node_neighbour = neighbours[node][0];				
				while(count_neighbours[node_neighbour] != 3) {
					if(neighbours[node_neighbour][0] == node) {
						node = node_neighbour;
						node_neighbour = neighbours[node_neighbour][1];
					} else {
						node = node_neighbour;
						node_neighbour = neighbours[node_neighbour][0];
					}
				}
				
				int temp_node_value = node;
				node = node_neighbour;
				node_neighbour = temp_node_value;
				int distance_of_node_neighbour_from_cycle = 1;
				distance_from_cycle[node_neighbour] = distance_of_node_neighbour_from_cycle;
				
				while(count_neighbours[node_neighbour] != 1) {
					distance_of_node_neighbour_from_cycle++;
					if(neighbours[node_neighbour][0] == node) {
						node = node_neighbour;
						node_neighbour = neighbours[node_neighbour][1];
					} else {
						node = node_neighbour;
						node_neighbour = neighbours[node_neighbour][0];
					}
					distance_from_cycle[node_neighbour] = distance_of_node_neighbour_from_cycle;
				}
			}	
		}

		for(j = 0; j < N; j++) {
			if(distance_from_cycle[edge_info[j][0]] == -1) {
				distance_from_cycle[edge_info[j][0]] = 0;
			}

			if(distance_from_cycle[edge_info[j][1]] == -1) {
				distance_from_cycle[edge_info[j][1]] = 0;
			}
		}

		printf("Case #%d:", i + 1);
		for(j = 0; j < N; j++) {
			printf(" %d", distance_from_cycle[j+1]);
		}
		printf("\n");
	}
}
