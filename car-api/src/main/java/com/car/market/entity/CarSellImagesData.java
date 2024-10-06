package com.car.market.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Data
@ToString
@Entity
@Table(name = "TB_AGS_CAR_SELL_IMAGES_DATA")
public class CarSellImagesData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CAR_SELL_IMAGES_ID", nullable = false)
    private Integer carSellImagesId;

    @Column(name = "CAR_SELL_IMAGES_COUNT", nullable = false)
    private Long imagesCount;

    @Column(name = "CAR_SELL_IMAGE_FILENAME", nullable = false)
    private String imageFilename;

    @Column(name = "CAR_SELL_IMAGE_UPLOAD_DATE", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date imageUploadDate;

    // Foreign key referencing CarSellMasterData
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CAR_SELL_MASTER_ID")
    private CarSellMasterData carSellMasterData;
}
