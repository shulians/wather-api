package com.example.proxy.feign.rest.currentconditions;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MeasureTime {
    Double Value;
    String Unit;
    Integer UnitType;
}
