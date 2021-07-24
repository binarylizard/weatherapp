package com.example.weatherapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.weatherapp.adapters.WeatherAdapter;
import com.example.weatherapp.databinding.ActivityMainBinding;
import com.example.weatherapp.models.HourlyWeather.Hourly;
import com.example.weatherapp.models.HourlyWeather.OpenWeatherResponse;
import com.example.weatherapp.repositories.WeatherRepository;
import com.example.weatherapp.retrofit.ApiClient;
import com.example.weatherapp.retrofit.ApiInterface;
import com.example.weatherapp.utils.TimeComparator;
import com.example.weatherapp.utils.Utility;
import com.example.weatherapp.viewmodels.MainActivityViewModel;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.weatherapp.utils.Utility.hideProgress;
import static com.example.weatherapp.utils.Utility.showProgress;

public class MainActivity extends AppCompatActivity {

    private static final int RC_LOCATION = 1;
    private static final int RC_PERM_SETTINGS = 2;
    private ActivityMainBinding binding;
    private MainActivityViewModel mainActivityViewModel;
    private WeatherAdapter weatherAdapter;
    private ApiInterface apiService;
    private static final String APP_ID = "852ee7df693a3f8977dbaad7e9bce46a";
    private WeatherRepository weatherRepository;
    private Double lat, lon;
    private LocationManager locationManager;
    private LocationListener locationListener;
    private Context context;
    private List<Hourly> newList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        context = this;

        newList = new ArrayList<>();

        weatherRepository = new WeatherRepository(getApplication());
        mainActivityViewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);
        apiService = ApiClient.getClient().create(ApiInterface.class);
        initRecyclerView();

        checkForLocationPermission();

        mainActivityViewModel.getList().observe(this, new Observer<List<Hourly>>() {
            @Override
            public void onChanged(List<Hourly> strings) {
                weatherAdapter.getList(strings);
            }
        });

    }

    private void checkForLocationPermission() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION},RC_LOCATION);
        } else {
            callLocation();
        }
    }

    private void callLocation() {
        final LocationManager manager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        if (!manager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            buildAlertMessageNoGps();
        } else {
            getMyCoodinates();
        }
    }

    private void getMyCoodinates() {
        FusedLocationProviderClient fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
        fusedLocationClient.getLastLocation()
                .addOnSuccessListener(this, new OnSuccessListener<Location>() {
                    @Override
                    public void onSuccess(Location location) {
                        // Got last known location. In some rare situations this can be null.
                        if (location != null) {
                            // Logic to handle location object
                            lat = location.getLatitude();
                            lon = location.getLongitude();
                            getHourlyWeather();

                        }
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(Exception e) {
                        Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                        e.printStackTrace();
                    }
                });
    }


    private void buildAlertMessageNoGps() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Your GPS seems to be disabled, do you want to enable it?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(final DialogInterface dialog, final int id) {
                        startActivityForResult(new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS), RC_PERM_SETTINGS);
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(final DialogInterface dialog, final int id) {
                        dialog.cancel();
                    }
                });
        final AlertDialog alert = builder.create();
        alert.show();
    }

    private void getHourlyWeather() {
        showProgress(context);
        apiService.getHourlyWeather(lat, lon, APP_ID, "metric").enqueue(new Callback<OpenWeatherResponse>() {
            @Override
            public void onResponse(Call<OpenWeatherResponse> call, Response<OpenWeatherResponse> response) {
                hideProgress();
                Utility.CURRENT_TEMPERATURE = String.valueOf(response.body().getCurrent().getTemp());
                weatherRepository.insert(response.body().getHourly());

            }

            @Override
            public void onFailure(Call<OpenWeatherResponse> call, Throwable t) {
                hideProgress();
                Toast.makeText(context, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initRecyclerView() {
        weatherAdapter = new WeatherAdapter(this, mainActivityViewModel.getList().getValue());
        binding.rvList.setLayoutManager(new LinearLayoutManager(this));
        binding.rvList.setAdapter(weatherAdapter);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == RC_PERM_SETTINGS){
            getMyCoodinates();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode == RC_LOCATION && grantResults[0] == PackageManager.PERMISSION_GRANTED){
            callLocation();
        }
    }

}