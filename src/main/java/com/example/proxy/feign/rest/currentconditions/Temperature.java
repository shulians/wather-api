package com.example.proxy.feign.rest.currentconditions;

import lombok.Data;

@Data
public class Temperature {
    MeasureTime Metric;
    MeasureTime Imperial;
}
