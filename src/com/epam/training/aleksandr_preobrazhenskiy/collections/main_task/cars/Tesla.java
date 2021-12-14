package com.epam.training.aleksandr_preobrazhenskiy.collections.main_task.cars;

public class Tesla extends Car {

    public Tesla(int cost, double consumption, int speed) {
        super(cost, consumption, speed);
        this.comfort = ComfortLevel.VIP;
    }
}
