package com.mariciucioan.traveling.locations;

import com.mariciucioan.interfaces.Classifiable;
import com.mariciucioan.interfaces.Payable;
import com.mariciucioan.interfaces.Visitable;

import java.util.LinkedList;
import java.util.List;

public class City {

    private List<Object> locations = new LinkedList<Object>();
    private String name;

    public City(String name) {
        this.name = name;
    }

    public List<Object> getLocations() {
        return locations;
    }

    public void setLocations(List<Object> locations) {
        this.locations = locations;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void printLocations() {
        locations.stream()
                .sorted((o1, o2) -> o1.toString().compareTo(o2.toString()))
                .forEach(System.out::println);
    }

    public void printVisitableAndNotPayable() {
        locations.stream()
                .filter(obj -> obj instanceof Visitable && !(obj instanceof Payable))
                .sorted((o1, o2) -> {
                    int h1 = (int) ((Visitable) o1).getOpeningTime().getHour();
                    int h2 = (int) ((Visitable) o2).getOpeningTime().getHour();

                    int m1 = (int) ((Visitable) o1).getOpeningTime().getMinute();
                    int m2 = (int) ((Visitable) o2).getOpeningTime().getMinute();

                    if(h1!=h2)
                        return Integer.compare(h1,h2);

                    return Integer.compare(m1, m2);
                })
                .forEach(System.out::println);
    }
}
