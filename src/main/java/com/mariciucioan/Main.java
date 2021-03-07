package com.mariciucioan;

import com.mariciucioan.traveling.TravelPlan;
import com.mariciucioan.traveling.locations.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        City city = new City("Iasi");

        Hotel v1 = new Hotel("Hotel");
        Museum v2 = new Museum("Museum A");
        Museum v3 = new Museum("Museum B");
        Church v4 = new Church("Church A");
        Church v5 = new Church("Church B");
        Restaurant v6 = new Restaurant("Restaurant");

        v1.setOpeningTime(7, 30);
        v2.setOpeningTime(8, 30);
        v3.setOpeningTime(9, 30);
        v4.setOpeningTime(10, 30);
        v5.setOpeningTime(11, 30);
        v6.setOpeningTime(12, 30);

        List<Object> locations = new LinkedList<>(Arrays.asList(v1, v2, v3, v4, v5, v6));
        city.setLocations(locations);
        city.printLocations();
        System.out.println();
        System.out.println();
        System.out.println();
        city.printVisitableAndNotPayable();

        v1.addCost(v2, 10);
        v1.addCost(v3, 50);
        v2.addCost(v3, 20, true);
        v2.addCost(v4, 20);
        v2.addCost(v5, 10);
        v3.addCost(v4, 20);
        v4.addCost(v5, 30, true);
        v4.addCost(v6, 10);
        v5.addCost(v6, 20);

        System.out.println();
        System.out.println();
        System.out.println();

        TravelPlan travelPlan = new TravelPlan(city, null);
        travelPlan.goFromTo(v1, v2);
    }
}