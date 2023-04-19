package com.example.proxy.dto.response;

import com.example.proxy.dto.CountryDTO;
import com.example.proxy.feign.rest.currentconditions.CurrentConditions;
import com.example.proxy.feign.rest.locations.Country;
import com.example.proxy.feign.rest.locations.Locations;
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
    String Type;
    Integer Rank;
    String LocalizedName;
    CountryDTO Country;

    public static LocationResDTO convert (Locations toConvert){
        ModelMapper modelMapper = new ModelMapper();

        LocationResDTO dto = modelMapper.map(toConvert,LocationResDTO.class);

        return dto;
    }

}
