package com.example.proxy.feign.rest.currentconditions;

import lombok.Data;

@Data
public class MeasureTime {
    Double Value;
    String Unit;
    Integer UnitType;
}
