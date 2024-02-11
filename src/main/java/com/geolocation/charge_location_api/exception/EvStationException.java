package com.geolocation.charge_location_api.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class EvStationException extends RuntimeException {

    private HttpStatus status;
    public  EvStationException(String message , HttpStatus status){
        super(message);
        this.status = status;
    }

}
