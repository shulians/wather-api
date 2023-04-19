package com.example.proxy.feign.rest.locations;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Country {
    String ID;
    String LocalizedName;
}
