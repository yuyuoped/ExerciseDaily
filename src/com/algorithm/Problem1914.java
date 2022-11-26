package com.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Problem1914 {

    public static void main(String[] args) {
        List<Integer> ids = new ArrayList<>();
        int i = 4;
        while (i > 0) {
            ids.add(1);
            if (i <= 2) {
                ids.add(2);
            }
            if (i <= 1) {
                ids.add(3);
            }
            i--;
        }
        System.out.println(minItem(ids, 2));
    }

    public static int minItem(List<Integer> ids, int m) {
        // write your code here
        if (m > ids.size()) return 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (Integer id : ids) {
            if (map.containsKey(id)) {
                map.put(id, map.get(id) + 1);
            } else {
                map.put(id, 1);
            }
        }

        List<Integer> counts = map.values().stream().sorted().collect(Collectors.toList());
        for (int i = 0; i < counts.size(); i++) {
            if ((m = m - counts.get(i)) < 0)
                return counts.size() - i;
        }
        return 0;
    }
}
