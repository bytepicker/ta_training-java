package com.epam.training.aleksandr_preobrazhenskiy.collections.main_task.cars;

public class Solaris extends Car{

    public Solaris(int cost, double consumption, int speed) {
        super(cost, consumption, speed);
        this.comfort = ComfortLevel.BASIC;
    }
}
