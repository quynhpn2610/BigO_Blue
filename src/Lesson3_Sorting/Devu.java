package Lesson3_Sorting;

import java.util.Arrays;
import java.util.Scanner;

public class Devu {
    private static long selfLearning(int[] subjects, int x){
        Arrays.sort(subjects);
        long min_time = 0;
        for (int subject: subjects){
            min_time += 1L * subject * x;

            // decrease the time for each chapter by 1 after each iteration
            // stop when x = 1 because 1 is min time for a chapter
            if (x > 1) x--;
        }

        return min_time;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // numbers of subjects
        int n = Integer.parseInt(sc.next());
        // max time for learning a chapter
        int x = Integer.parseInt(sc.next());

        // an array of hours for each subject
        int[] subjects = new int[n];

        for (int i = 0; i < n; i++) {
            subjects[i] = sc.nextInt();
        }

        long res = selfLearning(subjects, x);
        System.out.print(res);

    }
}
