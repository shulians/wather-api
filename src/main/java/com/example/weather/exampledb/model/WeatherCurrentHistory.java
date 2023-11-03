package com.example.weather.exampledb.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="WEATHER_CURRENT_HISTORY")
public class WeatherCurrentHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    Integer id;

    @Column(name = "LOCATION_KEY")
    String locationKey;

    @Column(name = "DATE_TIME")
    String dateTime;

    @Column(name = "WEATHER_IN_METRIC")
    Double weatherInMetric;

    @Column(name = "WEATHER_IN_IMPERIAL")
    Double weatherInImperial;
}
