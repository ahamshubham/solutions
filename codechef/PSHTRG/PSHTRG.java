/*
5 4
3 1 8 9 7
2 1 5
1 2 12
2 1 3
2 2 5
*/

import java.io.*;
import java.util.*;

class PSHTRG {
	static int N, Q;
	static ArrayList<Integer> original_array = new ArrayList<Integer>();
	static int magic_number = 45;
	
	static class Segment {
		ArrayList<ArrayList<Integer>> elements_required_and_their_indices = new ArrayList<ArrayList<Integer>>();
		int left;
		int right;
		Segment left_child;
		Segment right_child;
	}

	public static ArrayList<ArrayList<Integer>> merge(ArrayList<ArrayList<Integer>> first_array, ArrayList<ArrayList<Integer>> second_array) {
		ArrayList<ArrayList<Integer>> merged_array = new ArrayList<ArrayList<Integer>>();	
		int c1 = 0, c2 = 0;
		int size_of_first_array = first_array.size();
		int size_of_second_array = second_array.size();
		int c = 0;

		while(c < magic_number && c < size_of_first_array + size_of_second_array) {
			merged_array.add(new ArrayList<Integer>());	
			if(c1 >= size_of_first_array) {
				merged_array.get(c).add(second_array.get(c2).get(0));
				merged_array.get(c).add(second_array.get(c2).get(1));
				c2++;
			} else if(c2 >= size_of_second_array) {
				merged_array.get(c).add(first_array.get(c1).get(0));
				merged_array.get(c).add(first_array.get(c1).get(1));
				c1++;
			} else if(second_array.get(c2).get(0) > first_array.get(c1).get(0)) {
				merged_array.get(c).add(second_array.get(c2).get(0));
				merged_array.get(c).add(second_array.get(c2).get(1));
				c2++;
			} else {
				merged_array.get(c).add(first_array.get(c1).get(0));
				merged_array.get(c).add(first_array.get(c1).get(1));
				c1++;
			}
			c++;
		}

		return merged_array;
	}

	public static ArrayList<ArrayList<Integer>> fill_node(int start, int end, Segment parent) {
		parent.left = start;
		parent.right = end;
		
		if(start == end) {
			ArrayList<Integer> element_to_be_added_and_its_index = new ArrayList<Integer>();
			element_to_be_added_and_its_index.add(original_array.get(start));
			element_to_be_added_and_its_index.add(start);
			parent.elements_required_and_their_indices.add(element_to_be_added_and_its_index);
			parent.left_child = null;
			parent.right_child = null;

			return parent.elements_required_and_their_indices;
		}
		
		int mid = (start + end)/2;
		parent.left_child = new Segment();
		parent.right_child = new Segment();
		ArrayList<ArrayList<Integer>> left_array = fill_node(start, mid, parent.left_child);
		ArrayList<ArrayList<Integer>> right_array = fill_node(mid + 1, end, parent.right_child);

		parent.elements_required_and_their_indices = merge(left_array, right_array);

		return parent.elements_required_and_their_indices;
	}

	public static Long getMaximumPerimeter(int left_limit_of_range, int right_limit_of_range, Segment root_node) {
		ArrayList<ArrayList<Integer>> sorted_array_in_range = get_sorted_array_in_range(left_limit_of_range, right_limit_of_range, root_node);
		for(int i = 0; i < sorted_array_in_range.size() - 2; i++) {
			if(sorted_array_in_range.get(i).get(0) < sorted_array_in_range.get(i + 1).get(0) + sorted_array_in_range.get(i + 2).get(0))
				return new Long(sorted_array_in_range.get(i).get(0)) + new Long(sorted_array_in_range.get(i + 1).get(0)) + new Long(sorted_array_in_range.get(i + 2).get(0));
		}
		
		return 0L;
	}

	public static ArrayList<ArrayList<Integer>> get_sorted_array_in_range(int left_limit_of_range, int right_limit_of_range, Segment parent) {
		if(left_limit_of_range <= parent.left && right_limit_of_range >= parent.right) {
			return parent.elements_required_and_their_indices;
		}
		
		ArrayList<ArrayList<Integer>> left_array = new ArrayList<ArrayList<Integer>>();
		if(!(left_limit_of_range > parent.left_child.right || right_limit_of_range < parent.left_child.left)) {
			left_array = get_sorted_array_in_range(left_limit_of_range, right_limit_of_range, parent.left_child);
		}
		
		ArrayList<ArrayList<Integer>> right_array = new ArrayList<ArrayList<Integer>>();
		if(!(left_limit_of_range > parent.right_child.right || right_limit_of_range < parent.right_child.left)) {
			right_array = get_sorted_array_in_range(left_limit_of_range, right_limit_of_range, parent.right_child);
		}

		if(left_array.isEmpty())
			return right_array;
		
		if(right_array.isEmpty())
			return left_array;
		
		return merge(left_array, right_array);
	}
	
	public static void update_element(int index_updated, int element, Segment parent) {
		int index_of_searched_element = magic_number;		
		for(int i = 0; i < parent.elements_required_and_their_indices.size(); i++) {
			if(parent.elements_required_and_their_indices.get(i).get(1) == index_updated) {
				index_of_searched_element = i;
				break;
			}
		}
		
		ArrayList<ArrayList<Integer>> temp = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> element_to_be_added_and_its_index = new ArrayList<Integer>();
		element_to_be_added_and_its_index.add(element);
		element_to_be_added_and_its_index.add(index_updated);
		temp.add(element_to_be_added_and_its_index);

		if(index_of_searched_element == magic_number) {
			parent.elements_required_and_their_indices = merge(temp, parent.elements_required_and_their_indices);
		} else {
			parent.elements_required_and_their_indices.remove(index_of_searched_element);
			parent.elements_required_and_their_indices = merge(temp, parent.elements_required_and_their_indices);
		}
		
		if(parent.left_child != null) {
			if(index_updated <= parent.left_child.right && index_updated >= parent.left_child.left)
				update_element(index_updated, element, parent.left_child);
		}

		if(parent.right_child != null) {
			if(index_updated <= parent.right_child.right && index_updated >= parent.right_child.left)
				update_element(index_updated, element, parent.right_child);
		}
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		Q = sc.nextInt();
		int i;

		for(i = 0; i < N; i++) {
			original_array.add(sc.nextInt());
		}

		Segment root_node = new Segment();
		fill_node(0, N-1, root_node);

		for(i = 0; i < Q; i++) {
			if(sc.nextInt() == 2) {
				System.out.println(getMaximumPerimeter(sc.nextInt() - 1, sc.nextInt() - 1, root_node));
			} else {
				update_element(sc.nextInt() - 1, sc.nextInt(), root_node);
			}
		}
	}
}
