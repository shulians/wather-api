package com.example.weather.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LocationReqDTO {
    Integer version;
    String key;
    Integer rank;
    String localizedName;
    String country;
    String city;
}
