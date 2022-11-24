package com.algorithm;

import java.util.ArrayList;

public class Problem2506 {


    class Solution {
        /**
         * @param s: A string with lowercase letters and parentheses
         * @return: A string which has been removed invalid parentheses
         */
        public String removeParentheses(String s) {
            // write your code here.
            if ("".equals(s)) return s;
            ArrayList<Integer> indexTemp = new ArrayList<>();
            ArrayList<Integer> indexToDel = new ArrayList<>();
            StringBuilder result = new StringBuilder();
            char[] chars = s.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if ('(' == chars[i]) {
                    indexTemp.add(i);
                } else if (')' == chars[i]) {
                    if (indexTemp.size() > 0) {
                        indexTemp.remove(indexTemp.size() - 1);
                    } else {
                        indexToDel.add(i);
                    }
                }
            }
            for (int i = 0; i < chars.length; i++) {
                if (!(indexTemp.contains(i) || indexToDel.contains(i))) {
                    result.append(chars[i]);
                }
            }

            return result.toString();
        }
    }
}
