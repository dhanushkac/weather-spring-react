package com.zooplus.Zooplus;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class WeatherData {
    private String name;
    private int dt;
    private int timezone;
    private TemperatureData main;
    private CountryData sys;
    private MetaData[] weather;
}

@Data
class TemperatureData {
    private double temp;
    private double temp_min;
    private double temp_max;
}

@Data
class CountryData {
    private String country;
}

@Data
class MetaData {
    String description;
}