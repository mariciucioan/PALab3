package com.mariciucioan.interfaces;

import java.util.Map;

public interface Classifiable {

    boolean isVisited();
    void setVisited(boolean value);

    Map<Object, Integer> getCost();
    void setCost(Map<Object, Integer> cost);
    void addCost(Object to, int cost, boolean bothWays);

    default void addCost(Object to, int cost) {
        addCost(to, cost, false);
    }
}
