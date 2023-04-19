package com.example.proxy.service;

import com.example.proxy.dto.response.CurrentConditionResDTO;

public interface ICurrentConditionService {
    CurrentConditionResDTO getByLocationKey(String locationKey);
}
