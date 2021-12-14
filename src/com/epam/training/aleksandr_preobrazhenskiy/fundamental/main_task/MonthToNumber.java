package com.epam.training.aleksandr_preobrazhenskiy.fundamental.main_task;

import java.util.*;
import static java.util.Map.entry;

public class MonthToNumber {
    static  Map<Integer, String> year = Map.ofEntries(
            entry(1, "January"),
            entry(2, "February"),
            entry(3, "March"),
            entry(4, "April"),
            entry(5, "May"),
            entry(6, "June"),
            entry(7, "Jule"),
            entry(8, "August"),
            entry(9, "September"),
            entry(10, "October"),
            entry(11, "November"),
            entry(12, "December")
    );

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter month: ");

        String input;
        try {
            int mm = Integer.parseInt(sc.nextLine());
            if (mm <1 || mm > 12){
                throw new IllegalArgumentException();
            }
            System.out.println(year.get(mm));

        } catch (NumberFormatException e) {
            System.out.println("Only integers");
        }

        catch (IllegalArgumentException e) {
            System.out.println("Month must be between 1 and 12");
        }
    }
}
