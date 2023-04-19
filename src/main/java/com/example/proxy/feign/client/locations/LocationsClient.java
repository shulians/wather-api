package com.example.proxy.feign.client.locations;

import com.example.proxy.feign.rest.locations.Locations;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(url = "${feign.accuweather.locations.url}", name = "locations")
public interface LocationsClient {

    @RequestMapping(method = RequestMethod.GET)
    Locations searchByQ(@RequestParam("apikey")String apikey, @RequestParam("q")String q);

}
