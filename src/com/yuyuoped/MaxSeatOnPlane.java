package com.yuyuoped;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MaxSeatOnPlane {

    public static void main(String[] args) {
        System.out.println(Solution4.solution(10,
                "1I 1G 1C 1F 2B 2H 2C 2A 3G 3J 3C 3I 4H 4D 4C 4B 5J 5F 5C 5G 6D 6A 6C 6H 7F 7I 7C 7J 8A 8B 8C 8D 9I 9G 9C 9F 10B 10H 10C 10A"));
    }

}

class Solution4 {
    /**
     * @param n: the number of rows
     * @param s: a list of reserved seats
     * @return: An integer
     */
    public static int solution(int n, String s) {
        // Write your code here.
        char charA = 'A';
        HashMap<Character, Integer> seatNumMap = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            seatNumMap.put((char) (charA + i), i);
        }

        Map<Integer, List<String>> classifyUsedSeat = new HashMap<>();
        if (s.length() > 0) {
            String[] seats = s.split(" ");
            classifyUsedSeat = Arrays.stream(seats).collect(Collectors.groupingBy(s1 ->
                    Integer.valueOf(s1.substring(0, s1.length() - 1))
            ));
        }

        int MaxSeatForAFamily = 0;
        int[] seatEveryCol = new int[10];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(seatEveryCol, 0);
            List<String> colUsedSeats = classifyUsedSeat.get(i);

            if (colUsedSeats == null || colUsedSeats.size() == 0) {
                MaxSeatForAFamily += 2;
                continue;
            }

            for (String colUsedSeat : colUsedSeats) {
                seatEveryCol[seatNumMap.get(colUsedSeat.charAt(colUsedSeat.length() - 1))] = 1;
            }

            boolean addTwo = true;
            boolean addOneFirst = false;
            boolean addOneSecond = false;
            int countFirst = 0;
            int countSecond = 0;
            for (int j = 1; j <= 8; j++) {
                if (seatEveryCol[j] == 1) addTwo = false;

                if (j == 5) countFirst = 0;
                if (j == 3 || j == 7) countSecond = 0;
                if (seatEveryCol[j] == 0) {
                    countFirst++;
                    countSecond++;
                }
                if (countFirst == 4) addOneFirst = true;
                if (countSecond == 4) addOneSecond = true;
            }

            if (addTwo) {
                MaxSeatForAFamily += 2;
            } else if (addOneFirst) {
                MaxSeatForAFamily++;
            } else if (addOneSecond) {
                MaxSeatForAFamily++;
            }
        }

        return MaxSeatForAFamily;
    }
}
