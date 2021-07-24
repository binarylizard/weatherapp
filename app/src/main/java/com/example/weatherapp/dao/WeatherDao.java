package com.example.weatherapp.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.weatherapp.models.HourlyWeather.Hourly;

import java.util.List;

@Dao
public interface WeatherDao {

    @Insert
    void insert(List<Hourly> weatherItems);

    @Query("select * from HourlyWeather")
    LiveData<List<Hourly>> getAllData();

}
