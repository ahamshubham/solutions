import java.util.*;
import java.io.*;

class UniquePathsInAGrid {
        public static void main(String args[]) throws IOException {
                ArrayList<ArrayList<Integer>> a = new ArrayList<ArrayList<Integer>>();
                a.add(new ArrayList<Integer>(Arrays.asList(0)));
                System.out.println(uniquePathsWithObstacles(a));
        }
        
        static int unique_paths_possible_from_a_position[][];
        static ArrayList<ArrayList<Integer>> b;
        
        public static int uniquePathsWithObstacles(ArrayList<ArrayList<Integer>> a) {
                int n = a.size();
                b = a;
                if(n == 0)
                        return 0;
                else {
                        int i, j, m = a.get(0).size();
                        if(m == 0)
                                return 0;
                        
                        
                        unique_paths_possible_from_a_position = new int[n][m];
                        
                        for(i = 0; i < n; i++)
                                for(j = 0; j < m; j++)
                                        if(a.get(i).get(j) == 1)
                                                unique_paths_possible_from_a_position[i][j] = 0;
                                        else
                                                unique_paths_possible_from_a_position[i][j] = -1;
                        
                        return uniquePathsPossibleFromAPosition(0, 0);
                }
        }
        
        
        public static int uniquePathsPossibleFromAPosition(int i, int j) {
                if(i >= b.size() || j >= b.get(0).size())
                        return 0;
                
                if(unique_paths_possible_from_a_position[i][j] == 0) {
                        return 0;
                }
                
                if(i == b.size()-1 && j == b.get(0).size()-1)
                        return 1;
                
                unique_paths_possible_from_a_position[i][j] = uniquePathsPossibleFromAPosition(i,j+1) +
                uniquePathsPossibleFromAPosition(i+1,j);
                
                return unique_paths_possible_from_a_position[i][j];
        }
}
