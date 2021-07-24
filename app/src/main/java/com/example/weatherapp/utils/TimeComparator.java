package com.example.weatherapp.utils;

import com.example.weatherapp.models.HourlyWeather.Hourly;

import java.util.Comparator;

public class TimeComparator implements Comparator<Hourly> {
    @Override
    public int compare(Hourly o1, Hourly o2) {
        return o1.getDt().compareTo(o2.getDt());
    }

    @Override
    public boolean equals(Object obj) {
        return false;
    }
}
