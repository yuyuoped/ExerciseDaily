package com.yuyuoped;

public class PerfectNumber {
    public static void main(String[] args) {
        for (int i = 0; i < 10000000; i++) {
            boolean isPrime = true;
            for (int j = 2; j < Math.sqrt(i) + 1; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                System.out.print(i + ", ");
            }
        }
    }

}

class Solution10 {
    /**
     * @param num: an integer
     * @return: returns true when it is a perfect number and false when it is not
     */
    public boolean checkPerfectNumber(int num) {
        int sum = 0;
        for (int i = 1; i < num; i++) {
            if (num % i == 0) {
                sum += i;
            }
        }
        return num == sum;
    }
}
