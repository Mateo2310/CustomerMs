package com.challenge.customerms.presentation.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseGeneric<T> {
    private String status;
    private String message;
    private T data;
}
