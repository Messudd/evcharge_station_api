package com.geolocation.charge_location_api.dao;

import com.geolocation.charge_location_api.entity.EvStation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EvStationDao extends JpaRepository<EvStation,Long> {
    @Query(value = "SELECT e.id,e.name,e.city,e.town,e.street,e.neighbourhood,e.image,e.description,"+
            "e.type,e.latitude,e.longitude FROM ev.charge_station as e WHERE e.city = :city ",nativeQuery = true)
    List<EvStation> getAllCityStation(String city);
    @Query(value = "SELECT e.id,e.name,e.city,e.town,e.street,e.neighbourhood,e.image,e.description," +
            "e.type,e.latitude,e.longitude FROM ev.charge_station as e WHERE e.city = :city and e.town = :town",nativeQuery = true)
    List<EvStation> getAllTownFromCity(String city, String town);
    @Query(value = "SELECT e.id,e.name,e.city,e.town,e.street,e.neighbourhood,e.image,e.description," +
            "e.type,e.latitude,e.longitude FROM ev.charge_station as e WHERE e.city = :city and e.town = :town and e.neighbourhood ilike (%:neighbourhood%)",nativeQuery = true)
    List<EvStation> getAllNeighbourhoodFromTown(String city, String town, String neighbourhood );
    @Query(value = "SELECT e.id,e.name,e.city,e.town,e.street,e.neighbourhood,e.image,e.description," +
            "e.type,e.latitude,e.longitude FROM ev.charge_station as e WHERE e.city = :city and e.town = :town and e.neighbourhood ilike (%:neighbourhood% ) and e.street ilike (%:street%) ",nativeQuery = true)
    List<EvStation> getAllStreetFromDb(String city, String town, String neighbourhood, String street);

}
