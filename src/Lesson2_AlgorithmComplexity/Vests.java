package Lesson2_AlgorithmComplexity;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Vests {
    public static List<List<Integer>> solution(List<Integer> desiredSize, List<Integer> availableVest, int x, int y){
        List<List<Integer>> result = new ArrayList<>();
        int desiredPtr = 0;
        int vestPtr = 0;
        while (desiredPtr < desiredSize.size() && vestPtr < availableVest.size()){
            while (vestPtr < availableVest.size() && desiredSize.get(desiredPtr) - x > availableVest.get(vestPtr)){
                vestPtr++; // in availableVest list: move this forward to the next available vest to see if it fits
            }

            if (vestPtr < availableVest.size() && availableVest.get(vestPtr) <= desiredSize.get(desiredPtr) + y){
                List<Integer> list = new ArrayList<>();
                list.add(desiredPtr+1);
                list.add(vestPtr+1);
                result.add(list);
                vestPtr++;
            }
            desiredPtr ++;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // first line
        // number of soldiers
        int n = Integer.parseInt(sc.next());
        // number of vests
        int m = Integer.parseInt(sc.next());
        // unpretentiousness
        int x = Integer.parseInt(sc.next());
        int y = Integer.parseInt(sc.next());

        // second line
        List<Integer> desiredSize = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            desiredSize.add(Integer.parseInt(sc.next()));
        }

        // third line
        List<Integer> availableVest = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            availableVest.add(Integer.parseInt(sc.next()));
        }

        // print result
        List<List<Integer>> result = solution(desiredSize, availableVest, x, y);
        System.out.println(result.size());
        for (List<Integer> list : result) {
            StringBuilder s = new StringBuilder();
            for (Integer i : list) {
                s.append(i).append(" ");
            }
            s = new StringBuilder(s.substring(0, s.length() - 1));
            System.out.println(s);
        }

    }
}
