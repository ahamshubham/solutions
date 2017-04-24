import java.io.*;
import java.util.*;

public class WaveArray {
    public static void main(String args[]) throws IOException {
        int arr[] = {4,2,3,4,1,5};
        ArrayList<Integer> arr_list = new ArrayList<Integer>();
        for(int i = 0; i < arr.length; i++)
            arr_list.add(arr[i]);
        System.out.println(wave(arr_list));
    }
    
    public static ArrayList<Integer> wave(ArrayList<Integer> a) {
        Collections.sort(a);
        int n = a.size();
        for(int i=0;i<n-1;i=i+2) {
            int temp = a.get(i);
            a.set(i,a.get(i+1));
            a.set(i+1,temp);
        }
        return a;
    }
}
