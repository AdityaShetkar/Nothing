package com.cryptocurrencyOrders.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseResponse {

    private int status;
    private String message;
    private String supportDescriptiveMessage;
    private Object data;
    private Object error;

}
