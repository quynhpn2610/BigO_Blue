package Lesson3_Sorting;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Towers {
    private static void solution(List<Integer> list){
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i: list){
            if (map.containsKey(i)){
                map.put(i, map.get(i)+1);
            }
            else{
                map.put(i, 1);
            }
        }

        int numberOfTowers = map.size();
        int tallestTower = 1;
        for (int i: map.keySet()) {
            if (map.get(i) > tallestTower){
                tallestTower = map.get(i);
            }
        }
        System.out.println(tallestTower + " " + numberOfTowers);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.next());
        List<Integer> lengths = new ArrayList<>();
        for (int i = 0; i<n; i++){
            lengths.add(Integer.parseInt(sc.next()));
        }
        solution(lengths);
        sc.close();
    }
}
