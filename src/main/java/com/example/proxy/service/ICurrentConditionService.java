package com.example.proxy.service;

import com.example.proxy.dto.response.CurrentConditionResDTO;
import com.example.proxy.exception.TechnicalException;

public interface ICurrentConditionService {
    CurrentConditionResDTO getByLocationKey(String locationKey) throws TechnicalException;
}
