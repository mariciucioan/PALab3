package com.mariciucioan.traveling.locations;

import com.mariciucioan.interfaces.Classifiable;
import com.mariciucioan.interfaces.Visitable;
import com.mariciucioan.util.Time;

import java.util.HashMap;
import java.util.Map;

public class Museum implements Visitable {
    private Map<Object, Integer> cost = new HashMap<>();

    private String name;
    private boolean visited;

    private Time openingTime;
    private Time closingTime;

    public Museum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean isVisited() {
        return visited;
    }

    @Override
    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    @Override
    public Map<Object, Integer> getCost() {
        return cost;
    }

    @Override
    public void addCost(Object to, int cost, boolean bothWays) {
        this.cost.put(to, cost);

        if(bothWays)
            ((Classifiable) to).getCost().put(this, cost);
    }

    @Override
    public void setCost(Map<Object, Integer> cost) {
        this.cost = cost;
    }

    @Override
    public Time getOpeningTime() {
        return this.openingTime;
    }

    @Override
    public void setOpeningTime(int h, int m) {
        this.openingTime = new Time(h,m);
    }

    @Override
    public Time getClosingTime() {
        return this.closingTime;
    }

    @Override
    public void setClosingTime(int h, int m) {
        this.closingTime = new Time(h,m);
    }

    @Override
    public String toString() {
        return name;
    }
}