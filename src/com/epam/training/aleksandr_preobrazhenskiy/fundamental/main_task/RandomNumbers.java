package com.epam.training.aleksandr_preobrazhenskiy.fundamental.main_task;

import java.util.*;

public class RandomNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number: ");
        int num = sc.nextInt();

        Random rand = new Random();

        // fill an array with random numbers
        int[] rNumbers = new int[num];
        for(int i=0; i<num; i++){
            rNumbers[i] = rand.nextInt(Integer.MAX_VALUE);
        }

        // print with newline if odd
        for(int i=0; i<num; i++){
            String format = rNumbers[i]%2 == 0 ? "%d%n" : "%d ";
            System.out.printf(format, rNumbers[i]);
            }
        }
    }