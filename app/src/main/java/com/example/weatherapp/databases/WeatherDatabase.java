package com.example.weatherapp.databases;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.weatherapp.dao.WeatherDao;
import com.example.weatherapp.models.HourlyWeather.Hourly;

@Database(entities = Hourly.class, version = 1)
public abstract class WeatherDatabase extends RoomDatabase {

    private static final String DATABASE_NAME = "Weather";
    public abstract WeatherDao weatherDao();

    public static volatile WeatherDatabase instance;

    public static WeatherDatabase getInstance(Context context){
        if(instance == null){
            synchronized (WeatherDatabase.class){
                if(instance == null){
                    instance = Room.databaseBuilder(context, WeatherDatabase.class, DATABASE_NAME)
                            .allowMainThreadQueries()
                            .build();
                }
            }
        }
        return instance;
    }
//
//    Callback callback = new Callback() {
//        @Override
//        public void onCreate(SupportSQLiteDatabase db) {
//            super.onCreate(db);
//        }
//    };
//
//    static class PopulateAsyncTask extends AsyncTask<Void, Void, Void>{
//
//        private WeatherDao weatherDao;
//        PopulateAsyncTask(WeatherDatabase weatherDatabase){
//            weatherDao = weatherDatabase.weatherDao();
//        }
//
//        @Override
//        protected Void doInBackground(Void... voids) {
////            weatherDao.d
//            return null;
//        }
//    }

}
