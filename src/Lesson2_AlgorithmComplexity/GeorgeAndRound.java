package Lesson2_AlgorithmComplexity;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GeorgeAndRound {
    public static int solution(List<Integer> min, List<Integer> prepared){
        int preparedPtr = 0;
        int minPtr = 0;
        while (preparedPtr < prepared.size() && minPtr < min.size()){
            if (prepared.get(preparedPtr) >= min.get(minPtr)){
                minPtr ++;
            }
            preparedPtr++;
        }
        return min.size() - minPtr;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //first line
        int n = Integer.parseInt(sc.next());
        int m = Integer.parseInt(sc.next());
        //2nd line
        List<Integer> min = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            min.add(Integer.parseInt(sc.next()));
        }
        //3rd line
        List<Integer> prepared = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            prepared.add(Integer.parseInt(sc.next()));
        }

        //print results
        System.out.println(solution(min, prepared));
        sc.close();
    }
}
