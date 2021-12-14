package com.epam.training.aleksandr_preobrazhenskiy.collections.main_task.utils;

import com.epam.training.aleksandr_preobrazhenskiy.collections.main_task.cars.Car;

import java.time.temporal.ValueRange;
import java.util.List;

public interface Finding {
    List<Car> findCarsWithMaxSpeedInRange(ValueRange range);
}
