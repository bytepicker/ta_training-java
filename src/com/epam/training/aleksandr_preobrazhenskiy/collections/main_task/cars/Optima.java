package com.epam.training.aleksandr_preobrazhenskiy.collections.main_task.cars;

public class Optima extends Car{

    public Optima(int cost, double consumption, int speed) {
        super(cost, consumption, speed);
        this.comfort = ComfortLevel.PLUS;
    }
}
