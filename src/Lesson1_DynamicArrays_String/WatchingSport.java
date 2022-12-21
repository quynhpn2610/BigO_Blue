package Lesson1_DynamicArrays_String;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WatchingSport{

    private static int watchingMinutes(List<Integer> list) {
        int result = 0;
        list.add(0, 0);
        list.add(91); // why?
        for (int i = 1; i < list.size(); i++) {
            int a = list.get(i);
            int b = list.get(i-1);
            if (a - b > 15) {
                result = list.get(i-1) + 15;
                return result;
            }
        }
        // 14 29 44 59 73 --> return 88
        return 90;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int minutes = sc.nextInt();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < minutes; i++) {
            list.add(sc.nextInt());
        }
        System.out.println(watchingMinutes(list));
        sc.close();
    }
}