import java.io.*;
import java.util.*;

class Permutations {
    
    public static void main(String args[]) throws IOException {
        System.out.println(permute(new ArrayList(Arrays.asList(1,2,3,4))));
    }
    
    static ArrayList<ArrayList<Integer>> final_solutions;
    static ArrayList<Integer> solution;
    static ArrayList<Integer> used_elems;
    
    public static ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> a) {
        int i;
        final_solutions = new ArrayList<ArrayList<Integer>>();
        used_elems = new ArrayList<Integer>();
        solution = new ArrayList<Integer>();
        int n = a.size();
        
        for(i = 0; i < n; i++)
            used_elems.add(0);
        
        backtracking(n,0,a);
        
        return final_solutions;
    }
    
    public static void backtracking(int max_level, int level, ArrayList<Integer> a) {
        int i;
        if(level == max_level) {
            ArrayList<Integer> final_solution = new ArrayList<Integer>();
            for(i = 0; i < solution.size(); i++)
                final_solution.add(solution.get(i));
            final_solutions.add(final_solution);
        }
        
        for(i = 0; i < max_level; i++) {
            if(used_elems.get(i) == 0) {
                used_elems.set(i,1);
                solution.add(a.get(i));
                backtracking(max_level, level+1, a);
                solution.remove(solution.size()-1);
                used_elems.set(i,0);
            }
        }
    }
}

