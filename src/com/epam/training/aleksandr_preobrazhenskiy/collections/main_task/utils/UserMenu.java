package com.epam.training.aleksandr_preobrazhenskiy.collections.main_task.utils;

import java.time.temporal.ValueRange;
import java.util.Scanner;

public class UserMenu {
    private Scanner input;

    public UserMenu(){
        input = new Scanner(System.in);
    }

    public int mainInput() {
        System.out.println("-------------------------");
        System.out.println("1 - View taxi park data");
        System.out.println("2 - Sort cars by gasoline consumption");
        System.out.println("3 - Find cars by MAX speed range");
        System.out.println("4 - Load from file");
        System.out.println("5 - Count total park cost");
        System.out.println("6 - Quit");

        return input.nextInt();
    }

    public ValueRange getRange(){
        input.useDelimiter("\\D");
        System.out.println("Enter two values [space] separated:");
        long lowerBound = input.nextInt();
        long upperBound = input.nextInt();
        return ValueRange.of(lowerBound, upperBound);
    }
}
