package com.example.proxy.feign.rest.currentconditions;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CurrentConditions {
    LocalDateTime LocalObservationDateTime;
    Integer EpochTime;
    String WeatherText;
    Integer WeatherIcon;
    Boolean HasPrecipitation;
    String PrecipitationType;
    Boolean IsDayTime;
    Temperature Temperature;
    String MobileLink;
    String Link;
}
