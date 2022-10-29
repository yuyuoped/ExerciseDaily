package com.yuyuoped;

import java.util.Arrays;

public class MountainArray {


    public int peakIndexInMountainArray(int[] a) {
        // Write your code here

        return binarySearch(a, 0, a.length - 1);

    }

    public int binarySearch(int[] a, int begin, int end) {
        int mid = (begin + end) / 2;

        if (a[mid] > a[mid - 1] && a[mid] > a[mid + 1]) {
            return mid;
        } else if (a[mid] > a[mid - 1] && a[mid] < a[mid + 1]) {
            return binarySearch(a, mid + 1, end);
        } else {
            return binarySearch(a, begin, mid - 1);
        }
    }
}
