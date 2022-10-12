package Lesson1;

import java.util.Scanner;

public class Berland {
    public static void berland(int n, int[] arr){
        // one button -> must be 1
        if (arr.length == 1){
            if (arr[0] == 1) System.out.println("YES");
            else System.out.println("NO");
            return;
        }

        // more than one button -> only one 0
        int count0 = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) count0++;
        }
        if (count0 == 1){
            System.out.println("YES");
        } else System.out.println("NO");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.next());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(sc.next());
        }
        berland(n, arr);
    }
}
