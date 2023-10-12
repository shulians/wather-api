package com.example.weather.dto.response;

import com.example.weather.feign.rest.locations.Locations;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LocationResDTO extends ResponseDTO {
    Integer Version;
    String Key;
    Integer Rank;
    String LocalizedName;
    String city;
    String country;

    public static LocationResDTO convert (Locations toConvert){
        ModelMapper modelMapper = new ModelMapper();

        LocationResDTO dto = modelMapper.map(toConvert,LocationResDTO.class);

        dto.setCity(toConvert.getAdministrativeArea().getLocalizedName());
        dto.setCountry(toConvert.getCountry().getLocalizedName());

        return dto;
    }

}
