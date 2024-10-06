package com.car.market.service;

import com.car.market.entity.CarSellDocumentsData;
import com.car.market.entity.CarSellImagesData;
import com.car.market.entity.CarSellMasterData;
import com.car.market.repository.CarSellDocumentsDataRepository;
import com.car.market.repository.CarSellImagesDataRepository;
import com.car.market.repository.CarSellMasterDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CarSellService {

    @Autowired
    private CarSellMasterDataRepository carSellMasterDataRepository;

    @Autowired
    private CarSellImagesDataRepository carSellImagesDataRepository;

    @Autowired
    private CarSellDocumentsDataRepository carSellDocumentsDataRepository;

    @Transactional
    public CarSellMasterData saveCarSellData(CarSellMasterData carSellMasterData, List<CarSellImagesData> images, List<CarSellDocumentsData> documents) {
        // Save CarSellMasterData first
        CarSellMasterData savedCarSellMaster = carSellMasterDataRepository.save(carSellMasterData);
        // Save related CarSellImagesData with reference to the saved CarSellMasterData
        List<CarSellImagesData> savedImages = carSellImagesDataRepository.saveAll(images);
        List<CarSellDocumentsData> savedDocuments = carSellDocumentsDataRepository.saveAll(documents);

        savedCarSellMaster.setCarSellImages(savedImages);
        savedCarSellMaster.setCarSellDocuments(savedDocuments);

        return savedCarSellMaster; // Return the saved CarSellMasterData with its relationships
    }


    public List<CarSellMasterData> getAllSellingCars() {
        return carSellMasterDataRepository.findAll();
    }

    public List<CarSellMasterData> getSellingCarsByUser(Integer id) {
        return carSellMasterDataRepository.findCarsByUserId(id);
    }

    public CarSellMasterData saveCarSellMasterData(CarSellMasterData carSellMasterData) {
        return carSellMasterDataRepository.save(carSellMasterData);
    }

    public List<CarSellImagesData> getSellImages() {
        return carSellImagesDataRepository.findAll();
    }

    public List<CarSellImagesData> getSellImagesByMasterId(Integer id) {
        return carSellImagesDataRepository.findSellImagesByMasterId(id);
    }

    public List<CarSellDocumentsData> getSellDocumentsByMasterId(Integer id) {
        return carSellDocumentsDataRepository.findSellDocumentsByMasterId(id);
    }
}