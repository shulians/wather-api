package com.example.weather.exampledb.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="WEATHER_CURRENT_HISTORY", schema = "EXAMPLEDB")
public class WeatherCurrentHistory {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    @Column(name = "ID")
    Integer id;

    @Column(name = "KEY")
    String key;

    @Column(name = "DATE_TIME")
    String dateTime;

    @Column(name = "WEATHER_IN_METRIC")
    Double weatherInMetric;

    @Column(name = "WEATHER_IN_IMPERIAL")
    Double weatherInImperial;
}
