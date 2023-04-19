package com.example.proxy.feign.client.currentconditions;

import com.example.proxy.feign.rest.currentconditions.CurrentConditions;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(url = "${feign.accuweather.conditions.url}", name = "conditions")
public interface CurrentConditionsClient {

    @RequestMapping(method = RequestMethod.GET, value = "/{locationKey}")
    List<CurrentConditions> getByLocationKey(@RequestParam("apikey")String apikey, @PathVariable("locationKey")String locationKey);

}
