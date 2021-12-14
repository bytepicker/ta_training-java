package com.epam.training.aleksandr_preobrazhenskiy.fundamental.main_task;

public class ArgsCalculator {
    public static void main(String[] args) {
        int sum = 0;
        long fact = 1;

        for (int i = 0; i < args.length; i++){
            sum += Integer.parseInt(args[i]);
            fact *= Integer.parseInt(args[i]);
        }

        System.out.println("Sum of args: " + sum);
        System.out.println("Factorial: " + fact);
    }
}
