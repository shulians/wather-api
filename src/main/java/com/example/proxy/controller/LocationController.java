package com.example.proxy.controller;

import com.example.proxy.service.ILocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/location")
public class LocationController {
    ILocationService service;

    @Autowired
    public LocationController(ILocationService service) {
        this.service = service;
    }
}
