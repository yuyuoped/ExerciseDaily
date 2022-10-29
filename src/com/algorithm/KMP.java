package com.algorithm;

/**
 * 字符串模式匹配
 */
public class KMP {

    public static void main(String[] args) {
        String source = "abcadbadd";
        String sub = "abca";
        int[] nextArray = getNextArray(sub);
        System.out.println(getKMPIndex(source, sub, nextArray));
    }

    public static int[] getNextArray(String sub) {
        int[] next = new int[sub.length()];
        for (int i = 0; i < sub.length(); i++) {
            if (i == 0) next[0] = 0;
            else {
                next[i] = getMaxLenOfCommonPreAndSuf(sub, i, next[i - 1]);
            }
        }
        return next;
    }

    public static int getMaxLenOfCommonPreAndSuf(String sub, int addressIndex, int preNext) {
        if (sub.charAt(preNext) == sub.charAt(addressIndex - 1)) return preNext + 1;
        return 0;
    }

    public static int getKMPIndex(String source, String sub, int[] next) {
        for (int i = 0, j = 0; i <= source.length();) {
            if (j == sub.length()) return i - j;
            if (source.charAt(i) == sub.charAt(j)) {
                i++;
                j++;
            } else {
                if (j - 1 < 0) i++;
                else {
                    j = next[j - 1];
                }
            }
        }
        return -1;
    }
}
