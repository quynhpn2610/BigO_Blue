package Lesson1_DynamicArrays_String;

import java.util.Scanner;

// s < t
// check if there is a string x that is between s and t that s < x < t
//

public class Vitaly_StringComparison {
    public static String compareString (String s, String t){
        // s is smaller than t lexicographically
        for (int i = s.length()-1; i >= 0; i--) {
            if (s.charAt(i) == 'z'){
                // if any char of s = z, replace it with a because there is nothing after z.
                s = s.substring(0, i) + 'a' + s.substring(i+1);
            }
            else {
                s = s.substring(0, i) + (char)(s.charAt(i)+1) + s.substring(i+1);
                break;
            }
        }

        if (s.compareTo(t) < 0){
            return s;
        }
        else return "No such string";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String t = sc.nextLine();
        System.out.println(compareString(s, t));
    }
}
