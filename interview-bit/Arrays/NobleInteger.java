import java.io.*;
import java.util.*;

class NobleInteger {
    public static void main(String args[]) throws IOException {
        ArrayList<Integer> arr_list = new ArrayList<Integer>();
        int arr[] = {1,2,3,4};
        for(int i = 0; i < arr.length; i++)
            arr_list.add(arr[i]);
        System.out.println(solve(arr_list));
    }
    
    public static int solve(ArrayList<Integer> a) {
        Collections.sort(a);
        int n = a.size();
        int flag = -1;
        for(int i=0; i < n; i++) {
            if(i!=n-1){
                if(a.get(i) == a.get(i+1))
                    continue;
            }
            if(a.get(i) == (n-i-1)) {
                flag = 1;
            }
        }
        return flag;
    }
}
