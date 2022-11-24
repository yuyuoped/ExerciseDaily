package com.algorithm;

import java.util.List;

public class Problem1916 {

    class Solution {
        /**
         * @param operation: A list of operations.
         * @return: The lamp has the longest liighting time.
         */
        public char longestLightingTime(List<List<Integer>> operation) {
            // write your code here
            char answer = (char) ('a' + operation.get(0).get(0));
            int maxTime = operation.get(0).get(1);

            for (int i = 1; i < operation.size(); i++) {
                int currentTime = operation.get(i).get(1) - operation.get(i - 1).get(1);
                if (currentTime > maxTime) {
                    answer = (char) ('a' + operation.get(i).get(0));
                    maxTime = currentTime;
                }
            }

            return answer;
        }
    }

}


