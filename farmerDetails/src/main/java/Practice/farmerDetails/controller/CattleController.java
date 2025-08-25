package Practice.farmerDetails.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Practice.farmerDetails.model.Cattle;
import Practice.farmerDetails.service.CattleService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/Cattle")

public class CattleController {

    @Autowired
    private CattleService cattleService;

    @GetMapping
    public List<Cattle> getAllCattles(){
        return  cattleService.getAllCattles();

    }

    @GetMapping("/{Id}")
    public ResponseEntity<Cattle> getCattleById(@PathVariable Long Id){
        Cattle cattle = cattleService.getCattleById(Id);
        if(cattle != null){
            return ResponseEntity.ok(cattle);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Cattle> createCattle(@RequestBody Cattle cattle){
        Cattle savedCattle = cattleService.createCattle(cattle);
        return ResponseEntity.ok(savedCattle);

    }

    @PutMapping
    public ResponseEntity<Cattle> updateCattle(@RequestBody Cattle cattle){
       Cattle updatedCattle = cattleService.createCattle(cattle);
       return ResponseEntity.ok(updatedCattle);
    }

    @DeleteMapping("/{Id}")
    public ResponseEntity<Void> deleteCattleById(@PathVariable Long Id){
        cattleService.deleteCattleById(Id);
        return ResponseEntity.noContent().build();
    }
   
}
    
    



