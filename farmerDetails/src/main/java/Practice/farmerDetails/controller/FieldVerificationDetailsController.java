package Practice.farmerDetails.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Practice.farmerDetails.model.FieldVerificationDetails;
import Practice.farmerDetails.service.FieldVerificationDetailsService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;





@RestController
@RequestMapping("/api/FieldVerificationDetails")
public class FieldVerificationDetailsController {

    @Autowired
    private FieldVerificationDetailsService fieldVerificationDetailsService;
    
    @GetMapping
    
    public List<FieldVerificationDetails> getAllFieldVerificationDetails() {
        return fieldVerificationDetailsService.getAllFieldVerificationDetails();

    }

    @GetMapping({"/Id"})

    public FieldVerificationDetails getFieldVerificationDetailsById(@RequestParam Long Id){
        return fieldVerificationDetailsService.getFieldVerificationDetailsById(Id);
    }

    @PostMapping

    public ResponseEntity<FieldVerificationDetails> createFieldVerificationDetails(@RequestBody FieldVerificationDetails fieldVerificationDetails){
        FieldVerificationDetails savedDetails = fieldVerificationDetailsService.createFieldVerificationDetails(fieldVerificationDetails);
        return ResponseEntity.ok(savedDetails);
    
    }

   
    @PutMapping({"/Id"})
    public ResponseEntity<FieldVerificationDetails> updateFieldVerificationDetails(@RequestParam Long Id,@RequestBody FieldVerificationDetails fieldVerificationDetails) {
    FieldVerificationDetails updatedDetails = fieldVerificationDetailsService.updateFieldVerificationDetails(Id, fieldVerificationDetails);
    return ResponseEntity.ok(updatedDetails);
    }

    @DeleteMapping({"/Id"})

    public  ResponseEntity<Void> deleteFieldVerificationDetailsById(@RequestParam Long Id){
        fieldVerificationDetailsService.deleteFieldVerificationDetailsById(Id);
        return ResponseEntity.noContent().build();

    }

}
