package com.geolocation.charge_location_api.service;

import com.geolocation.charge_location_api.entity.EvStation;

import java.util.List;

public interface EvStationService {
    List<EvStation> getAllCityStation(String city);
    List<EvStation> getAllTownFromCity(String city, String town);
    List<EvStation> getAllNeighbourhoodFromTown(String city, String town, String neighbourhood);
    List<EvStation> getAllStreetFromDb(String city, String town, String neighbourhood, String street);
    EvStation getStationById(Long id);
    EvStation saveStation(EvStation evStation);
    EvStation deleteStation(Long id);
}
