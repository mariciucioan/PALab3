package com.mariciucioan.interfaces;

import com.mariciucioan.util.Duration;
import com.mariciucioan.util.Time;

import java.util.Map;

public interface Visitable extends Classifiable {
    Time getOpeningTime();
    Time getClosingTime();

    void setOpeningTime(int h, int m);
    void setClosingTime(int h, int m);

    default void setDefaultOpeningTime() {
        setOpeningTime(9, 30);
    }

    default void setDefaultClosingTime() {
        setClosingTime(20, 0);
    }

    static Duration getVisitingDuration(Object location) {
        if(!(location instanceof Visitable))
            return null;

        Time locClosingTime = ((Visitable) location).getClosingTime();
        Time locOpeningTime = ((Visitable) location).getOpeningTime();

        int hours = locClosingTime.getHour() - locOpeningTime.getHour();
        int minutes = locClosingTime.getMinute() - locOpeningTime.getMinute();

        return new Duration(hours, minutes);
    }
}
