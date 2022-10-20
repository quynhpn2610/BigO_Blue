package Lesson1_DynamicArrays_String;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SuffixStructures {
    private static Map<Character, Integer> countFreq(String s){
        Map<Character, Integer> hashMap = new HashMap<>();
        for (Character c: s.toCharArray()){
            if(hashMap.containsKey(c)){
                hashMap.put(c, hashMap.get(c)+1);
            }
            else{
                hashMap.put(c, 1);
            }
        }
        for (char c = 'a'; c <= 'z'; c++){
            if (!hashMap.containsKey(c)){
                hashMap.put(c, 0);
            }
        }
        return hashMap;
    }

    private static String solution (String s1, String s2){
        Map<Character, Integer> map1 = countFreq(s1);
        Map<Character, Integer> map2 = countFreq(s2);
        int count = 0;
        boolean isArray = true;
        for (Character c: s1.toCharArray()){
            if(!(map1.get(c).equals(map2.get(c)))){
                isArray = false;
            }
        }
        if (isArray) return "array";

        // s1 number of characters can only be equal or greater than s2. If any of s1 char freq < s2 --> can't be array or automaton
        for (Character c: s2.toCharArray()){
            if (map1.get(c) < map2.get(c)){
                return "need tree";
            }
        }

        boolean isBoth = false;
        int index = 0;
        for (int i = 0; i< s2.length(); i++) {
            String s1Clone = s1.substring(index); // both oth th h
            if (s1Clone.indexOf(s2.charAt(i)) != -1) {
                index = s1Clone.indexOf(s2.charAt(i)) + 1;
            }
            else {
                isBoth = true;
            }
        }


        if (isBoth) {
            return "both";
        }
        return "automaton";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        System.out.println(solution(s1, s2));
        sc.close();
    }
}
