import java.util.*;
import java.io.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Strings {
    public static void main(String args[]) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        
        int i, j;
        String m_and_n = buf.readLine();
        String ar[] = m_and_n.split(" ");
        int m = Integer.parseInt(ar[0]);
        int n = Integer.parseInt(ar[1]);
        
        String elems[];
        int factored_elems[][][] = new int[m][n][2];
        
        for(i = 0; i < m; i++){
            String tmp = buf.readLine();
            elems = tmp.split(" ");
            for(j = 0; j < n; j++) {
                ArrayList<Integer> tmp2 = factorise(Integer.parseInt(elems[j]));
                //System.out.println(tmp2);
                factored_elems[i][j][0] = tmp2.get(0);
                factored_elems[i][j][1] = tmp2.get(1);
            }
        }
        
        flag = 0;
        int sum[] = {0,0};
        int curr_elem[] = {0,0};
        backtracking(m, n, 0, sum, curr_elem, factored_elems);
        
        System.out.println(final_solution);
    }
    
    static int flag;
    static int final_solution;
    
    public static void backtracking(int m, int n, int level, int sum[], int curr_elem[], int factored_elems[][][]) {
        
        if(curr_elem[0] == m-1 && curr_elem[1] == n-1) {
            //System.out.println(sum[0]+":"+sum[1]);
            int min = sum[0]+factored_elems[m-1][n-1][0];
            
            if(min > sum[1] + factored_elems[m-1][n-1][1])
                min = sum[1] + factored_elems[m-1][n-1][1];
                    
            if(flag == 0)
                final_solution = min;
            else {
                if(final_solution > min)
                    final_solution = min; 
            }
            flag = 1;
            
            return;
        }
        
        if(curr_elem[0] == m || curr_elem[1] == n)
            return;
        
        int curr_elem_x = factored_elems[curr_elem[0]][curr_elem[1]][0];
        int curr_elem_y = factored_elems[curr_elem[0]][curr_elem[1]][1];
        
        curr_elem[0]++;
        sum[0] += curr_elem_x;
        sum[1] += curr_elem_y;
        
        backtracking(m,n,level+1,sum,curr_elem,factored_elems);
        
        sum[0] -= curr_elem_x;
        sum[1] -= curr_elem_y;
        curr_elem[0]--;
        
        
        curr_elem[1]++;
        sum[0] += curr_elem_x;
        sum[1] += curr_elem_y;
        
        backtracking(m,n,level+1,sum,curr_elem,factored_elems);
        
        sum[0] -= curr_elem_x;
        sum[1] -= curr_elem_y;
        curr_elem[1]--;
        
    }
    
    public static ArrayList<Integer> factorise(int n) {
        int i = 0;
        int j = 0;
        int n1 = n;
        
        while(n % 2 == 0) {
            i++;
            n = n/2;
        }
        
        while(n1%5 == 0) {
            j++;
            n1 = n1/5;
        }
        
        return new ArrayList(Arrays.asList(i,j));
    }
    
}

/*
3 3
10 12 14
15 30 16
12 10 20
*/

