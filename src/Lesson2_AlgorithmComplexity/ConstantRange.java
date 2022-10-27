package Lesson2_AlgorithmComplexity;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConstantRange{
    public static int findMaxLength(List<Integer> list){
        int prev = -1;
        int current = list.get(0);
        int next;
        int prevCount = 0;
        int currentCount = 1;

        // longest constant range length
        int longest = 1;

        for (int i = 1; i < list.size(); i++) {
            next = list.get(i);
            if (next == current){
                currentCount ++;
            } else if (next == prev) {
                prevCount += currentCount;
                prev = current;
                current = next;
                currentCount = 1;
            } else {
                longest = Math.max(longest, currentCount + prevCount);
                prev = current;
                prevCount = currentCount;
                current = next;
                currentCount = 1;
            }
        }
        return longest;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.next());
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(sc.next()));
        }
        System.out.println(findMaxLength(list));
        sc.close();
    }
}
