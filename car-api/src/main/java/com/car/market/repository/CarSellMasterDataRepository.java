package com.car.market.repository;

import com.car.market.entity.CarSellMasterData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CarSellMasterDataRepository extends JpaRepository<CarSellMasterData, Integer> {

    @Query("SELECT c FROM CarSellMasterData c WHERE c.user.id = :userId")
    List<CarSellMasterData> findCarsByUserId(@Param("userId") Integer userId);
}
