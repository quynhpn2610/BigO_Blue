package Lesson3_Sorting;

import java.util.*;

public class GukiZContest {
    private static String solution(List<Integer> list){
        // A map to keep track of indexes of the original rating list
        // Key = element, value = list of its indexes
        Map<Integer, List<Integer>> elementIndex = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            if (!elementIndex.containsKey(list.get(i))){
                elementIndex.put(list.get(i), new ArrayList<>());
            }
            elementIndex.get(list.get(i)).add(i);
        }

        // sort the list (ascending order) and reverse it
        Collections.sort(list);
        Collections.reverse(list);

        // Put list elements (ratings) in a map (key = element, value = freq)
        Map<Integer, Integer> map = new LinkedHashMap<>(); // use linked hashmap to preserve insertion order
        for (int rating: list) {
            if (map.containsKey(rating)){
                map.put(rating, map.get(rating)+1);
            }
            else{
                map.put(rating, 1);
            }
        }

        // map each rating to its rank
        int rank = 1;
        Map<Integer, Integer> ratingToRanking = new HashMap<>();
        for(int i: map.keySet()){
            ratingToRanking.put(i, rank);
            rank += map.get(i);
        }

        // Give rank of each rating to corresponding index
        int[] res = new int[list.size()];
        for (int i:
             elementIndex.keySet()) {
            int thisRank = ratingToRanking.get(i);
            for(int index: elementIndex.get(i)){
                res[index] = thisRank;
            }
        }

        // return
        StringBuilder s = new StringBuilder();
        for (int i: res) {
            s.append(i).append(" ");
        }
        s = new StringBuilder(s.substring(0, s.length()-1)); // to get rid of the last space
        return s.toString();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.next());
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(sc.next()));
        }

        String res = solution(list);
        System.out.println(res);
        sc.close();
    }

}
