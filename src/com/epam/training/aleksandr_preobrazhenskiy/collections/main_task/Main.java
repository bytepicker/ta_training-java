package com.epam.training.aleksandr_preobrazhenskiy.collections.main_task;

import com.epam.training.aleksandr_preobrazhenskiy.collections.main_task.cars.*;
import com.epam.training.aleksandr_preobrazhenskiy.collections.main_task.park.Park;
import com.epam.training.aleksandr_preobrazhenskiy.collections.main_task.utils.UserMenu;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Park taxi = new Park();
        Scanner input = new Scanner(System.in);
        UserMenu menu = new UserMenu();

        // creating database, same can be loaded from taxipark.db
        taxi.addCar(new Solaris(600000, 8.2, 120));
        taxi.addCar(new Solaris(610000, 8.1, 110));
        taxi.addCar(new Solaris(620000, 8.0, 110));
        taxi.addCar(new Solaris(630000, 8.0, 130));
        taxi.addCar(new Solaris(640000, 8.4, 140));
        taxi.addCar(new Solaris(650000, 8.3, 130));
        taxi.addCar(new Solaris(660000, 8.5, 130));
        taxi.addCar(new Optima(1350000, 7.5, 170));
        taxi.addCar(new Optima(1400000, 7.4, 160));
        taxi.addCar(new Optima(1450000, 7.5, 150));
        taxi.addCar(new Optima(1500000, 7.3, 160));
        taxi.addCar(new Tesla(2500000, 0.0, 200));
        taxi.addCar(new Tesla(2600000, 0.0, 220));
        taxi.addCar(new Tesla(2700000, 0.0, 230));
        taxi.addCar(new Tesla(2800000, 0.0, 250));

        boolean pressedExit = false;

        do {
            switch (menu.mainInput()){
                case 1:
                    System.out.println(taxi);
                    break;
                case 2: ;
                    taxi.sortCarsByGasConsuptionPerHundredKilometers();
                    break;
                case 3:
                    System.out.println(taxi.findCarsWithMaxSpeedInRange(menu.getRange()));
                    break;
                case 4:
                    System.out.println("Enter filename: ");
                    taxi.loadFromFile(input.nextLine());
                    break;
                case 5:
                    System.out.println("Total car cost: " + taxi.countTotalCost());
                    break;
                case 6:
                    pressedExit = true;
                    break;
                default:
                    break;
            }
        } while (!pressedExit);
    }
}
