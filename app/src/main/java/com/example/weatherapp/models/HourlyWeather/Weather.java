
package com.example.weatherapp.models.HourlyWeather;

import com.google.gson.annotations.Expose;

@SuppressWarnings("unused")
public class Weather {

    @Expose
    private String description;
    @Expose
    private String icon;
    @Expose
    private Long id;
    @Expose
    private String main;

    public String getDescription() {
        return description;
    }

    public String getIcon() {
        return icon;
    }

    public Long getId() {
        return id;
    }

    public String getMain() {
        return main;
    }

    public static class Builder {

        private String description;
        private String icon;
        private Long id;
        private String main;

        public Weather.Builder withDescription(String description) {
            this.description = description;
            return this;
        }

        public Weather.Builder withIcon(String icon) {
            this.icon = icon;
            return this;
        }

        public Weather.Builder withId(Long id) {
            this.id = id;
            return this;
        }

        public Weather.Builder withMain(String main) {
            this.main = main;
            return this;
        }

        public Weather build() {
            Weather weather = new Weather();
            weather.description = description;
            weather.icon = icon;
            weather.id = id;
            weather.main = main;
            return weather;
        }

    }

}
