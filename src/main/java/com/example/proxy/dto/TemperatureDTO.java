package com.example.proxy.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TemperatureDTO {
    MeasureTimeDTO Metric;
    MeasureTimeDTO Imperial;
}
