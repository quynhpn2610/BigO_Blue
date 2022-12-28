package Lesson3_Sorting;

import java.util.Arrays;
import java.util.Scanner;

public class Chores {
    private static int solution(int[] list, int a, int b){
        // sort the list of chores and then get the difference between b and b-1 chore.
        // That's the number of x'es that can be used to divide the list.
        Arrays.sort(list);
        int res = list[b] - list[b-1];
        return res;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.next());
        int a = Integer.parseInt(sc.next());
        int b = Integer.parseInt(sc.next());
        int[] list = new int[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            list[count++] = Integer.parseInt(sc.next());
        }
        int res = solution(list, a, b);
        System.out.println(res);
        sc.close();
    }
}
