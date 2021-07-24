
package com.example.weatherapp.models.HourlyWeather;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.annotation.NonNull;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
@Entity(tableName = "HourlyWeather")
public class Hourly {

    private int id;
    @Expose
    private Double clouds;
    @SerializedName("dew_point")
    private Double dewPoint;
    @Expose
    @PrimaryKey
    @NonNull
    private Double dt;
    @SerializedName("feels_like")
    private Double feelsLike;
    @Expose
    private Double humidity;
    @Expose
    private Double pop;
    @Expose
    private Double pressure;
    @Expose
    private Double temp;
    @Expose
    private Double uvi;
    @Expose
    private Double visibility;
    @SerializedName("wind_deg")
    private Double windDeg;
    @SerializedName("wind_gust")
    private Double windGust;
    @SerializedName("wind_speed")
    private Double windSpeed;

    public Double getClouds() {
        return clouds;
    }

    public Double getDewPoint() {
        return dewPoint;
    }

    public Double getDt() {
        return dt;
    }

    public Double getFeelsLike() {
        return feelsLike;
    }

    public Double getHumidity() {
        return humidity;
    }

    public Double getPop() {
        return pop;
    }

    public Double getPressure() {
        return pressure;
    }

    public Double getTemp() {
        return temp;
    }

    public Double getUvi() {
        return uvi;
    }

    public Double getVisibility() {
        return visibility;
    }


    public Double getWindDeg() {
        return windDeg;
    }

    public Double getWindGust() {
        return windGust;
    }

    public Double getWindSpeed() {
        return windSpeed;
    }

    public void setClouds(Double clouds) {
        this.clouds = clouds;
    }

    public void setDewPoint(Double dewPoint) {
        this.dewPoint = dewPoint;
    }

    public void setDt(Double dt) {
        this.dt = dt;
    }

    public void setFeelsLike(Double feelsLike) {
        this.feelsLike = feelsLike;
    }

    public void setHumidity(Double humidity) {
        this.humidity = humidity;
    }

    public void setPop(Double pop) {
        this.pop = pop;
    }

    public void setPressure(Double pressure) {
        this.pressure = pressure;
    }

    public void setTemp(Double temp) {
        this.temp = temp;
    }

    public void setUvi(Double uvi) {
        this.uvi = uvi;
    }

    public void setVisibility(Double visibility) {
        this.visibility = visibility;
    }

    public void setWindDeg(Double windDeg) {
        this.windDeg = windDeg;
    }

    public void setWindGust(Double windGust) {
        this.windGust = windGust;
    }

    public void setWindSpeed(Double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static class Builder {

        private Double clouds;
        private Double dewPoint;
        private Double dt;
        private Double feelsLike;
        private Double humidity;
        private Double pop;
        private Double pressure;
        private Double temp;
        private Double uvi;
        private Double visibility;
        private Double windDeg;
        private Double windGust;
        private Double windSpeed;

        public Hourly.Builder withClouds(Double clouds) {
            this.clouds = clouds;
            return this;
        }

        public Hourly.Builder withDewPoint(Double dewPoint) {
            this.dewPoint = dewPoint;
            return this;
        }

        public Hourly.Builder withDt(Double dt) {
            this.dt = dt;
            return this;
        }

        public Hourly.Builder withFeelsLike(Double feelsLike) {
            this.feelsLike = feelsLike;
            return this;
        }

        public Hourly.Builder withHumidity(Double humidity) {
            this.humidity = humidity;
            return this;
        }

        public Hourly.Builder withPop(Double pop) {
            this.pop = pop;
            return this;
        }

        public Hourly.Builder withPressure(Double pressure) {
            this.pressure = pressure;
            return this;
        }

        public Hourly.Builder withTemp(Double temp) {
            this.temp = temp;
            return this;
        }

        public Hourly.Builder withUvi(Double uvi) {
            this.uvi = uvi;
            return this;
        }

        public Hourly.Builder withVisibility(Double visibility) {
            this.visibility = visibility;
            return this;
        }

        public Hourly.Builder withWindDeg(Double windDeg) {
            this.windDeg = windDeg;
            return this;
        }

        public Hourly.Builder withWindGust(Double windGust) {
            this.windGust = windGust;
            return this;
        }

        public Hourly.Builder withWindSpeed(Double windSpeed) {
            this.windSpeed = windSpeed;
            return this;
        }

        public Hourly build() {
            Hourly hourly = new Hourly();
            hourly.clouds = clouds;
            hourly.dewPoint = dewPoint;
            hourly.dt = dt;
            hourly.feelsLike = feelsLike;
            hourly.humidity = humidity;
            hourly.pop = pop;
            hourly.pressure = pressure;
            hourly.temp = temp;
            hourly.uvi = uvi;
            hourly.visibility = visibility;
            hourly.windDeg = windDeg;
            hourly.windGust = windGust;
            hourly.windSpeed = windSpeed;
            return hourly;
        }

    }

}
