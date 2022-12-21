package Lesson1_DynamicArrays_String;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BigSegment {
    private static int solution (List<List<Integer>> numbers) {
        int minNumber = numbers.get(0).get(0);
        int maxNumber = numbers.get(0).get(0);
        // loop thru the list of segments to find min and max --> create your own expected segment
        for (List<Integer> segment : numbers) {
            minNumber = Math.min(segment.get(0), minNumber);
            maxNumber = Math.max(segment.get(1), maxNumber);
        }
        int result = -1;

        // loop thru the list of segments for the segment that match the expectation earlier
        for (List<Integer> segment : numbers) {
            if (segment.get(0) == minNumber & segment.get(1) == maxNumber) {
                result = numbers.indexOf(segment) + 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = Integer.parseInt(sc.nextLine());
        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i < length; i++) {
            List<Integer> segments = new ArrayList<>();
            segments.add(Integer.parseInt(sc.next()));
            segments.add(Integer.parseInt(sc.next()));
            list.add(segments);
        }
        System.out.println(solution(list));
        sc.close();
    }
}
