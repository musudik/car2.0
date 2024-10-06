package com.car.market.repository;

import com.car.market.entity.CarSellImagesData;
import com.car.market.entity.CarSellMasterData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CarSellImagesDataRepository extends JpaRepository<CarSellImagesData, Integer> {

    @Query("SELECT c FROM CarSellImagesData c WHERE c.carSellMasterData.carSellId = :carSellId")
    List<CarSellImagesData> findSellImagesByMasterId(@Param("carSellId") Integer carSellId);
}
