#include <stdio.h>
#include "malloc.h"
#define N_max 100000
#define segment_length_max 45

int N, Q;
long long original_array[N_max];

struct segment {
	int number_of_elements_stored;
	long long elements_required_and_their_indices[segment_length_max][2];	
	int left, right;
	struct segment* left_child;
	struct segment* right_child;
};

int merge(long long first_array[][2], int number_of_elements_stored_in_first_array, long long second_array[][2], int number_of_elements_stored_in_second_array, long long merged_array[][2]) {	
	int c1 = 0, c2 = 0;
	int c = 0;

	while(c < segment_length_max && c < number_of_elements_stored_in_first_array + number_of_elements_stored_in_second_array) {	
		if(c1 >= number_of_elements_stored_in_first_array) {
			merged_array[c][0] = second_array[c2][0];
			merged_array[c][1] = second_array[c2][1];
			c2++;
		} else if(c2 >= number_of_elements_stored_in_second_array) {
			merged_array[c][0] = first_array[c1][0];
			merged_array[c][1] = first_array[c1][1];
			c1++;
		} else if(second_array[c2][0] > first_array[c1][0]) {
			merged_array[c][0] = second_array[c2][0];
			merged_array[c][1] = second_array[c2][1];
			c2++;
		} else {
			merged_array[c][0] = first_array[c1][0];
			merged_array[c][1] = first_array[c1][1];
			c1++;
		}
		c++;
	}

	return c;
}

void fill_node(int start, int end, struct segment* parent) {
	parent -> left = start;
	parent -> right = end;
	
	int i;	

	if(start == end) {
		parent -> number_of_elements_stored = 1;
		parent -> elements_required_and_their_indices[0][0] = original_array[start];
		parent -> elements_required_and_their_indices[0][1] = start;
		parent -> left_child = NULL;
		parent -> right_child = NULL;
		return;
	}
	
	int mid = (start + end)/2;
	parent -> left_child = (struct segment*) malloc(sizeof(struct segment));
	parent -> right_child = (struct segment*) malloc(sizeof(struct segment));
	fill_node(start, mid, parent -> left_child);
	fill_node(mid + 1, end, parent -> right_child);

	parent -> number_of_elements_stored = merge(parent -> left_child -> elements_required_and_their_indices, parent -> left_child -> number_of_elements_stored,
		parent -> right_child -> elements_required_and_their_indices, parent -> right_child -> number_of_elements_stored, parent -> elements_required_and_their_indices);
	
	return;
}

int get_sorted_array_in_range(int left_limit_of_range, int right_limit_of_range, struct segment* parent, long long sorted_array_in_range[][2]) {
	int i;	
	if(left_limit_of_range <= (parent -> left) && right_limit_of_range >= (parent -> right)) {
		for(i = 0; i < parent -> number_of_elements_stored; i++) {
			sorted_array_in_range[i][0] = parent -> elements_required_and_their_indices[i][0];
			sorted_array_in_range[i][1] = parent -> elements_required_and_their_indices[i][1];
		}
		return parent -> number_of_elements_stored;
	}
	
	long long left_array[segment_length_max][2];
	int left_array_len = 0;
	if(!(left_limit_of_range > (parent -> left_child -> right) || right_limit_of_range < (parent -> left_child -> left))) {
		left_array_len = get_sorted_array_in_range(left_limit_of_range, right_limit_of_range, parent -> left_child, left_array);
	}
		
	long long right_array[segment_length_max][2];
	int right_array_len = 0;
	if(!(left_limit_of_range > (parent -> right_child -> right) || right_limit_of_range < (parent -> right_child -> left))) {
		right_array_len = get_sorted_array_in_range(left_limit_of_range, right_limit_of_range, parent -> right_child, right_array);
	}
	
	if(left_array_len == 0) {
		for(i = 0; i < right_array_len; i++) {
			sorted_array_in_range[i][0] = right_array[i][0];
			sorted_array_in_range[i][1] = right_array[i][1];
		}
		return right_array_len;
	}
	
	if(right_array_len == 0) {
		for(i = 0; i < left_array_len; i++) {
			sorted_array_in_range[i][0] = left_array[i][0];
			sorted_array_in_range[i][1] = left_array[i][1];
		}
		return left_array_len;
	}
	
	int size_of_sorted_array_in_range = merge(left_array, left_array_len, right_array, right_array_len, sorted_array_in_range);	

	return size_of_sorted_array_in_range;
}

long long getMaximumPerimeter(int left_limit_of_range, int right_limit_of_range, struct segment* root_node) {
	long long sorted_array_in_range[segment_length_max][2];
	int size_of_sorted_array_in_range = get_sorted_array_in_range(left_limit_of_range, right_limit_of_range, root_node, sorted_array_in_range);
	int i;
	
	/*
	for(i = 0; i < size_of_sorted_array_in_range; i++) {
		printf("%lld %lld ", sorted_array_in_range[i][0], sorted_array_in_range[i][1]);
	}
	printf("\n");
	*/

	for(i = 0; i < size_of_sorted_array_in_range - 2; i++) {
		if(sorted_array_in_range[i][0] < sorted_array_in_range[i + 1][0] + sorted_array_in_range[i + 2][0])
			return sorted_array_in_range[i][0] + sorted_array_in_range[i + 1][0] + sorted_array_in_range[i + 2][0];
	}
	
	return 0;
}

	

void update_element(long long index_updated, int element, struct segment* parent) {
	int index_of_searched_element = segment_length_max;
	int i;		
	for(i = 0; i < parent -> number_of_elements_stored; i++) {
		if(parent -> elements_required_and_their_indices[i][1] == index_updated) {
			index_of_searched_element = i;
			break;
		}
	}
	
	long long temp[1][2];
	temp[0][0] = element;
	temp[0][1] = index_updated;

	if(index_of_searched_element != segment_length_max) {
		for(i = index_of_searched_element;i < parent -> number_of_elements_stored - 1; i++) {
			parent -> elements_required_and_their_indices[i][0] = parent -> elements_required_and_their_indices[i+1][0];
			parent -> elements_required_and_their_indices[i][1] = parent -> elements_required_and_their_indices[i+1][1];
		}
		parent -> number_of_elements_stored -= 1;
	}
	
	long long temp_array[segment_length_max][2];
	parent -> number_of_elements_stored = merge(temp, 1, parent -> elements_required_and_their_indices, parent -> number_of_elements_stored, temp_array);
	for(i = 0; i < parent -> number_of_elements_stored; i++) {
		parent -> elements_required_and_their_indices[i][0] = temp_array[i][0];
		parent -> elements_required_and_their_indices[i][1] = temp_array[i][1];
	}
	
	if(parent -> left_child != NULL) {
		if(index_updated <= parent -> left_child -> right && index_updated >= parent -> left_child -> left)
			update_element(index_updated, element, parent -> left_child);
	}

	if(parent -> right_child != NULL) {
		if(index_updated <= parent -> right_child -> right && index_updated >= parent -> right_child -> left)
			update_element(index_updated, element, parent -> right_child);
	}
}

int main() {
	scanf("%d", &N);
	scanf("%d", &Q);
	int i, q_type;
	int l, r;
	long long pos, val;

	for(i = 0; i < N; i++) {
		scanf("%lld", &original_array[i]);
	}

	struct segment* root_node = (struct segment*) malloc(sizeof(struct segment));
	fill_node(0, N-1, root_node);

	for(i = 0; i < Q; i++) {
		scanf("%d", &q_type);
		if(q_type == 2) {
			scanf("%d", &l);
			scanf("%d", &r);
			printf("%lld\n", getMaximumPerimeter(l - 1, r - 1, root_node));
		} else {
			scanf("%lld", &pos);
			scanf("%lld", &val);
			update_element(pos - 1, val, root_node);
		}
	}

	return 0;
}
