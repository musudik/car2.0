 package com.car.market.controller;

 import com.car.market.entity.CarSellDocumentsData;
 import com.car.market.entity.CarSellImagesData;
 import com.car.market.entity.CarSellMasterData;
 import com.car.market.entity.User;
 import com.car.market.service.AuthenticationService;
 import com.car.market.service.CarSellService;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.http.ResponseEntity;
 import org.springframework.web.bind.annotation.GetMapping;
 import org.springframework.web.bind.annotation.PathVariable;
 import org.springframework.web.bind.annotation.PostMapping;
 import org.springframework.web.bind.annotation.RequestBody;
 import org.springframework.web.bind.annotation.RequestMapping;
 import org.springframework.web.bind.annotation.RestController;

 import java.util.List;

 @RestController
@RequestMapping("/car-market/sell")
public class CarSellController {

    @Autowired
    private CarSellService carSellService;

    @Autowired
    private AuthenticationService authenticationService;

    @GetMapping("/")
    public ResponseEntity<List<CarSellMasterData>> getAllSellingCars() {
        List <CarSellMasterData> sellingCars = carSellService.getAllSellingCars();
        sellingCars.forEach(cs -> cs.setCarSellImages(carSellService.getSellImagesByMasterId(cs.getCarSellId())));
        sellingCars.forEach(cs -> cs.setCarSellDocuments(carSellService.getSellDocumentsByMasterId(cs.getCarSellId())));
        return ResponseEntity.ok(sellingCars);
    }

     @GetMapping("/getAllSellingCarsByUser/{id}")
     public ResponseEntity<List<CarSellMasterData>> getAllSellingCarsByUser(@PathVariable("id") Integer id) {
         List <CarSellMasterData> sellingCars = carSellService.getSellingCarsByUser(id);
         sellingCars.forEach(cs -> cs.setCarSellImages(carSellService.getSellImagesByMasterId(cs.getCarSellId())));
         sellingCars.forEach(cs -> cs.setCarSellDocuments(carSellService.getSellDocumentsByMasterId(cs.getCarSellId())));
         return ResponseEntity.ok(sellingCars);
     }

    @GetMapping("/getSellImagesByMasterId/{carSellId}")
    public ResponseEntity<List<CarSellImagesData>> getSellImagesByMasterId(@PathVariable("carSellId") Integer carSellId) {
        List <CarSellImagesData> sellImagesData = carSellService.getSellImagesByMasterId(carSellId);
        return ResponseEntity.ok(sellImagesData);
    }

     @GetMapping("/getSellDocumentsByMasterId/{carSellId}")
     public ResponseEntity<List<CarSellDocumentsData>> getSellDocumentsByMasterId(@PathVariable("carSellId") Integer carSellId) {
         List <CarSellDocumentsData> sellImagesData = carSellService.getSellDocumentsByMasterId(carSellId);
         return ResponseEntity.ok(sellImagesData);
     }

    @PostMapping("/add")
    public ResponseEntity<Object> addCarSell(@RequestBody CarSellMasterData carSellMasterData) {
        User user = authenticationService.getUserById(carSellMasterData.getUser().getId()).orElse(null);
        if(user != null) {
            try {
                CarSellMasterData masterData = carSellService.saveCarSellData(carSellMasterData, carSellMasterData.getCarSellImages(), carSellMasterData.getCarSellDocuments());
                return ResponseEntity.ok(masterData);
            } catch (Exception e) {
                throw new RuntimeException("Failed to save the car sell details: "+e.getMessage());
            }
        } else {
            return ResponseEntity.ok("User Does not exists with Id: "+carSellMasterData.getUser().getId());
        }
    }
}
