
package com.example.weatherapp.models.HourlyWeather;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class OpenWeatherResponse {

    @Expose
    private Current current;
    @Expose
    private List<Hourly> hourly;
    @Expose
    private Double lat;
    @Expose
    private Double lon;
    @Expose
    private String timezone;
    @SerializedName("timezone_offset")
    private Long timezoneOffset;

    public Current getCurrent() {
        return current;
    }

    public List<Hourly> getHourly() {
        return hourly;
    }

    public Double getLat() {
        return lat;
    }

    public Double getLon() {
        return lon;
    }

    public String getTimezone() {
        return timezone;
    }

    public Long getTimezoneOffset() {
        return timezoneOffset;
    }

    public static class Builder {

        private Current current;
        private List<Hourly> hourly;
        private Double lat;
        private Double lon;
        private String timezone;
        private Long timezoneOffset;

        public OpenWeatherResponse.Builder withCurrent(Current current) {
            this.current = current;
            return this;
        }

        public OpenWeatherResponse.Builder withHourly(List<Hourly> hourly) {
            this.hourly = hourly;
            return this;
        }

        public OpenWeatherResponse.Builder withLat(Double lat) {
            this.lat = lat;
            return this;
        }

        public OpenWeatherResponse.Builder withLon(Double lon) {
            this.lon = lon;
            return this;
        }

        public OpenWeatherResponse.Builder withTimezone(String timezone) {
            this.timezone = timezone;
            return this;
        }

        public OpenWeatherResponse.Builder withTimezoneOffset(Long timezoneOffset) {
            this.timezoneOffset = timezoneOffset;
            return this;
        }

        public OpenWeatherResponse build() {
            OpenWeatherResponse openWeatherResponse = new OpenWeatherResponse();
            openWeatherResponse.current = current;
            openWeatherResponse.hourly = hourly;
            openWeatherResponse.lat = lat;
            openWeatherResponse.lon = lon;
            openWeatherResponse.timezone = timezone;
            openWeatherResponse.timezoneOffset = timezoneOffset;
            return openWeatherResponse;
        }

    }

}
