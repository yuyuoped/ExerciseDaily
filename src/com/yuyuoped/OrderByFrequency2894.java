package com.yuyuoped;

import java.util.*;

public class OrderByFrequency2894 {

    public Map<Integer, List<Integer>> orderByFrequency(int[] nums) {
        // write your code here
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            if (count.containsKey(num)) {
                count.put(num, count.get(num) + 1);
            } else {
                count.put(num, 1);
            }
        }
        Map<Integer, List<Integer>> result = new TreeMap<>(Comparator.comparingInt(a -> -a));

        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            if (result.containsKey(entry.getValue())) {
                result.get(entry.getValue()).add(entry.getKey());
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(entry.getKey());
                result.put(entry.getValue(), list);
            }
        }

        for (Map.Entry<Integer, List<Integer>> entry : result.entrySet()) {
            entry.getValue().sort(Comparator.comparingInt(a -> a));
        }


        return result;
    }
}
