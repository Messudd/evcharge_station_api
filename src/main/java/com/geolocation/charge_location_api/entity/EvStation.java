package com.geolocation.charge_location_api.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@Entity
@Table (name = "charge_station" , schema = "ev")
public class EvStation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private  long id;
    @Column(name = "name")
    private String name;
    @Column( name = "city")
    private  String city;
    @Column(name = "town")
    private  String town;
    @Column(name = "street")
    private  String street;
    @Column(name = "neighbourhood")
    private  String neighbourhood;
    @Column(name = "image")
    private String image;
    @Column(name = "description")
    private  String description;
    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private  Type type;
    @Column(name = "latitude")
    private  String latitude;
    @Column (name = "longitude")
    private  String longitude;
}
