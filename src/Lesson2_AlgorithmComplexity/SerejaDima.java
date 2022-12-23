package Lesson2_AlgorithmComplexity;

import java.util.Scanner;

public class SerejaDima {
    private static int[] calcPoint(int[] cards){
        int[] points = new int[2];
        int player1Point = 0;
        int player2Point = 0;
        int left = 0;
        int right = cards.length-1;

        if (cards.length == 1){
            player1Point += cards[0];
            points[0] = player1Point;
            return points;
        }


        while (left < right){
            player1Point += Math.max(cards[left], cards[right]);
            if (cards[left] > cards[right]){
                left++;
            }
            else right--;

            player2Point += Math.max(cards[left], cards[right]);
            if (cards[left] > cards[right]){
                left++;
            }
            else right--;

            if (left == right && cards.length % 2 != 0){
                player1Point += cards[right];
            }
        }

        points[0] = player1Point;
        points[1] = player2Point;
        return points;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.next());
        int[] cards = new int[n];
        for (int i = 0; i < n; i++) {
            cards[i] = Integer.parseInt(sc.next());
        }

        int[] res = calcPoint(cards);
        for (int r:
             res) {
            System.out.print(r + " ");
        }
    }
}
