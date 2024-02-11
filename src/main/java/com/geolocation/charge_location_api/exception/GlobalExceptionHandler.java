package com.geolocation.charge_location_api.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<EvErrorResponce> evStationHandler(EvStationException ex){
        EvErrorResponce evErrorResponce = new EvErrorResponce(ex.getMessage());
        return  new ResponseEntity<>(evErrorResponce,ex.getStatus());
    }
}
