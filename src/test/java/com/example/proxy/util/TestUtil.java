package com.example.proxy.util;

import com.example.proxy.dto.response.CurrentConditionResDTO;
import com.example.proxy.dto.response.LocationResDTO;
import com.example.proxy.feign.rest.currentconditions.CurrentConditions;
import com.example.proxy.feign.rest.currentconditions.MeasureTime;
import com.example.proxy.feign.rest.currentconditions.Temperature;
import com.example.proxy.feign.rest.locations.Country;
import com.example.proxy.feign.rest.locations.Locations;

import java.util.ArrayList;
import java.util.List;

public class TestUtil {
    public static final String API_KEY = "apiKey";
    public static final String API_KEY_VALUE = "0imfnc8mVLWwsAawjYr4Rx";
    public static final String TEXT = "Luis Guillon";
    public static final String KEY = "1-7216_1_AL";
    public static final Integer VERSION = 1;
    public static final String TYPE = "City";
    public static final Integer RANK = 85;
    public static final String  LOCATIONS_LOCALIZED_NAME = "Luis Guillon";
    public static final String  ID = "AR";
    public static final String  COUNTRY_LOCALIZED_NAME = "Argentina";
    public static final String  DATE_TIME = "2023-04-19T20:35:00-03:00";
    public static final String  LINK = "http://www.accuweather.com/en/ar/luis-guillon/1-7216_1_al/current-weather/1-7216_1_al?lang=en-us";
    public static final Double DOUBLE_METRIC = 12.8;
    public static final Double DOUBLE_IMPERIAL = 55.0;
    public static final String  UNIT_C = "C";
    public static final String  UNIT_F = "F";

    public static Locations getLocations(){
        return Locations.builder()
                        .Key(KEY)
                        .Version(VERSION)
                        .Type(TYPE)
                        .Rank(RANK)
                        .LocalizedName(LOCATIONS_LOCALIZED_NAME)
                        .Country(getCountry()).build();
    }

    public static List<Locations> getListLocations(){
        List<Locations> locations = new ArrayList();
        Locations l1 = getLocations();
        locations.add(l1);

        return locations;
    }

    public static CurrentConditions getCurrentConditions(){
        return CurrentConditions.builder()
                .LocalObservationDateTime(DATE_TIME)
                .MobileLink(LINK)
                .Link(LINK)
                .Temperature(getTemperature())
                .build();
    }

    public static List<CurrentConditions> getListCurrentConditions(){
        List<CurrentConditions> currentConditions = new ArrayList();
        CurrentConditions c1 = getCurrentConditions();
        currentConditions.add(c1);

        return currentConditions;
    }
    public static LocationResDTO getLocationResDTO(){
        return LocationResDTO.builder().build();
    }

    public static CurrentConditionResDTO getCurrentConditionResDTO(){
        return CurrentConditionResDTO.builder().build();
    }

    private static Country getCountry(){
        return Country.builder().ID(ID).LocalizedName(COUNTRY_LOCALIZED_NAME).build();
    }

    private static Temperature getTemperature(){
        MeasureTime metric = MeasureTime.builder().Value(DOUBLE_METRIC).Unit(UNIT_C).build();
        MeasureTime imperial = MeasureTime.builder().Value(DOUBLE_IMPERIAL).Unit(UNIT_F).build();
        return Temperature.builder().Metric(metric).Imperial(imperial).build();
    }

}
