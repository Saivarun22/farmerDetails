package Practice.farmerDetails.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import Practice.farmerDetails.dto.FarmerDTO;
import Practice.farmerDetails.model.Farmer;
import Practice.farmerDetails.service.FarmerService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/Farmer")
@Tag(name = "Farmer Controller", description = "CRUD operations for Farmer entity")
public class FarmerController {

    @Autowired
    private FarmerService farmerService;

    @Operation(summary = "Get all farmers", description = "Fetches all farmers from the database")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "List of farmers retrieved successfully"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping
    public List<Farmer> getAllFarmers() {
        return farmerService.getAllFarmers();
    }

    @Operation(summary = "Get farmer by ID", description = "Fetches a farmer using their IEID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Farmer found"),
        @ApiResponse(responseCode = "404", description = "Farmer not found")
    })
    @GetMapping("/{IEID}")
    public ResponseEntity<Farmer> getFarmerById(
        @Parameter(description = "Unique identifier of the farmer", example = "1")
        @PathVariable Long IEID) {
        Farmer farmer = farmerService.getFarmerById(IEID);
        return farmer != null ? ResponseEntity.ok(farmer) : ResponseEntity.notFound().build();
    }

    @Operation(summary = "Create a new farmer", description = "Adds a new farmer to the system")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Farmer created successfully"),
        @ApiResponse(responseCode = "400", description = "Invalid input data")
    })
    @PostMapping
    public ResponseEntity<Farmer> createFarmer(
        @Parameter(description = "Farmer data to create")
        @Valid @RequestBody FarmerDTO dto) {
        Farmer savedFarmer = farmerService.createFarmer(dto);
        if (savedFarmer != null) {
            URI location = URI.create("/api/Farmer/" + savedFarmer.getIEID());
            return ResponseEntity.created(location).body(savedFarmer);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @Operation(summary = "Update farmer", description = "Updates an existing farmer's details")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Farmer updated successfully"),
        @ApiResponse(responseCode = "404", description = "Farmer not found")
    })
    @PutMapping("/{IEID}")
    public ResponseEntity<Farmer> updateFarmer(
        @Parameter(description = "Farmer ID to update", example = "1")
        @PathVariable Long IEID,
        @Parameter(description = "Updated farmer data")
        @Valid @RequestBody Farmer farmer) {
        Farmer updatedFarmer = farmerService.updateFarmer(IEID, farmer);
        return updatedFarmer != null ? ResponseEntity.ok(updatedFarmer) : ResponseEntity.notFound().build();
    }

    @Operation(summary = "Delete farmer", description = "Deletes a farmer by their IEID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "Farmer deleted successfully"),
        @ApiResponse(responseCode = "404", description = "Farmer not found")
    })
    @DeleteMapping("/{IEID}")
    public ResponseEntity<Void> deleteFarmer(
        @Parameter(description = "Farmer ID to delete", example = "1")
        @PathVariable Long IEID) {
        Farmer farmer = farmerService.getFarmerById(IEID);
        if (farmer != null) {
            farmerService.deleteFarmerById(IEID);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Patch farmer", description = "Partially updates farmer details")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Farmer updated successfully"),
        @ApiResponse(responseCode = "404", description = "Farmer not found"),
        @ApiResponse(responseCode = "400", description = "Invalid patch data")
    })
    @PatchMapping("/{IEID}")
    public ResponseEntity<FarmerDTO> patchFarmer(
        @Parameter(description = "Farmer ID to patch", example = "1")
        @PathVariable Long IEID,
        @Parameter(description = "Partial farmer data")
        @Valid @RequestBody FarmerDTO farmerDTO) {
        FarmerDTO updatedFarmer = farmerService.patchFarmer(IEID, farmerDTO);
        return updatedFarmer != null ? ResponseEntity.ok(updatedFarmer) : ResponseEntity.notFound().build();
    }
}



//add swagger
//add log