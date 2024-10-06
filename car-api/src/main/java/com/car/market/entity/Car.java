package com.car.market.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@ToString
@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String make;
    private String model;
    private String color;
    private String description;
    private String fuel;
    private String gearType;
    private String power;
    private String mileage;
    private String image;
    private int year;
    private double price;
    private String status; // For sale, rent, etc.
}
