package Lesson2_AlgorithmComplexity;

public class TwoPointersDraft {
    public static void main(String[] args) {
        int[] A = {-3, -2, 0, 1, 2, 5, 6, 7};
        for (int i = 0; i < A.length; i++) {
            for (int j = A.length-1; j > i; j--) {
                if (i != j && A[i] + A[j] == 0){
                    System.out.print("true");
                }
                if (A[i] + A[j] < 0){
                    break;
                }
            }
        }
        System.out.print("0");

//        for (int i = 0; i < A.length-1; i++) {
//            for (int j = i+1; j < A.length; j++) {
//
//            }
//        }
    }
}
