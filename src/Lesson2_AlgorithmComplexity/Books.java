package Lesson2_AlgorithmComplexity;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Books {
    private static int findMaxBooks(List<Integer> timeList, int T){
        // this func takes in 2 param: list of time for each book, T is total free time
        int sum = 0;
        int l = 0;
        // max number of books he can read
        int best = 0;

        for (int r = 0; r < timeList.size(); r++){
            sum += timeList.get(r);
            while (sum > T){
                sum -= timeList.get(l);
                l++;
            }
            best = Math.max(best, r-l+1);
        }
        return best;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberOfBooks = Integer.parseInt(sc.next());
        int T = Integer.parseInt(sc.next());
        List<Integer> timeList = new ArrayList<>();

        for (int i = 0; i < numberOfBooks; i++) {
            int time = Integer.parseInt(sc.next());
            timeList.add(time);
        }

        System.out.println(findMaxBooks(timeList, T));
    }
}
