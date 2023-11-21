package com.example.weather.service.impl;

import com.example.weather.dto.request.WeatherRqDTO;
import com.example.weather.dto.response.WeatherResDTO;
import com.example.weather.exampledb.model.WeatherCurrentHistory;
import com.example.weather.exampledb.repository.WeatherCurrentHistoryRepository;
import com.example.weather.exception.TechnicalException;
import com.example.weather.feign.client.currentconditions.CurrentConditionsClient;
import com.example.weather.feign.rest.currentconditions.CurrentConditions;
import com.example.weather.service.IWeatherCurrentService;
import com.example.weather.util.ErrorDescriptionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementación de la interfaz {@link IWeatherCurrentService} que proporciona funcionalidad
 * para obtener información sobre las condiciones climáticas actuales.
 */
@Service
public class WeatherCurrentServiceImpl implements IWeatherCurrentService {
    @Value("${feign.accuweather.apikey}")
    String apiKey;
    CurrentConditionsClient client;
    WeatherCurrentHistoryRepository repository;

    @Autowired
    public WeatherCurrentServiceImpl(CurrentConditionsClient client, WeatherCurrentHistoryRepository repository) {
        this.client = client;
        this.repository = repository;
    }

    /**
     * Obtiene información sobre las condiciones climáticas actuales para una ubicación específica.
     *
     * @param rq Objeto de solicitud que contiene la clave única de la ubicación.
     * @return DTO que representa las condiciones climáticas actuales.
     * @throws TechnicalException Si ocurre un error técnico al obtener las condiciones climáticas actuales.
     */
    @Override
    public WeatherResDTO getByLocationKey(WeatherRqDTO rq)throws TechnicalException{
        WeatherResDTO response = WeatherResDTO.builder().build();

        try {
            String key = rq.getLocation().getKey();
            String localizedName = rq.getLocation().getLocalizedName();
            String country = rq.getLocation().getCountry();
            String city = rq.getLocation().getCity();

            List<CurrentConditions> conditions = client.getByLocationKey(apiKey, key);

            if(!conditions.isEmpty()){
                CurrentConditions condition = conditions.get(0);
                response = WeatherResDTO.convert(condition);

                WeatherCurrentHistory weatherCurrent = WeatherCurrentHistory.builder()
                        .locationKey(key)
                        .dateTime(response.getLocalObservationDateTime())
                        .localizedName(localizedName)
                        .country(country)
                        .city(city)
                        .weatherInMetric(response.getTemperature().getMetric().getValue())
                        .weatherInImperial(response.getTemperature().getImperial().getValue())
                        .WeatherText(response.getWeatherText())
                        .IsDayTime(response.getIsDayTime())
                        .build();

                repository.save(weatherCurrent);
            }
        }catch (Exception e){
            throw new TechnicalException(ErrorDescriptionUtil.E_GENERAL_EXCEPTION_CODE,
                                            ErrorDescriptionUtil.E_GENERAL_EXCEPTION);
        }

        return response;
    }
}
