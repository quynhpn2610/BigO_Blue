package Lesson1_DynamicArrays_String;

import java.util.Scanner;

public class NightAtTheMuseum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        char[] sArr = s.toCharArray();
        int ans = 0;

        // Check difference from 'a' to first char of the string
        int diff = Math.abs('a'-sArr[0]);
        if (diff > 13) ans += 26 - diff; // if diff is larger than half of the circle, should go the other way round
        else ans += diff;

        // Check from first char to the rest
        for (int i = 0; i < sArr.length-1; i++) {
            diff = Math.abs(sArr[i+1] - sArr[i]);
            if (diff > 13){
                ans += 26 - diff;
            }
            else ans += diff;
        }

        System.out.println(ans);
        sc.close();
    }

}
