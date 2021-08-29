package com.zooplus.Zooplus;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.TimeZone;

public class WeatherMapper {
    /**
     * Maps {@link WeatherData} to {@link Weather}
     *
     * @param weatherData the weather data to map
     * @return the mapped {@link Weather} object
     */
    public Weather mapWeather(WeatherData weatherData) {
        Weather weather = new Weather();

        if (weatherData == null) {
            return weather;
        }

        weather.setCityName(weatherData.getName());
        weather.setCountryCode(weatherData.getSys().getCountry());
        System.out.println(weatherData.getDt());

        LocalDateTime dateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(weatherData.getDt()* 1000L), TimeZone.getDefault().toZoneId());
        String status = weatherData.getWeather().length > 0 ? weatherData.getWeather()[0].getDescription() : "";

        weather.setDateTime(dateTime);
        weather.setStatus(status);
        weather.setCurrentTemperature(weatherData.getMain().getTemp());
        weather.setMaxTemperature(weatherData.getMain().getTemp_max());
        weather.setMinTemperature(weatherData.getMain().getTemp_min());

        return weather;
    }
}
