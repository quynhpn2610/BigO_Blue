package Lesson3_Sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class EightPointSets {
    private static String solution(List<List<Integer>> points){
        List<Integer> Xs = new ArrayList<>();
        List<Integer> Ys = new ArrayList<>();

        // Add x and y to the Xs and Ys list
        for (List<Integer> point: points) {
            if (!Xs.contains(point.get(0))){
                Xs.add(point.get(0));
            }
            if (!Ys.contains(point.get(1))) {
                Ys.add(point.get(1));
            }
        }

        // Check if there are enough 3 x's and 3 y's in each list
        // If not -> cannot generate 8 points -> ugly
        if(Xs.size() != 3 | Ys.size() != 3){
            return "ugly";
        }

        // sort the two lists
        Collections.sort(Xs);
        Collections.sort(Ys);

        // Create a list of 9-1=8 points from x's and y's
        List<List<Integer>> generatedPoints = new ArrayList<>();
        for (int x: Xs){
            for (int y: Ys){
                if (Xs.indexOf(x) == 1 && Ys.indexOf(y) == 1){
                    continue; // because it's the average of these 9 points
                }
                else {
                    List<Integer> point = new ArrayList<>();
                    point.add(x);
                    point.add(y);
                    generatedPoints.add(point);
                }
            }
        }

        // Compare given and generated list

        // Need to sort the given list first
        Collections.sort(points, (o1, o2) -> {
            if(!o1.get(0).equals(o2.get(0))){
                return o1.get(0).compareTo(o2.get(0));
            }
            return o1.get(1).compareTo(o2.get(1));
        });

        for (int i = 0; i < points.size(); i++) {
            if (!points.get(i).get(0).equals(generatedPoints.get(i).get(0)) | !points.get(i).get(1).equals(generatedPoints.get(i).get(1))){
                return "ugly";
            }
        }
        return "respectable";
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<List<Integer>> points = new ArrayList<>();
        int count = 0;
        while (count < 8) {
            List<Integer> newPoint = new ArrayList<>();
            newPoint.add(Integer.parseInt(sc.next()));
            newPoint.add(Integer.parseInt(sc.next()));
            points.add(newPoint);
            count++;
        }
        System.out.println(solution(points));
        sc.close();
    }
}
