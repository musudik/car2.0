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
@Table(name = "TB_AGS_CAR_SELL_DOCUMENTS_DATA" , schema="public")
public class CarSellDocumentsData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CAR_SELL_DOCUMENTS_ID", nullable = false)
    private Integer carSellDocumentsId;

    @Column(name = "CAR_SELL_DOCUMENTS_COUNT", nullable = false)
    private Long documentsCount;

    @Column(name = "CAR_SELL_DOCUMENTS_FILENAME", nullable = false)
    private String documentsFilename;

    @Column(name = "CAR_SELL_DOCUMENTS_UPLOAD_DATE", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date documentsUploadDate;

    // Foreign key referencing CarSellMasterData
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CAR_SELL_MASTER_ID")
    private CarSellMasterData carSellMasterData;
}

