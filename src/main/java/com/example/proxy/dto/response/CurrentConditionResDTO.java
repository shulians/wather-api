package com.example.proxy.dto.response;


import com.example.proxy.dto.TemperatureDTO;
import com.example.proxy.feign.rest.currentconditions.CurrentConditions;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CurrentConditionResDTO extends ResponseDTO {
    String LocalObservationDateTime;
    TemperatureDTO Temperature;
    String MobileLink;
    String Link;

    public static CurrentConditionResDTO convert (CurrentConditions toConvert){
        ModelMapper modelMapper = new ModelMapper();

        CurrentConditionResDTO dto = modelMapper.map(toConvert,CurrentConditionResDTO.class);

        return dto;
    }
}
