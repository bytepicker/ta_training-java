package com.epam.training.aleksandr_preobrazhenskiy.collections.main_task.cars;

import java.io.Serializable;

public abstract class Car implements Serializable {
    int costInRoubles;
    double consumptionPerHundredKilometers;
    double maxSpeedKilometersPerHour;
    protected ComfortLevel comfort;

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " {" +
                "costInRoubles=" + costInRoubles +
                ", consumptionPerHundredKilometers=" + consumptionPerHundredKilometers +
                ", maxSpeedKilometersPerHour=" + maxSpeedKilometersPerHour +
                ", comfort=" + comfort +
                '}';
    }

    public Car(int cost, double consumption, int speed) {
        this.costInRoubles = cost;
        this.consumptionPerHundredKilometers = consumption;
        this.maxSpeedKilometersPerHour = speed;
    }

    public int getCostInRoubles() {
        return costInRoubles;
    }

    public double getConsumptionPerHundredKilometers() {
        return consumptionPerHundredKilometers;
    }

    public double getMaxSpeedKilometersPerHour() {
        return maxSpeedKilometersPerHour;
    }
}
