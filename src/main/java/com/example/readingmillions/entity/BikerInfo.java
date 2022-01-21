package com.example.readingmillions.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Table(name = "bikes_info", schema = "test") //0.2 million records in mysql
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor @AllArgsConstructor
public class BikerInfo {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    @Column(name = "duration")
    Integer duration;

    @Column(name = "Start_Station_Number")
    Integer startStationNUmber;

    @Column(name = "End_Station_Number")
    Integer endStationNumber;

    @Column(name = "End_Station")
    String  endStation;

    @Column(name = "Bike_number")
    String bikeNumber;

    @Column(name = "Member_Type")
    String memberType;

}
