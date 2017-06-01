import java.util.*;
import java.io.*;

class NQueens {
    public static void main(String args[]) throws IOException {
        int i;
        for(i = 0; i < 12; i++)
            System.out.println(i+":"+solveNQueens(i));
    }
    
    static ArrayList<ArrayList<Integer>> solution;
    static ArrayList<ArrayList<String>> final_solutions;
    static ArrayList<Integer> sol;
    
    public static ArrayList<ArrayList<String>> solveNQueens(int a) {
        solution = new ArrayList<ArrayList<Integer>>();
        final_solutions = new ArrayList();
        sol = new ArrayList();
        int i,j;
        
        for(i = 0; i < a; i++){
            solution.add(new ArrayList(Arrays.asList()));            
            for(j = 0; j < a; j++)
                solution.get(i).add(j);
        }
        
        backtracking(a, 0);
        
        return final_solutions;
    }
    
    public static void backtracking(int n, int row_num) { 
        int i,j;
        
        if(row_num == n) {
            int total_solutions = final_solutions.size();
            final_solutions.add(new ArrayList());
            for(i = 0; i < n; i++) {
                final_solutions.get(total_solutions).add("");
                for(j = 0; j < n; j++) {
                    if(sol.get(i) == j)
                        final_solutions.get(total_solutions).set(i,final_solutions.get(total_solutions).get(i)+"Q");
                    else
                        final_solutions.get(total_solutions).set(i,final_solutions.get(total_solutions).get(i)+".");
                }
            }
            return;
        }
        
        for(i = 0; i < solution.get(row_num).size(); i++) {
            int element_chosen = solution.get(row_num).get(i);
            sol.add(element_chosen);
            //System.out.println("For n,row_num:"+ n + "," + row_num +",solution before removal:"+solution);
            
            ArrayList<ArrayList<Integer>> removed = new ArrayList<ArrayList<Integer>>();
            
            for(j = row_num+1; j < n; j++) {
            
                if(solution.get(j).remove(Integer.valueOf(element_chosen+(j-row_num))))
                    removed.add(new ArrayList(Arrays.asList(j,element_chosen+(j-row_num))));
                
                if(solution.get(j).remove(Integer.valueOf(element_chosen-(j-row_num))))
                    removed.add(new ArrayList(Arrays.asList(j,element_chosen-(j-row_num))));
                
                if(solution.get(j).remove(Integer.valueOf(element_chosen)))
                    removed.add(new ArrayList(Arrays.asList(j,element_chosen)));
                
            }
            
            //System.out.println("For n,row_num:"+ n + "," + row_num +",solution after removal:"+solution);
            backtracking(n, row_num+1);
            
            for(j = 0; j < removed.size(); j++) {
                solution.get(removed.get(j).get(0)).add(removed.get(j).get(1));
            }
            
            //System.out.println("For n,row_num:"+n + "," + row_num +",solution after addition:"+solution);
            sol.remove(sol.size()-1);
        }
    }
}
