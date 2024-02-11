package com.geolocation.charge_location_api.service;

import com.geolocation.charge_location_api.dao.EvStationDao;
import com.geolocation.charge_location_api.entity.EvStation;
import com.geolocation.charge_location_api.exception.EvStationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


// TODO  YOU MUST WRITE A VALİDATİON --- SERVICE LAYER
@Service
public class EvStationServiceImpl implements EvStationService{
    public EvStationDao evStationDao;
    @Autowired
    public EvStationServiceImpl(EvStationDao evStationDao){
        this.evStationDao = evStationDao;
    }
    @Override
    public List<EvStation> getAllCityStation(String city) {
       List<EvStation> evALLFromCity =  evStationDao.getAllCityStation(city);
       if(!evALLFromCity.isEmpty()){
           return  evALLFromCity;
       }
        return null;
    }

    @Override
    public List<EvStation> getAllTownFromCity(String city, String town) {
        List<EvStation> evALLFromTown =  evStationDao.getAllTownFromCity(city,town);
        if(!evALLFromTown.isEmpty()){
            return  evALLFromTown;
        }
        throw  new EvStationException("station is not found in this area", HttpStatus.BAD_REQUEST);
    }
    @Override
    public List<EvStation> getAllNeighbourhoodFromTown(String city, String town, String neighbourhood) {
        List<EvStation> evALLFromStreet =  evStationDao.getAllNeighbourhoodFromTown(city,town, neighbourhood);
        if(!evALLFromStreet.isEmpty()){
            return  evALLFromStreet;
        }
        throw  new EvStationException("station is not found in this area", HttpStatus.BAD_REQUEST);
    }
    @Override
    public List<EvStation> getAllStreetFromDb(String city, String town, String neighbourhood, String street) {
        List<EvStation> evALLFromNeighbourhood =  evStationDao.getAllStreetFromDb(city,town,neighbourhood,street);
        if(!evALLFromNeighbourhood.isEmpty()){
            return  evALLFromNeighbourhood;
        }
        throw  new EvStationException("station is not found in this area", HttpStatus.BAD_REQUEST);
    }
    @Override
    public EvStation getStationById(Long id) {
        Optional<EvStation> ev = evStationDao.findById(id);
        if(ev.isPresent()){
            return  ev.get();
        }
        throw  new EvStationException("No station with this id was found" + ":" +id, HttpStatus.BAD_REQUEST);
    }
    //TODO EV STATİON CHECK DATA AND CREATE EXCEPTİON
    @Override
    public EvStation saveStation(EvStation evStation) {
        return evStationDao.save(evStation);
    }
    @Override
    public EvStation deleteStation(Long id) {
        EvStation delEv = getStationById(id);
        evStationDao.delete(delEv);
        return delEv;
    }
}
