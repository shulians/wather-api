package com.example.weather.feign.client.locations;

import com.example.weather.feign.rest.locations.Locations;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(url = "${feign.accuweather.locations.url}", name = "locations")
public interface LocationsClient {

    @RequestMapping(method = RequestMethod.GET, value = "/cities/search")
    List<Locations> searchByQ(@RequestParam("apikey")String apikey, @RequestParam("q")String q);

    @RequestMapping(method = RequestMethod.GET, value = "/{locationKey}")
    Locations searchByLocationKey(@RequestParam("apikey")String apikey, @PathVariable("locationKey")String locationKey);

}
