package com.car.market.model;

import com.car.market.entity.Car;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
public class CarSellRequest {

    private Car carDetails;
    private List<FileInformation> images;
    private List<FileInformation> documents;
}
