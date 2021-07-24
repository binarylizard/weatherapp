
package com.example.weatherapp.models.HourlyWeather;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class Current {

    @Expose
    private Double clouds;
    @SerializedName("dew_point")
    private Double dewPoint;
    @Expose
    private Double dt;
    @SerializedName("feels_like")
    private Double feelsLike;
    @Expose
    private Double humidity;
    @Expose
    private Double pressure;
    @Expose
    private Double sunrise;
    @Expose
    private Double sunset;
    @Expose
    private Double temp;
    @Expose
    private Double uvi;
    @Expose
    private Double visibility;
    @Expose
    private List<Weather> weather;
    @SerializedName("wind_deg")
    private Double windDeg;
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

    public Double getPressure() {
        return pressure;
    }

    public Double getSunrise() {
        return sunrise;
    }

    public Double getSunset() {
        return sunset;
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

    public List<Weather> getWeather() {
        return weather;
    }

    public Double getWindDeg() {
        return windDeg;
    }

    public Double getWindSpeed() {
        return windSpeed;
    }

    public static class Builder {

        private Double clouds;
        private Double dewPoint;
        private Double dt;
        private Double feelsLike;
        private Double humidity;
        private Double pressure;
        private Double sunrise;
        private Double sunset;
        private Double temp;
        private Double uvi;
        private Double visibility;
        private List<Weather> weather;
        private Double windDeg;
        private Double windSpeed;

        public Current.Builder withClouds(Double clouds) {
            this.clouds = clouds;
            return this;
        }

        public Current.Builder withDewPoint(Double dewPoint) {
            this.dewPoint = dewPoint;
            return this;
        }

        public Current.Builder withDt(Double dt) {
            this.dt = dt;
            return this;
        }

        public Current.Builder withFeelsLike(Double feelsLike) {
            this.feelsLike = feelsLike;
            return this;
        }

        public Current.Builder withHumidity(Double humidity) {
            this.humidity = humidity;
            return this;
        }

        public Current.Builder withPressure(Double pressure) {
            this.pressure = pressure;
            return this;
        }

        public Current.Builder withSunrise(Double sunrise) {
            this.sunrise = sunrise;
            return this;
        }

        public Current.Builder withSunset(Double sunset) {
            this.sunset = sunset;
            return this;
        }

        public Current.Builder withTemp(Double temp) {
            this.temp = temp;
            return this;
        }

        public Current.Builder withUvi(Double uvi) {
            this.uvi = uvi;
            return this;
        }

        public Current.Builder withVisibility(Double visibility) {
            this.visibility = visibility;
            return this;
        }

        public Current.Builder withWeather(List<Weather> weather) {
            this.weather = weather;
            return this;
        }

        public Current.Builder withWindDeg(Double windDeg) {
            this.windDeg = windDeg;
            return this;
        }

        public Current.Builder withWindSpeed(Double windSpeed) {
            this.windSpeed = windSpeed;
            return this;
        }

        public Current build() {
            Current current = new Current();
            current.clouds = clouds;
            current.dewPoint = dewPoint;
            current.dt = dt;
            current.feelsLike = feelsLike;
            current.humidity = humidity;
            current.pressure = pressure;
            current.sunrise = sunrise;
            current.sunset = sunset;
            current.temp = temp;
            current.uvi = uvi;
            current.visibility = visibility;
            current.weather = weather;
            current.windDeg = windDeg;
            current.windSpeed = windSpeed;
            return current;
        }

    }

}
