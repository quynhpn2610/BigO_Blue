package Lesson2_AlgorithmComplexity;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Array {
    private static int[] findSegment(int k, List<Integer> list){
        // 1 distinct element segment -> segment starts at 1 and ends at 1
        if(k==1){
            return new int[]{1, 1};
        }

        // more than 1 distinct element
        int[] res = new int[]{-1, -1};

        // this map stores all elements in the list
        // and their number of occurrences
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(list.get(0), 1);

        for (int i = 0; i < list.size(); i++) {
            // Loop thru the list and put each element in the map once
            if(!map.containsKey(list.get(i))){
                map.put(list.get(i), 1);
            }
            else {
                map.put(list.get(i), map.get(list.get(i))+1);
            }
        }

        if (map.size() < k){
            return res;
        }
        else{
            // in the beginning let l = 1, r = n
            int n = list.size();
            int l = 0; // deduct 1 because of 0 indexing
            int r = n-1;


            while(r-l+1 >= k){
                if (list.get(r) == list.get(r-1)){
                    int value = map.get(list.get(r));
                    if (value > 0){
                        value --; // decrease cnt ar by 1 if we delete element number r
                    }
                    else if (value == 0) map.remove(list.get(r), value);
                    // list.remove(r);
                    r--;
                }
            }

        }
        return res;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // number of element in array
        int n = Integer.parseInt(sc.next());
        // number of distinct number in the segment
        int k = Integer.parseInt(sc.next());

    }

}
