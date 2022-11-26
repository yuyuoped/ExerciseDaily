package com.algorithm;

import java.math.BigDecimal;
import java.util.Scanner;

public class Problem2425 {
    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);

        double mountainHeight = scanner.nextDouble();
        double paperThickness = scanner.nextDouble();

        int count = 0;
        while (mountainHeight > paperThickness) {
            paperThickness *= 2;
            count ++;
        }

        System.out.println("Need to fold " + count + " times");
    }
}
