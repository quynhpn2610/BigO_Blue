package Lesson2_AlgorithmComplexity;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Wrath {
    public static int solution(List<Integer> list){
        // start from the end because one kills the one before them
        int currentPerson = list.size()-1;
        int prevPerson = currentPerson - 1;
        List<Integer> isKilled = new ArrayList<>();

        // outer while loops thru each person
        // inner while checks the outer person's number of kills
        while(currentPerson >= 0){
            while(prevPerson >= 0){
                int j = prevPerson + 1;
                int i = currentPerson + 1;
                int Li = list.get(currentPerson);
                boolean isBehind = j < i;
                boolean crawIsLongEnough = j >= i - Li;
                if (isBehind && crawIsLongEnough){
                    isKilled.add(prevPerson);
                }
                if (!crawIsLongEnough){
                    break;
                }
                prevPerson--;
            }
            currentPerson--;
        }
        return list.size() - isKilled.size();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.next());
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(sc.next()));
        }
        System.out.println(solution(list));
        sc.close();

    }
}
