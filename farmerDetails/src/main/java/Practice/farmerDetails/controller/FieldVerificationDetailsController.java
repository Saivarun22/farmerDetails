package Practice.farmerDetails.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import Practice.farmerDetails.dto.FieldVerificationDetailsDTO;
import Practice.farmerDetails.model.FieldVerificationDetails;
import Practice.farmerDetails.service.FieldVerificationDetailsService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/FieldVerificationDetails")
public class FieldVerificationDetailsController {

    @Autowired
    private FieldVerificationDetailsService fieldVerificationDetailsService;


    @GetMapping
    public ResponseEntity<List<FieldVerificationDetails>> getAllFieldVerificationDetails() {
        List<FieldVerificationDetails> details = fieldVerificationDetailsService.getAllFieldVerificationDetails();
        return ResponseEntity.ok(details);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FieldVerificationDetails> getFieldVerificationDetailsById(@Valid @PathVariable Long id) {
        FieldVerificationDetails details = fieldVerificationDetailsService.getFieldVerificationDetailsById(id);
        if (details != null) {
            return ResponseEntity.ok(details);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    
    @PostMapping
    public ResponseEntity<FieldVerificationDetails> createFieldVerificationDetails(@Valid @RequestBody FieldVerificationDetailsDTO dto) {
        FieldVerificationDetails savedDetails = fieldVerificationDetailsService.createFieldVerificationDetails(dto);
        return ResponseEntity.ok(savedDetails);
    }

    
    @PutMapping("/{id}")
    public ResponseEntity<FieldVerificationDetails> updateFieldVerificationDetails(@PathVariable Long id,@Valid @RequestBody FieldVerificationDetails fieldVerificationDetails) {
        FieldVerificationDetails updatedDetails = fieldVerificationDetailsService.updateFieldVerificationDetails(id, fieldVerificationDetails);
        if (updatedDetails != null) {
            return ResponseEntity.ok(updatedDetails);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFieldVerificationDetailsById(@PathVariable Long id) {
        fieldVerificationDetailsService.deleteFieldVerificationDetailsById(id);
        return ResponseEntity.noContent().build();
    }
    
    @PatchMapping("/{id}")
    public ResponseEntity<FieldVerificationDetailsDTO> patchFieldVerificationDetails(@PathVariable Long id,@Valid @RequestBody FieldVerificationDetailsDTO fieldVerificationDetailsPatchDTO) {
        FieldVerificationDetailsDTO patchedDetails = fieldVerificationDetailsService.patchFieldVerificationDeatils(id, fieldVerificationDetailsPatchDTO);
        if (patchedDetails != null) {
            return ResponseEntity.ok(patchedDetails);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
 
    




    



