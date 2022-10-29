package com.yuyuoped;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class SortArray {
    public static void main(String[] args) {
        String[] strArr = {"lint", "avai", "able", "code", "Lintcode"};

        Solution8 solution = new Solution8();
        solution.sortByLength(strArr);
    }
}

class Solution8 {

    public void sortByLength(String[] strArr) {

        // --- Write your code here ---
//        Arrays.sort(strArr, (s1, s2) -> s1.length() >= s2.length() ? 1  : -1);
//
//        for (String s : strArr) {
//            System.out.println(s);
//        }
//        Arrays.stream(strArr).sorted((s1, s2) -> s1.length() - s2.length()).forEach(System.out::println);

        Arrays.stream(strArr).sorted(Comparator.comparingInt(String::length)).forEach(System.out::println);
    }

}