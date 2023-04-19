package com.example.proxy.dto;

import com.example.proxy.dto.response.ResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class ErrorDTO extends ResponseDTO {
    private String code;
    private String message;
}
