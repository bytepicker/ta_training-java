package com.epam.training.aleksandr_preobrazhenskiy.fundamental.optional_task1;

import java.util.Comparator;
import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter numbers [space] separated: ");
        String[] input = sc.nextLine().split(" ");

        // find numbers with MAX and MIN length
        Arrays.sort(input, Comparator.comparingInt(String::length));
        String[] sorted = Arrays.stream(input).toArray(String[]::new);
        System.out.println(sorted[0] + " is element with MIN length = " +  sorted[0].length());
        System.out.println(sorted[sorted.length-1] + " is element with MAX length = " + sorted[sorted.length-1].length());

        // print ascending order
        for (String val: sorted) {
            System.out.printf("%s ", val);
        } System.out.println();

        // print descending order
        for(int i = sorted.length-1; i >= 0; i--){
            System.out.printf("%s ", sorted[i]);
        } System.out.println();

        // get average length
        double sum = 0.0;
        for (String val: sorted) {
            sum += val.length();
        }
        double avg = sum / (double)sorted.length;
        System.out.println("Average length = " + avg);

        // print elements with length > avg
        for (String val: sorted) {
            if(val.length() > avg)
                System.out.printf("%s with length = %d\n", val, val.length());
        }
    }
}
