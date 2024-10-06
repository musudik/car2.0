package com.car.market.model;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
public class FileInformation {
    private String name;
    private Long size;
    private Date date;
    private String type;
}
