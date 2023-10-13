package com.example.weather.dto.response;

import com.example.weather.exampledb.model.WeatherCurrentHistory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WeatherCurrentResDTO {
    String locationKey;
    String dateTime;
    String weatherInMetric;
    String weatherInImperial;

    public static WeatherCurrentResDTO convert (WeatherCurrentHistory toConvert){
        ModelMapper modelMapper = new ModelMapper();

        WeatherCurrentResDTO dto = modelMapper.map(toConvert, WeatherCurrentResDTO.class);

        return dto;
    }
}
