package Lesson2_AlgorithmComplexity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Array {
    private static int[] solution(int k, List<Integer> list){
        // 1 distinct element segment -> segment starts at 1 and ends at 1
        if(k==1){
            return new int[]{1, 1};
        }

        // more than 1 distinct element
        int[] res = new int[]{-1, -1};

        int firstPtr = -1;
        int secondPtr = -1;
        int maxLength = list.size();

        // this map stores all elements in the list
        // and their number of occurrences
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(list.get(0), 1);

        for (int i = 0; i < list.size(); i++) {
            // Loop thru the list and put each element in the map once
            if(!map.containsKey(list.get(i))){
                map.put(list.get(i), 1);
            }
//            else{
//                map.put(list.get(i), map.get(list.get(i))+1);
//            }
            if (map.size() < k) {
                map.put(list.get(i), map.get(list.get(i))+1);
            }

            // when map.size = k
            else {
                secondPtr = i;
                break;
            }
        }

//        if (map.size() < k){
//            return res;
//        }

        if (secondPtr == -1){
            return res;
        }

        // now start from secondPtr back to firstPtr
        map = new HashMap<>();
        map.put(list.get(secondPtr), 1);
        for (int i = secondPtr - 1; i>=0; i--){
            if (!map.containsKey(list.get(i))){
                map.put(list.get(i), 1);
            }

            if (map.size() < k){
                map.put(list.get(i), map.get(list.get(i))+1);
            }
            else{
                firstPtr = i;
                break;
            }
        }

        // 1-based index
        res[0] = firstPtr+1;
        res[1] = secondPtr+1;

        return res;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // number of element in array
        int n = Integer.parseInt(sc.next());
        // number of distinct number in the segment
        int k = Integer.parseInt(sc.next());

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(sc.next()));
        }
        int[] result = solution(k, list);
        StringBuilder s = new StringBuilder();
        for (int i : result) {
            s.append(i).append(" ");
        }
        s = new StringBuilder(s.substring(0, s.length() - 1));
        System.out.println(s);
        sc.close();
    }
}
