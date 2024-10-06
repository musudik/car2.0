package com.car.market.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Data
@ToString
@Entity
@Table(name = "CAR", schema="public")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", nullable = false)
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
