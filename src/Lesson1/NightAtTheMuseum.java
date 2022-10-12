package Lesson1;

import java.util.Scanner;

public class NightAtTheMuseum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        char[] sArr = s.toCharArray();
        int ans = 0;

        int diff = Math.abs('a'-sArr[0]);
        if (diff > 13) ans += 26 - diff;
        else ans += diff;

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
