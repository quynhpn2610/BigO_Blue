package Lesson1_DynamicArrays_String;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArraysQuestion{
    private static boolean checkIfPossible(List<Integer> nums1, List<Integer> nums2, int pickFromList1, int pickFromList2){
        List<Integer> subList1 = new ArrayList<>();
        for (int i = 0; i < pickFromList1; i++) {
            subList1.add(nums1.get(i));
        }
        List<Integer> subList2 = new ArrayList<>();
        int startIndex = nums2.size() - pickFromList2;
        for (int i = startIndex; i < nums2.size(); i++) {
            subList2.add(nums2.get(i));
        }
        return subList1.get(subList1.size()-1) < subList2.get(0);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        int nums1Size = Integer.parseInt(sc.next());
        int nums2Size = Integer.parseInt(sc.next());
        sc.nextLine();
        int pickFrom1 = Integer.parseInt(sc.next());
        int pickFrom2 = Integer.parseInt(sc.next());
        for (int i = 0; i < nums1Size;) {
            list1.add(Integer.parseInt(sc.next()));
            i++;
        }
        for (int i = 0; i < nums2Size; i++) {
            list2.add(Integer.parseInt(sc.next()));
        }
        if (checkIfPossible(list1, list2, pickFrom1, pickFrom2)) {
            System.out.println("YES");
        }
        else {
            System.out.println("NO");
        }
    }
}
