package com.zooplus.Zooplus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/weather-data")
@CrossOrigin("*")
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @GetMapping
    public Weather getWeatherData(@RequestParam String cityName) {
        return weatherService.getWeatherData(cityName);
    }
}
