package com.zooplus.Zooplus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class WeatherService {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    WeatherMapper weatherMapper;

    String url = "https://api.openweathermap.org/data/2.5/weather?q={q}&appid={appid}&units={units}";

    public Weather getWeatherData(String cityName) {

        Map<String, String> params = new HashMap<>();
        params.put("q", cityName);
        params.put("appid", "8350d64b7ce250dbeeb15a65b7e67d2b");
        params.put("units", "metric");

        Weather response;

        try {
            WeatherData weatherData = restTemplate.getForObject(url, WeatherData.class, params);
            response = weatherMapper.mapWeather(weatherData);
        } catch (Exception e) {
            throw new CityNotFoundException();
        }

        return response;
    }
}
