package Lesson1_DynamicArrays_String;

import java.util.Scanner;

public class ArraysQuestion{
    private static boolean check
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = Integer.parseInt(sc.next());
        int n2 = Integer.parseInt(sc.next());
        int pickFromList1 = Integer.parseInt(sc.next());
        int pickFromList2 = Integer.parseInt(sc.next());
        int[] arr1 = new int[n1];
        int[] arr2 = new int[n2];

        for (int i = 0; i < n1; i++) {
            arr1[i] = Integer.parseInt(sc.next());
        }

        for (int i = 0; i < n2; i++) {
            arr2[i] = Integer.parseInt(sc.next());
        }
    }
}
