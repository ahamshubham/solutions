import java.util.*;
import java.io.*;

class MergeIntervals {
    public static void main(String args[]) throws IOException {
        ArrayList<Interval> arr_list = new ArrayList<Interval>();
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        for(int i = 0; i < n; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            arr_list.add(new Interval(start,end));
        }
        
        int start = sc.nextInt();
        int end = sc.nextInt();
        
        Interval newInterval = new Interval(start, end);
        
        ArrayList<Interval> result = insert(arr_list, newInterval);
        for(int i=0; i < result.size(); i++) {
            Interval interval = result.get(i);
            System.out.println(interval.start + "," + interval.end);
        }        
    }
 
    public static ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        int x = newInterval.start;
        int y = newInterval.end;
        
        if(x>y) {
            int temp = x;
            x = y;
            y = temp;
        }
        
        int n = intervals.size();
        
        int rstart = -1, rend = -1;
        int first = 0;
        int last = n-1;
        int mid;
        
        if(intervals.isEmpty()) {
            intervals.add(newInterval);
            return intervals;
        }
        
        if(last == first) {
            if(x < intervals.get(first).start) {
                rstart = first;
            } else if(x >= intervals.get(first).start && x <= intervals.get(first).end) {
                x = intervals.get(first).start;
                rstart = first;
            } else {
                rstart = first+1;
            }
            
            if(y < intervals.get(first).start) {
                rend = first-1;
            } else if(y >= intervals.get(first).start && y <= intervals.get(first).end) {
                y = intervals.get(first).end;
                rend = first;
            } else {
                rend = first;
            }
            
        }
        else {
        while(last > first) {
            
            if(x < intervals.get(first).start) {
                rstart = first;
                break;
            } else if(x >= intervals.get(last).start) {
                if(x <= intervals.get(last).end) {
                    rstart = last;
                    x = intervals.get(last).start;
                } else {
                    rstart = last + 1;
                }
                break;
            }
            
            if(last - first == 1) {
                if(x <= intervals.get(first).end) {
                    rstart = first;
                    x = intervals.get(first).start;
                } else {
                    rstart = last;
                }
                break;
            }
            
            mid = (first + last) / 2;
            if(x > intervals.get(mid).start) {
                first = mid;
            } else if(x < intervals.get(mid).start) {
                last = mid;
            } else {
                x = intervals.get(mid).start;
                rstart = mid;
                break;
            }
        }
        
        first = 0;
        last = n-1;
        
        while(last > first) {
            
            if(y <= intervals.get(first).end) {
                if(y >= intervals.get(first).start) {
                    rend = first;
                    y = intervals.get(first).end;
                } else {
                    rend = first - 1;
                }
                break;
            } else if(y > intervals.get(last).end) {
                rend = last;
                break;
            }
            
            if(last - first == 1) {
                if(y >= intervals.get(last).start) {
                    rend = last;
                    y = intervals.get(last).end;
                } else {
                    rend = first;
                }
                break;
            }
            
            mid = (first + last) / 2;
            if(y > intervals.get(mid).end)
                first = mid;
            else if(y < intervals.get(mid).end)
                last = mid;
            else {
                y = intervals.get(mid).end;
                rend = mid;
            }
        }
        }
        
        //Remove unwanted intervals from the array
        if(rstart >= 0 && rstart <= n-1 && rend >= 0 && rend <= n-1 && rstart <= rend)
            intervals.subList(rstart,rend+1).clear();
            
        intervals.add(rstart,new Interval(x,y));
        return intervals;
    }
}
