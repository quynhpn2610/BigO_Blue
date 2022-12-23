package Lesson2_AlgorithmComplexity;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GeorgeAndRound {
    public static int solution(List<Integer> expected, List<Integer> prepared){
        int preparedPtr = 0;
        int expectedPtr = 0;
        while (expectedPtr < expected.size() && preparedPtr < prepared.size()){
            // compare prepared with expected one by one
            if (prepared.get(preparedPtr) >= expected.get(expectedPtr)){
                expectedPtr ++; // if prepared is >= expected --> pass expected
            }
            preparedPtr++;
        }
        return expected.size() - expectedPtr; // to get the leftover in expected, which is the needed
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //first line
        int n = Integer.parseInt(sc.next());
        int m = Integer.parseInt(sc.next());
        //2nd line
        List<Integer> expected = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            expected.add(Integer.parseInt(sc.next()));
        }
        //3rd line
        List<Integer> prepared = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            prepared.add(Integer.parseInt(sc.next()));
        }
        //print results
        System.out.println(solution(expected, prepared));
        sc.close();
    }
}
