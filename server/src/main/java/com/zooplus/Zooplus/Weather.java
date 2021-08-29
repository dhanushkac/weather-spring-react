package com.zooplus.Zooplus;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class Weather {
    private String cityName;
    private LocalDateTime dateTime;
    private String countryCode;
    private double minTemperature;
    private double maxTemperature;
    private double currentTemperature;
    private String status;
}
