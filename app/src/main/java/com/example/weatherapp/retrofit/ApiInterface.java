package com.example.weatherapp.retrofit;

import com.example.weatherapp.models.HourlyWeather.OpenWeatherResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("onecall")
    Call<OpenWeatherResponse> getHourlyWeather(@Query("lat") double lat,@Query("lon") double longitude, @Query("appid") String appId, @Query("units") String units);

}
