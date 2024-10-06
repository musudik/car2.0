package com.car.market.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Data
@ToString
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TB_AGS_CAR_SELL_MASTER_DATA")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "carSellId", scope = Integer.class)
public class CarSellMasterData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CAR_SELL_ID", nullable = false)
    private Integer carSellId;

    @Column(name = "CAR_SELL_MAKE_TYPE", length = 50, nullable = false)
    private String make;

    @Column(name = "CAR_SELL_MODEL_TYPE", length = 50, nullable = false)
    private String model;

    @Column(name = "CAR_SELL_FUEL_TYPE", length = 30, nullable = false)
    private String fuelType;

    @Column(name = "CAR_SELL_GEAR_TYPE", length = 30, nullable = false)
    private String gearType;

    @Column(name = "CAR_SELL_DESCRIPTION", length = 255, nullable = false)
    private String description;

    @Column(name = "CAR_SELL_FIRST_REGISTERED_DATE", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date firstRegisteredDate;

    @Column(name = "CAR_SELL_KILOMETRES_DRIVEN", nullable = false)
    private String kilometresDriven;

    @Column(name = "CAR_SELL_REGISTERED_YEAR", nullable = false)
    private Long year;

    @Column(name = "CAR_SELL_OPEN_PRICE", nullable = false)
    private Double openPrice;

    // Relationship with CarSellImagesData
    @OneToMany(mappedBy = "carSellMasterData", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SELECT)
    private List<CarSellImagesData> carSellImages;

    // Relationship with CarSellDocumentsData
    @OneToMany(mappedBy = "carSellMasterData", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SELECT)
    private List<CarSellDocumentsData> carSellDocuments;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}

