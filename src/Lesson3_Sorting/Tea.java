package Lesson3_Sorting;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Tea {
    private static float solution(List<Integer> cups, int n, int maxTea){
        Collections.sort(cups);
        List<Integer> cupsForGirls = new ArrayList<>();
        List<Integer> cupsForBoys = new ArrayList<>();
        cupsForGirls = cups.subList(0, n);
        cupsForBoys = cups.subList(n, cups.size());

        float x = 0; // tổng lượng nước tối đa tính bằng ml
        int minCupGirls = cupsForGirls.get(0);
        int minCupBoys = cupsForBoys.get(0);
        x = minCupBoys < 2 * minCupGirls ? (float) minCupBoys/2 : minCupGirls;
        x = Math.min(x, ((float) maxTea/ (3*n)));
        return x * 3 * n;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 1st input line
        int n = Integer.parseInt(sc.next()); // n is number of boys/girls. 2n people in total.
        int maxTea = Integer.parseInt(sc.next()); // teapot cap

        // 2nd input line
        List<Integer> cups = new ArrayList<>();
        for (int i = 0; i < 2*n; i++) {
            cups.add(Integer.parseInt(sc.next()));
        }
        System.out.println(solution(cups, n, maxTea));
        sc.close();
    }

}
