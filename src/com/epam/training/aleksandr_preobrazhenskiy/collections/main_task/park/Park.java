package com.epam.training.aleksandr_preobrazhenskiy.collections.main_task.park;

import com.epam.training.aleksandr_preobrazhenskiy.collections.main_task.utils.*;
import com.epam.training.aleksandr_preobrazhenskiy.collections.main_task.cars.*;

import java.io.*;
import java.time.temporal.ValueRange;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Park implements Finding, Sorting, Serializable {

    private List<Car> carList;

    public Park(){
        carList = new ArrayList<Car>();
    }

    public void addCar(Car car){ carList.add(car); }

    public void saveToFile(String fileName) {
        try {
            FileOutputStream fos = new FileOutputStream(fileName);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(carList);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadFromFile(String fileName) {
        try {
            FileInputStream fis = new FileInputStream(fileName);
            ObjectInputStream ois = new ObjectInputStream(fis);
            carList = (List<Car>) ois.readObject();
            ois.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public int countTotalCost(){
        return carList.stream().mapToInt(Car::getCostInRoubles).sum();
    }

    @Override
    public List<Car> sortCarsByGasConsuptionPerHundredKilometers() {
        carList.sort(Comparator.comparing(Car::getConsumptionPerHundredKilometers));
        return carList;
    }

    @Override
    public List<Car> findCarsWithMaxSpeedInRange(ValueRange range) {
        return carList.stream().filter(o ->  o.getMaxSpeedKilometersPerHour() >= range.getMinimum()
                && o.getMaxSpeedKilometersPerHour() <= range.getMaximum()).collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "Park{" +
                "carList=\n" + carList.stream().map(Car::toString).collect(Collectors.joining("\n")) +
                '}';
    }
}
