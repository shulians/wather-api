package com.example.weather.feign.rest.result;

import com.example.weather.dto.response.WeatherResDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Result {
    String key;
    String localizedName;
    String country;
    String city;
    String dateTime;
    String weatherInMetric;
    String weatherInImperial;

    public static Result convert(WeatherResDTO toConvert) {
        ModelMapper modelMapper = new ModelMapper();

        Result dto = modelMapper.map(toConvert, Result.class);

        return dto;
    }
}
