package Lesson2_AlgorithmComplexity;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AliceBob {
    private static int[] solution(List<Integer> list){
        if(list.size() == 1){
            return new int[]{1, 0};
        }
        if(list.size() == 0){
            return new int[]{0, 0};
        }

        int[] result = new int[2];
        int aliceCount = 0;
        int alicePointer = 0;
        int aliceTime = list.get(alicePointer);

        int bobPointer = list.size()-1;
        int bobCount = 0;
        int bobTime = list.get(bobPointer);

        while(alicePointer <= bobPointer){
            aliceTime --;
            bobTime --;
            if(alicePointer == bobPointer & (aliceTime == 0 && bobTime == 0)){
                aliceCount ++;
                break;
            }
            if(aliceTime == 0){
                alicePointer++;
                aliceCount++;
                aliceTime = list.get(alicePointer);
            }
            if(bobTime == 0){
                bobPointer--;
                bobCount++;
                bobTime = list.get(bobPointer);
            }
        }

        result[0] = aliceCount;
        result[1] = bobCount;
        return result;

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.next());
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i ++) {
            list.add(Integer.parseInt(sc.next()));
        }
        int[] result = solution(list);
        StringBuilder s = new StringBuilder();
        for (int i : result) {
            s.append(i).append(" ");
        }
        s = new StringBuilder(s.substring(0, s.length() - 1));
        System.out.println(s);
        sc.close();
    }
}
