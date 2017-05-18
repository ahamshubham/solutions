import java.io.*;
import java.util.*;

class Subset {
    public static void main(String args[]) throws IOException {
        System.out.println(subsets(new ArrayList(Arrays.asList())));
        System.out.println(subsets(new ArrayList(Arrays.asList(1,2,3))));
        System.out.println(subsets(new ArrayList(Arrays.asList(1,12,31,312,12,1,2,2,3))));
    }
    
    static ArrayList<ArrayList<Integer>> solution;
    
    public static ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> a) {
         solution = new ArrayList();
         Collections.sort(a);
         backtracking(a,new ArrayList<Integer>());
         return solution;
    }
    
    public static void backtracking(ArrayList<Integer> b, ArrayList<Integer> c) {
        int i;
        
        
        if(b.isEmpty()) {
            addSolution(c);
            return;
        }
        
        addSolution(c);
        
        for(i = 0; i < b.size(); i++) {
            int tmp = b.get(i);
            c.add(tmp);
            backtracking(new ArrayList(b.subList(i+1, b.size())),c);
            c.remove(c.size()-1);
        }
    }
    
    public static void addSolution(ArrayList<Integer> c) {
        ArrayList<Integer> d = new ArrayList();
        for(int i = 0; i < c.size(); i++){
            d.add(c.get(i));
        }
        solution.add(d);
    }
}
