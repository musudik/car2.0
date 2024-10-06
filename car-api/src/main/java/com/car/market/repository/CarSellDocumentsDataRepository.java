package com.car.market.repository;

import com.car.market.entity.CarSellDocumentsData;
import com.car.market.entity.CarSellImagesData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CarSellDocumentsDataRepository extends JpaRepository<CarSellDocumentsData, Integer> {

    @Query("SELECT c FROM CarSellDocumentsData c WHERE c.carSellMasterData.carSellId = :carSellId")
    List<CarSellDocumentsData> findSellDocumentsByMasterId(@Param("carSellId") Integer carSellId);
}
