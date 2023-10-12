package com.example.weather.feign.rest.currentconditions;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Temperature {
    MeasureTime Metric;
    MeasureTime Imperial;
}
