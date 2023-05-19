package com.order.exception;

import com.order.constant.ConstantUtils;
import com.order.response.BaseResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ValidatorException.class)
    public ResponseEntity<BaseResponse> resourceNotFoundExceptionHandler(ValidatorException exception) {
        BaseResponse baseResponse = new BaseResponse(HttpStatus.BAD_REQUEST.value(),exception.getMessage(), exception.getMessage(), null, ConstantUtils.SOMETHING_WENT_WRONG);
        return new ResponseEntity<BaseResponse>(baseResponse, HttpStatus.valueOf(HttpStatus.NOT_FOUND.value()));
    }

}
