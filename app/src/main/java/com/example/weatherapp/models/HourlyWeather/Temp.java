
package com.example.weatherapp.models.HourlyWeather;

import com.google.gson.annotations.Expose;

@SuppressWarnings("unused")
public class Temp {

    @Expose
    private Double day;
    @Expose
    private Double eve;
    @Expose
    private Double max;
    @Expose
    private Double min;
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

    public Double getMax() {
        return max;
    }

    public Double getMin() {
        return min;
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
        private Double max;
        private Double min;
        private Double morn;
        private Double night;

        public Temp.Builder withDay(Double day) {
            this.day = day;
            return this;
        }

        public Temp.Builder withEve(Double eve) {
            this.eve = eve;
            return this;
        }

        public Temp.Builder withMax(Double max) {
            this.max = max;
            return this;
        }

        public Temp.Builder withMin(Double min) {
            this.min = min;
            return this;
        }

        public Temp.Builder withMorn(Double morn) {
            this.morn = morn;
            return this;
        }

        public Temp.Builder withNight(Double night) {
            this.night = night;
            return this;
        }

        public Temp build() {
            Temp temp = new Temp();
            temp.day = day;
            temp.eve = eve;
            temp.max = max;
            temp.min = min;
            temp.morn = morn;
            temp.night = night;
            return temp;
        }

    }

}
