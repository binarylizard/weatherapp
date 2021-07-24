package com.example.weatherapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.RecyclerView;

import com.example.weatherapp.R;
import com.example.weatherapp.databinding.ItemWeatherBinding;
import com.example.weatherapp.models.HourlyWeather.Hourly;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.List;

public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.Viewholder> {

    private Context context;
    private List<Hourly> hourlyWeatherList;
    private ItemWeatherBinding binding;

    public WeatherAdapter(Context context, List<Hourly> liveData){
        this.context = context;
        this.hourlyWeatherList = liveData;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        binding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.item_weather
        ,parent, false);
        return new Viewholder(binding);
    }

    @Override
    public void onBindViewHolder(WeatherAdapter.Viewholder holder, int position) {
        Hourly hourlyWeather = hourlyWeatherList.get(position);
        binding.tvHumidityVal.setText(hourlyWeather.getHumidity() + "%");
        binding.tvTempValue.setText(hourlyWeather.getTemp() + " °C");
        binding.tvWindVal.setText(hourlyWeather.getWindSpeed() + " metre/sec");
//
//        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
//            Instant instant = Instant.ofEpochSecond(hourlyWeather.getDt().longValue());
//            Date date = Date.from(instant);
//            binding.tvHour.setText("Weather Today at " +date.getHours()+":" + date.getMinutes());
//        } else {
// convert seconds to milliseconds
            Date date = new java.util.Date(hourlyWeather.getDt().longValue()*1000L);
// the format of your date
            SimpleDateFormat sdf = new java.text.SimpleDateFormat("hh:mm:ss aa");
// give a timezone reference for formatting (see comment at the bottom)
//            sdf.setTimeZone(java.util.TimeZone.getTimeZone("GMT-4"));
            String formattedDate = sdf.format(date);
            binding.tvHour.setText("Weather Today at " + formattedDate);
//        }
    }

    public void getList(List<Hourly> list){
        this.hourlyWeatherList = list;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if(hourlyWeatherList!=null)
            return hourlyWeatherList.size();
        else
            return 0;
    }

    public class Viewholder extends RecyclerView.ViewHolder {

        public Viewholder(ItemWeatherBinding binding) {
            super(binding.getRoot());
        }
    }
}
