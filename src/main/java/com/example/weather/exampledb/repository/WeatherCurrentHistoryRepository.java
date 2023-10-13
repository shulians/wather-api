package com.example.weather.exampledb.repository;

import com.example.weather.exampledb.model.WeatherCurrentHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeatherCurrentHistoryRepository extends JpaRepository<WeatherCurrentHistory, Integer> {
}
