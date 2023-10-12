package com.example.weather.feign.client.result;

import com.example.weather.feign.rest.result.Result;
import com.example.weather.feign.rest.result.Results;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(url = "${feign.results.url}", name = "result")
public interface ResultClient {
    @GetMapping
    Results getAll();

    @PostMapping
    void create(@RequestBody Result result);
}
