package com.example.proxy.util;

import com.example.proxy.dto.response.CurrentConditionResDTO;
import com.example.proxy.dto.response.LocationResDTO;
import com.example.proxy.feign.rest.currentconditions.CurrentConditions;

public class TestUtil {

    public static CurrentConditions getCurrentConditions(){
        return CurrentConditions.builder().build();
    }

    public static CurrentConditionResDTO getCurrentConditionResDTO(){
        return CurrentConditionResDTO.builder().build();
    }

    public static LocationResDTO getLocations(){
        return LocationResDTO.builder().build();
    }

    public static LocationResDTO getLocationResDTO(){
        return LocationResDTO.builder().build();
    }

}
