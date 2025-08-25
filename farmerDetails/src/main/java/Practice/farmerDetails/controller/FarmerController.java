package Practice.farmerDetails.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import Practice.farmerDetails.model.Farmer;
import Practice.farmerDetails.service.FarmerService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;





@RestController
@RequestMapping("/api/Farmer")
public class FarmerController {
    
    @Autowired
    private FarmerService farmerService;
    
    @GetMapping
    public List<Farmer> getAllFarmers(){
        return  farmerService.getAllFarmers();

    }

    @GetMapping("/{IEID}")
    public ResponseEntity<Farmer> getFarmerById(@PathVariable Long IEID){
        Farmer farmer = farmerService.getFarmerById(IEID);
        if(farmer != null){
            return ResponseEntity.ok(farmer);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Farmer> createFarmer(@RequestBody Farmer farmer){
        Farmer SavedFramer = farmerService.createFarmer(farmer);
        return ResponseEntity.ok(SavedFramer);
    }

    @PutMapping("/{IEID}")
    public ResponseEntity<Farmer> updateFarmer(@PathVariable Long IEID , @RequestBody Farmer farmer){
       Farmer updatedFarmer = farmerService.updateFarmer(IEID, farmer);
       if(updatedFarmer != null){
        return ResponseEntity.ok(updatedFarmer);
       }else{
        return ResponseEntity.notFound().build();
       }
       
    }

    @DeleteMapping("/{IEID}")
    public ResponseEntity<Void> deleteFarmer(@PathVariable Long IEID){
        Farmer farmer =farmerService.getFarmerById(IEID);
        if(farmer != null){
            farmerService.deleteFarmerById(IEID);
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.notFound().build();
        }

    
           
        
    }

}

//add custom sql
//add patch method
