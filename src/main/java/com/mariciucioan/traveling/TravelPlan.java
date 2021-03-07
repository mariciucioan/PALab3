package com.mariciucioan.traveling;

import com.mariciucioan.interfaces.Classifiable;
import com.mariciucioan.interfaces.Visitable;
import com.mariciucioan.traveling.locations.City;

import java.util.List;

public class TravelPlan {
    private City city;
    private List<Object> preferences;

    private int minCost=Integer.MAX_VALUE;
    private int routeCost=0;
    private StringBuilder travelRoute = new StringBuilder();

    public TravelPlan(City city, List<Object> preferences) {
        this.city = city;
        this.preferences = preferences;
    }

    public void goFromTo(Object start, Object end) {
        if(!(start instanceof Classifiable))
            return;

        List<Object> locations = city.getLocations();
        Classifiable currentLocation = (Classifiable) start;

        if (currentLocation.getCost().containsKey(end)) {
            routeCost = ComputeDistance(currentLocation, (Classifiable) end);
            if (routeCost < minCost)
                minCost = routeCost;

            travelRoute.append(currentLocation.toString())
                    .append(" -> ")
                    .append(end.toString())
                    .append(": ")
                    .append(minCost);
        }

        currentLocation.getCost().forEach((k, v) -> {
            Classifiable obj = (Classifiable) k;

            if(obj.isVisited())
                return;

            obj.isVisited();
        });

        if(!travelRoute.toString().equals(""))
            System.out.println(travelRoute);
        else {
            System.out.println("Not found");
        }
    }

    public int ComputeDistance(Classifiable location1, Classifiable location2) {
        return location1.getCost().get(location2);
    }
}
