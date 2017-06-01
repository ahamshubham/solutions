import java.io.*;
import java.util.*;


public class Problem810B {
    public static void main(String args[]) throws IOException {
        int i, j;
        
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        String n_and_f = buf.readLine();
        
        String ar[] = n_and_f.split(" ");
        int n = Integer.parseInt(ar[0]);
        int f = Integer.parseInt(ar[1]);
        
        ArrayList<ArrayList<Integer>> b = new ArrayList();
        
        
        
        for(i = 0; i < n; i++) {
            String ps_and_cs = buf.readLine();
            ar = ps_and_cs.split(" ");
            int num_of_products = Integer.parseInt(ar[0]);
            int num_of_customers = Integer.parseInt(ar[1]);
            b.add(new ArrayList(Arrays.asList(min(num_of_products*2,num_of_customers),min(num_of_products,num_of_customers))));
        }
        
        Comparator<ArrayList<Integer>> comparator = new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> left, ArrayList<Integer> right) {
                return -((left.get(0) - left.get(1)) - (right.get(0) - right.get(1)));
            }
        };
        
        Collections.sort(b,comparator);
        
        //System.out.println(b);
        
        Long sum = 0L;
        
        for(i = 0; i < f; i++)
            sum = sum + b.get(i).get(0);
        
        for(i = f; i < n; i++)
            sum = sum + b.get(i).get(1);
        
        System.out.println(sum);
    }
    
    public static int min(int a, int b) {
        if(a<b)
            return a;
        else
            return b;
    }
}
