package com.yuyuoped;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;

public class IntersectionOfTwoArray {

    public static void main(String[] args) {

    }

    public int[] intersection(int[] nums1, int[] nums2) {
        // write your code here
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int[] result;
        int count;
        if (nums1.length < nums2.length) {
            result = new int[nums1.length];
        } else {
            result = new int[nums2.length];
        }
        count = getIntersection(nums1, nums2, result);
        return Arrays.copyOfRange(result, 0, count);
    }

    public int getIntersection(int[] one, int[] two, int[] result) {
        int count = 0;
        for (int i = 0; i < one.length;) {
            for (int j = 0; j < two.length;) {
                if (one[i] == two[j]) {
                    result[count++] = one[i];
                    i ++;
                    j ++;
                } else if (one[i] > two[j]) {
                    j ++;
                } else {
                    i ++;
                }
            }
        }
        return --count;
    }
}
