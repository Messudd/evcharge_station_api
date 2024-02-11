package com.geolocation.charge_location_api.exception;

import lombok.Getter;

@Getter
public class EvErrorResponce {
    private  String message;

    public  EvErrorResponce(String message){
        this.message = message;
    }
}
