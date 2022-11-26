package com.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem1911 {
    public int maxDistance(int[][] grid) {
        // Write your code here.
        List<Node> oceans = new ArrayList<>();
        List<Node> lands = new ArrayList<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) lands.add(new Node(i, j));
                if (grid[i][j] == 0) oceans.add(new Node(i, j));
            }
        }
        if (oceans.size() == 0 || lands.size() == 0) return -1;

        int[] distance = new int[oceans.size()];

        for (int i = 0; i < distance.length; i++) {
            int minDistance = Integer.MAX_VALUE;
            for (int j = 0; j < lands.size(); j++) {
                int currentDistance = oceans.get(i).getDistance(lands.get(j));
                if (minDistance > currentDistance) {
                    minDistance = currentDistance;
                }
            }
            distance[i] = minDistance;
        }
        Arrays.sort(distance);
        return distance[distance.length - 1];
    }

    class Node {
        int x;
        int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getDistance(Node other) {
            return Math.abs(this.x - other.x) + Math.abs(this.y - other.y);
        }
    }
}
