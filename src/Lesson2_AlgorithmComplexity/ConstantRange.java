package Lesson2_AlgorithmComplexity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class ConstantRange{
    public static int solution(List<Integer> list){
        int maxCanGo = 1;
        int firstPtr = 0;
        int secondPtr = 1;

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(list.get(firstPtr), 1);

        for (firstPtr = 0; firstPtr < list.size(); firstPtr++){
            while (secondPtr < list.size()){
                if (map.containsKey(list.get(secondPtr))){
                    map.put(list.get(secondPtr), map.get(list.get(secondPtr))+1);
                }
                else{
                    map.put(list.get(secondPtr), 1);
                }

                if (map.size() == 3){
                    map.remove(list.get(secondPtr));
                    break;
                }

                secondPtr++;
            }

            if (secondPtr - firstPtr > maxCanGo){
                maxCanGo = secondPtr - firstPtr;
            }

            if (map.get(list.get(firstPtr)) == 1){
                map.remove(list.get(firstPtr));
            }
            else{
                map.put(list.get(firstPtr), map.get(list.get(firstPtr))-1);
            }
        }
        return maxCanGo;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.next());
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(sc.next()));
        }
        System.out.println(solution(list));
        sc.close();
    }
}
