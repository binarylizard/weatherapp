
package com.example.weatherapp.models.HourlyWeather;

import com.google.gson.annotations.Expose;

@SuppressWarnings("unused")
public class FeelsLike {

    @Expose
    private Double day;
    @Expose
    private Double eve;
    @Expose
    private Double morn;
    @Expose
    private Double night;

    public Double getDay() {
        return day;
    }

    public Double getEve() {
        return eve;
    }

    public Double getMorn() {
        return morn;
    }

    public Double getNight() {
        return night;
    }

    public static class Builder {

        private Double day;
        private Double eve;
        private Double morn;
        private Double night;

        public FeelsLike.Builder withDay(Double day) {
            this.day = day;
            return this;
        }

        public FeelsLike.Builder withEve(Double eve) {
            this.eve = eve;
            return this;
        }

        public FeelsLike.Builder withMorn(Double morn) {
            this.morn = morn;
            return this;
        }

        public FeelsLike.Builder withNight(Double night) {
            this.night = night;
            return this;
        }

        public FeelsLike build() {
            FeelsLike feelsLike = new FeelsLike();
            feelsLike.day = day;
            feelsLike.eve = eve;
            feelsLike.morn = morn;
            feelsLike.night = night;
            return feelsLike;
        }

    }

}
