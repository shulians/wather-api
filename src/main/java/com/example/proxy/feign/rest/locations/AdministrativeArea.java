package com.example.proxy.feign.rest.locations;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AdministrativeArea {
    String ID;
    String LocalizedName;
}
