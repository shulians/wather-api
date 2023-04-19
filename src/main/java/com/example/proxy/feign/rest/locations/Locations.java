package com.example.proxy.feign.rest.locations;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Locations {
     Integer Version;
     String Key;
     String Type;
     Integer Rank;
     String LocalizedName;
     Country Country;
}
