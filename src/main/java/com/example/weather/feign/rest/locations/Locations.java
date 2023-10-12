package com.example.weather.feign.rest.locations;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Locations {
     Integer Version;
     String Key;
     Integer Rank;
     String LocalizedName;
     AdministrativeArea AdministrativeArea;
     Country Country;
}
