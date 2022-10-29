package com.yuyuoped;

import java.util.ArrayList;

public class DistanceBetweenTwoWordInArray {

    /**
     * @param words: a list of words
     * @param word1: a string
     * @param word2: a string
     * @return: the shortest distance between word1 and word2 in the list
     */
    public static int shortestDistance(String[] words, String word1, String word2) {
        // Write your code here
        if (word1.equals(word2)) return 0;

        ArrayList<Integer> index1 = new ArrayList<>();
        ArrayList<Integer> index2 = new ArrayList<>();
        ArrayList<Integer> distance = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) index1.add(i);
            if (words[i].equals(word2)) index2.add(i);
        }

        for (Integer indexI : index1) {
            for (Integer indexJ : index2) {
                distance.add(Math.abs(indexI - indexJ));
            }
        }

        int minDistance = Integer.MAX_VALUE;

        for (Integer integer : distance) {
            if (integer < minDistance) {
                minDistance = integer;
            }
        }

        return minDistance;
    }
/* if (word1.equals(word2)) return 0;

    int index1 = -1;
    int index2 = -1;
    int minDistance = Integer.MAX_VALUE;

        for (int i = 0; i < words.length; i++) {
        if (words[i].equals(word1)) {
            index1 = i;
            minDistance = getMinDistance(index1, index2, minDistance);
        }
        if (words[i].equals(word2)) {
            index2 = i;
            minDistance = getMinDistance(index1, index2, minDistance);
        }
    }

        return minDistance;
}

    public int getMinDistance(int index1, int index2, int minDistance) {
        if (index1 != -1 && index2 != -1) {
            int distance = Math.abs(index1 - index2);
            return Math.min(distance, minDistance);
        }
        return minDistance;
    }*/
    public static void main(String[] args) {
        System.out.println(shortestDistance(new String[]{"practice", "makes", "perfect", "coding", "makes"},"coding","practice"));
    }

    public boolean isPalindrome(int num) {
        // write your code here
        String string = String.valueOf(num);

        int length = string.length();

        for (int i = 0; i < (length + 1) / 2; i++) {
            if (string.charAt(i) != string.charAt(length - i - 1)) {
                return false;
            }
        }
        return true;
    }

}
