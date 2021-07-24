package com.example.weatherapp.repositories;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.weatherapp.adapters.WeatherAdapter;
import com.example.weatherapp.dao.WeatherDao;
import com.example.weatherapp.databases.WeatherDatabase;
import com.example.weatherapp.models.HourlyWeather.Hourly;

import java.util.List;

public class WeatherRepository {

    private static WeatherAdapter instance;
    private WeatherDatabase weatherDatabase;
    private LiveData<List<Hourly>> listMutableLiveData;

    public WeatherRepository(Application application){
        weatherDatabase = WeatherDatabase.getInstance(application);
        listMutableLiveData = weatherDatabase.weatherDao().getAllData();
    }

    public void insert(List<Hourly> list){
        new InsertAsyncTask(weatherDatabase).execute(list);
    }

    public LiveData<List<Hourly>> getAllData(){
        return listMutableLiveData;
    }

    class InsertAsyncTask extends AsyncTask<List<Hourly>, Void, Void>{

        private WeatherDao weatherDao;

        public InsertAsyncTask(WeatherDatabase weatherDatabase) {
            weatherDao = weatherDatabase.weatherDao();
        }

        @Override
        protected Void doInBackground(List<Hourly>... lists) {
            try {
                weatherDao.insert(lists[0]);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }
    }

}
