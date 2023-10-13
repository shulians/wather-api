package com.example.weather.dto.response;


import com.example.weather.dto.TemperatureDTO;
import com.example.weather.feign.rest.currentconditions.CurrentConditions;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WeatherResDTO extends ResponseDTO {
    String LocalObservationDateTime;
    TemperatureDTO Temperature;
    String MobileLink;
    String Link;

    public static WeatherResDTO convert (CurrentConditions toConvert){
        ModelMapper modelMapper = new ModelMapper();

        WeatherResDTO dto = modelMapper.map(toConvert, WeatherResDTO.class);

        return dto;
    }
}
