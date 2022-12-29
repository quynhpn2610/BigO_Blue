package Lesson3_Sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class SortTheArray {
    public static void solution(List<Integer> list){
        boolean alreadySorted = true;
        // check if list is already ascending
        for (int i = 0; i < list.size()-1; i++) {
            if(list.get(i) > list.get(i+1)){
                alreadySorted = false;
                break;
            }
        }

        if (alreadySorted){
            System.out.println("yes");
            System.out.println(1 + " " + 1);
            return;
        }

        // if list is not ascending
        List<Integer> subListToSort = new ArrayList<>();
        int firstPtr = 0;
        int secondPtr = 1;
        int anchor = 0;

        // move firstPtr one step
        while(firstPtr < list.size()-1){
            if(list.get(firstPtr) < list.get(secondPtr)){
                firstPtr++;
                secondPtr++;
            }
            // when list.get(firstPtr) > list.get(secondPtr)
            else{
                anchor = firstPtr + 1;
                subListToSort.add(list.get(firstPtr++));
                subListToSort.add(list.get(secondPtr));
                while (list.get(firstPtr) > list.get(secondPtr)){
                    subListToSort.add(list.get(secondPtr));
                    firstPtr++;
                    secondPtr++;
                    if (secondPtr == list.size()){
                        break;
                    }
                }
                break;
            }
        }

        Collections.sort(subListToSort);
        int count = 0;
        for (int i = anchor - 1; i < secondPtr; i++) {
            list.set(i, subListToSort.get(count++));
        }

        boolean isSorted = true;
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) > list.get(i + 1)) {
                isSorted = false;
                break;
            }
        }
        if (isSorted) {
            System.out.println("yes");
            System.out.print(anchor + " " + secondPtr);
        } else {
            System.out.println("no");
        }

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        int n = Integer.parseInt(sc.next());
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(sc.next()));
        }
        solution(list);
        sc.close();
    }
}
