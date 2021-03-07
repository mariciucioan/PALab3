package com.mariciucioan.util;

public class Time {
    int hour;
    int minute;

    public Time(int hour, int minute) {
        this.hour = hour;
        this.minute = minute;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    @Override
    public String toString() {
        return (hour<10 ? "0" : "") + hour + ":" + (minute < 10 ? "0" : "") + minute;
    }
}
