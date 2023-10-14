package com.example.weather.service.impl;

import com.example.weather.dto.response.LocationResDTO;
import com.example.weather.exception.TechnicalException;
import com.example.weather.feign.client.locations.LocationsClient;
import com.example.weather.feign.rest.locations.Locations;
import com.example.weather.service.ILocationService;
import com.example.weather.util.ErrorDescriptionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
/**
 * Implementación de la interfaz {@link ILocationService} que proporciona funcionalidad
 * para obtener información sobre ubicaciones climáticas.
 */
@Service
public class LocationServiceImpl implements ILocationService {
    @Value("${feign.accuweather.apikey}")
    String apiKey;

    LocationsClient client;

    @Autowired
    public LocationServiceImpl(LocationsClient client) {
        this.client = client;
    }

    /**
     * Obtiene una lista de ubicaciones climáticas que coinciden con la cadena de búsqueda.
     *
     * @param q Cadena de búsqueda para las ubicaciones climáticas.
     * @return Lista de DTO que representan las ubicaciones climáticas encontradas.
     * @throws TechnicalException Si ocurre un error técnico al obtener las ubicaciones climáticas.
     */
    @Override
    public List<LocationResDTO> getLocations(String q) throws TechnicalException {
        List<LocationResDTO> response;

        try {
            List<Locations> locations = client.searchByQ(apiKey, q);

            response = locations.stream()
                                .map(LocationResDTO::convert)
                                .collect(Collectors.toList());
        }catch (Exception e){
            throw new TechnicalException(ErrorDescriptionUtil.E_GENERAL_EXCEPTION_CODE,
                    ErrorDescriptionUtil.E_GENERAL_EXCEPTION);
        }

        return response;
    }

    /**
     * Obtiene información detallada sobre una ubicación climática mediante su clave única.
     *
     * @param key Clave única que identifica la ubicación climática.
     * @return DTO que representa la información de la ubicación climática.
     * @throws TechnicalException Si ocurre un error técnico al obtener la información de la ubicación climática.
     */
    @Override
    public LocationResDTO getLocationByKey(String key) throws TechnicalException {
        LocationResDTO response;

        try {
            Locations location = client.searchByLocationKey(apiKey, key);
            response = LocationResDTO.convert(location);
        }catch (Exception e){
            throw new TechnicalException(ErrorDescriptionUtil.E_GENERAL_EXCEPTION_CODE,
                    ErrorDescriptionUtil.E_GENERAL_EXCEPTION);
        }

        return response;
    }
}
