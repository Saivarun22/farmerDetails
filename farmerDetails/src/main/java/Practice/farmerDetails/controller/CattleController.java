package Practice.farmerDetails.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Practice.farmerDetails.dto.CattleDTO;
import Practice.farmerDetails.model.Cattle;
import Practice.farmerDetails.service.CattleService;
import jakarta.validation.Valid;

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

    @GetMapping("/{id}")
    public ResponseEntity<Cattle> getCattleById(@Valid @PathVariable Long id){
        Cattle cattle = cattleService.getCattleById(id);
        if(cattle != null){
            return ResponseEntity.ok(cattle);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Cattle> createCattle(@Valid @RequestBody CattleDTO dto){
        Cattle savedCattle = cattleService.createCattle(dto);
        return ResponseEntity.ok(savedCattle);

    }

    @PutMapping("/{id}")
    public ResponseEntity<Cattle> updateCattle(@PathVariable Long id ,@Valid @RequestBody Cattle cattle){
       Cattle updatedCattle = cattleService.updateCattle( id,cattle);
       return ResponseEntity.ok(updatedCattle);
    }
    

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCattleById(@PathVariable Long id){
        cattleService.deleteCattleById(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<CattleDTO> patchCattle(@PathVariable Long id,@Valid @RequestBody CattleDTO cattlePatchDTO){
        CattleDTO patchCattle = cattleService.patchCattle(id, cattlePatchDTO);
        if(patchCattle != null){
            return ResponseEntity.ok(patchCattle);
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
   

    
    



