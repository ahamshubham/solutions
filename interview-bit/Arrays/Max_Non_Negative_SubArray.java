import java.util.*;
import java.io.*;

public class Solution {    

    /*public static void main(String args[]) throws IOException {
        ArrayList<Integer> a = new ArrayList<Integer>();
        a.add(1967513926);
        a.add(1540383426);
        a.add(-1303455736);
        a.add(-521595368);
       
        ArrayList<Integer> b = maxset(a);
        int l = b.size();
        for(int i = 0;i < l; i++) {
            System.out.println(b.get(i));
        }
    }*/ 
    
	public static ArrayList<Integer> maxset(ArrayList<Integer> a) {
	    int l = a.size();
	    int max_len = 0;
	    int flag = 0;
	    int first_elem = 0;
	    ArrayList<Integer> max_arr = new ArrayList<Integer>();
	    ArrayList<Integer> tmp_arr = new ArrayList<Integer>();
	    Long tmp_sum = 0L;
	    Long max_sum = 0L;
	    for(int i = 0; i < l; i++) {
	        if(a.get(i)<0) {
	            if(flag == 1) {
	                if(tmp_sum >= max_sum) {
	                    if(tmp_sum > max_sum) {
	                        max_arr = tmp_arr;
	                        max_sum = tmp_sum;
	                    } else if(tmp_arr.size() >= max_arr.size()) {
	                        if(tmp_arr.size() > max_arr.size()) {
	                            max_arr = tmp_arr;
	                        } else if(tmp_arr.get(0) < max_arr.get(0)) {
	                            max_arr = tmp_arr;
	                        }
	                    }
	                }
	            }
	            flag = 0;
	            tmp_sum = 0L;
	            tmp_arr = new ArrayList<Integer>();
	            continue;
	        }
	        if(flag == 0) {
	            flag = 1;
	        }
	        
	        tmp_arr.add(a.get(i));
	        tmp_sum = tmp_sum + a.get(i); 
	        
	    }
	    
        if(flag == 1) {
	                if(tmp_sum >= max_sum) {
	                    if(tmp_sum > max_sum) {
	                        max_arr = tmp_arr;
	                        max_sum = tmp_sum;
	                    } else if(tmp_arr.size() >= max_arr.size()) {
	                        if(tmp_arr.size() > max_arr.size()) {
	                            max_arr = tmp_arr;
	                        } else if(tmp_arr.get(0) < max_arr.get(0)) {
	                            max_arr = tmp_arr;
	                        }
	                    }
	                }
	            }
	    
	    return max_arr;
	}
}

