package com.example.proxy.controller;

import com.example.proxy.service.ICurrentConditionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/currentcondition")
public class CurrentConditionController {
    ICurrentConditionService service;

    @Autowired
    public CurrentConditionController(ICurrentConditionService service) {
        this.service = service;
    }

    @GetMapping
    public void getCurrentConditionByLocationKey(String locationKey){
        service.getByLocationKey(locationKey);
    }
}
