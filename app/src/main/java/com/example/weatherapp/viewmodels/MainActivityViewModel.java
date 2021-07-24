package com.example.weatherapp.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.weatherapp.models.HourlyWeather.Hourly;
import com.example.weatherapp.repositories.WeatherRepository;

import java.util.List;

public class MainActivityViewModel extends AndroidViewModel {

    private LiveData<List<Hourly>> mutableLiveData;
    private WeatherRepository weatherRepository;


    public MainActivityViewModel(Application application) {
        super(application);
        weatherRepository = new WeatherRepository(application);
        mutableLiveData = weatherRepository.getAllData();
    }

    public LiveData<List<Hourly>> getList(){
        if(mutableLiveData!=null)
            return mutableLiveData;
        else
            return new MutableLiveData<>();
    }

    public void insert(List<String> list){

    }

}
