package Practice.farmerDetails.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import Practice.farmerDetails.dto.FieldVerificationDetailsDTO;
import Practice.farmerDetails.model.FieldVerificationDetails;
import Practice.farmerDetails.service.FieldVerificationDetailsService;

import jakarta.validation.Valid;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/api/FieldVerificationDetails")
@Tag(name = "Field Verification Controller", description = "CRUD operations for Field Verification Details")
public class FieldVerificationDetailsController {

    @Autowired
    private FieldVerificationDetailsService fieldVerificationDetailsService;

    @Operation(summary = "Get all field verification records", description = "Fetches all field verification details from the database")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "List retrieved successfully"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping
    public ResponseEntity<List<FieldVerificationDetails>> getAllFieldVerificationDetails() {
        List<FieldVerificationDetails> details = fieldVerificationDetailsService.getAllFieldVerificationDetails();
        return ResponseEntity.ok(details);
    }

    @Operation(summary = "Get field verification record by ID", description = "Fetches a specific field verification record using its ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Record found"),
        @ApiResponse(responseCode = "404", description = "Record not found")
    })
    @GetMapping("/{id}")
    public ResponseEntity<FieldVerificationDetails> getFieldVerificationDetailsById(
        @Parameter(description = "ID of the field verification record", example = "1")
        @PathVariable Long id) {
        FieldVerificationDetails details = fieldVerificationDetailsService.getFieldVerificationDetailsById(id);
        return details != null ? ResponseEntity.ok(details) : ResponseEntity.notFound().build();
    }

    @Operation(summary = "Create a new field verification record", description = "Adds a new field verification entry to the system")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Record created successfully"),
        @ApiResponse(responseCode = "400", description = "Invalid input data")
    })
    @PostMapping
    public ResponseEntity<FieldVerificationDetails> createFieldVerificationDetails(
        @Parameter(description = "Field verification data to create")
        @Valid @RequestBody FieldVerificationDetailsDTO dto) {
        FieldVerificationDetails savedDetails = fieldVerificationDetailsService.createFieldVerificationDetails(dto);
        if (savedDetails != null) {
            URI location = URI.create("/api/FieldVerificationDetails/" + savedDetails.getId());
            return ResponseEntity.created(location).body(savedDetails);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @Operation(summary = "Update field verification record", description = "Updates an existing field verification entry")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Record updated successfully"),
        @ApiResponse(responseCode = "404", description = "Record not found")
    })
    @PutMapping("/{id}")
    public ResponseEntity<FieldVerificationDetails> updateFieldVerificationDetails(
        @Parameter(description = "ID of the field verification record to update", example = "1")
        @PathVariable Long id,
        @Parameter(description = "Updated field verification data")
        @Valid @RequestBody FieldVerificationDetails fieldVerificationDetails) {
        FieldVerificationDetails updatedDetails = fieldVerificationDetailsService.updateFieldVerificationDetails(id, fieldVerificationDetails);
        return updatedDetails != null ? ResponseEntity.ok(updatedDetails) : ResponseEntity.notFound().build();
    }

    @Operation(summary = "Delete field verification record", description = "Deletes a field verification entry by ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "Record deleted successfully"),
        @ApiResponse(responseCode = "404", description = "Record not found")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFieldVerificationDetailsById(
        @Parameter(description = "ID of the field verification record to delete", example = "1")
        @PathVariable Long id) {
        fieldVerificationDetailsService.deleteFieldVerificationDetailsById(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Patch field verification record", description = "Partially updates field verification details")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Record patched successfully"),
        @ApiResponse(responseCode = "404", description = "Record not found"),
        @ApiResponse(responseCode = "400", description = "Invalid patch data")
    })
    @PatchMapping("/{id}")
    public ResponseEntity<FieldVerificationDetailsDTO> patchFieldVerificationDetails(
        @Parameter(description = "ID of the field verification record to patch", example = "1")
        @PathVariable Long id,
        @Parameter(description = "Partial field verification data")
        @Valid @RequestBody FieldVerificationDetailsDTO fieldVerificationDetailsPatchDTO) {
        FieldVerificationDetailsDTO patchedDetails = fieldVerificationDetailsService.patchFieldVerificationDeatils(id, fieldVerificationDetailsPatchDTO);
        return patchedDetails != null ? ResponseEntity.ok(patchedDetails) : ResponseEntity.notFound().build();
    }
}