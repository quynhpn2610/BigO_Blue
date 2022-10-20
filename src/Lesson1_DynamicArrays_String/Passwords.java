package Lesson1_DynamicArrays_String;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Passwords {
    private static int[] calculateTime(int k, List<String> list, String pw){
        int[] res = new int[2];
        int numberOfStringsShorterThan = 0;
        for(String s: list){
            if (s.length() < pw.length()){
                numberOfStringsShorterThan ++;
            }
        }
        res[0] = ((numberOfStringsShorterThan/k) * 5) + (numberOfStringsShorterThan+1);

        int numberOfStringsEqualLength = numberOfStringsShorterThan;
        for(String s: list){
            if (s.length() == pw.length()){
                numberOfStringsEqualLength ++;
            }
        }

        numberOfStringsEqualLength += ((numberOfStringsEqualLength-1)/k) * 5;
        res[1] = numberOfStringsEqualLength;
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.next());
        int k = Integer.parseInt(sc.next());
        sc.nextLine();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            list.add(s);
        }
        String pw = sc.nextLine();

        int[] res = calculateTime(k, list, pw);

        // Print results
        for (int i: res) {
            System.out.print(i + " ");
        }
        sc.close();
    }
}
