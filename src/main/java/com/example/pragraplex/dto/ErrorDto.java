package com.example.pragraplex.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class ErrorDto {
    private int errorCode;
    private String message;
    private Date errorDate;
}
