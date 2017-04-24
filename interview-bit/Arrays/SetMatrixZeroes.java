import java.util.*;
import java.io.*;

public class SetMatrixZeroes {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        
        ArrayList<ArrayList<Integer>> a = new ArrayList<ArrayList<Integer>>();
        
        for(int i=0; i < m; i++) {
            ArrayList<Integer> tmp = new ArrayList<Integer>();
            for(int j = 0; j < n; j++) {
                tmp.add(sc.nextInt());
            }
            a.add(tmp);
        }
        
        setZeroes(a);
    }
    
    public static void setZeroes(ArrayList<ArrayList<Integer>> a) {
        
        int m = a.size();
	    if(m > 0){
	        int n = a.get(0).size();
	        int mark_row[] = new int[m];
	        int mark_col[] = new int[n];
	        int i,j;
	        
	        for(i = 0; i < m; i++)
	            mark_row[i] = 0;
	        
	        for(i = 0; i < n; i++)
	            mark_col[i] = 0;
	            
	        for(i = 0; i < m; i++) {
	            for(j = 0; j < n; j++) {
	                if(a.get(i).get(j) == 0) {
                        mark_row[i] = 1;
                        mark_col[j]	= 1;
	                }
	            }
	        }
	        
	        /*
	        for(i = 0; i < m; i++)
	            System.out.println("Mark "+i+"with"+mark_row[i]);
	            
	        for(i = 0; i < n; i++)
	            System.out.println("Mark "+i+"with"+mark_col[i]);
	        */
	        for(i = 0; i < m; i++) {
	            ArrayList<Integer> tmp = a.get(i);
	            for(j = 0; j < n; j++) {
	                if(mark_row[i] == 1 || mark_col[j] == 1) {
                        tmp.set(j,0);
	                }
	            }
	        }
	    }
	    
	    //System.out.println(a);
	}
}
