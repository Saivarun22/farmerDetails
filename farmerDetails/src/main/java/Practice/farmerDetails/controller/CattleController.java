package Practice.farmerDetails.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import Practice.farmerDetails.dto.CattleDTO;
import Practice.farmerDetails.model.Cattle;
import Practice.farmerDetails.service.CattleService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/Cattle")
@Tag(name = "Cattle Controller", description = "CRUD operations for Cattle entity")
public class CattleController {

    @Autowired
    private CattleService cattleService;

    @Operation(summary = "Get all cattle", description = "Fetches all cattle records from the database")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "List of cattle retrieved successfully"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping
    public ResponseEntity<List<Cattle>> getAllCattles() {
        List<Cattle> cattles = cattleService.getAllCattles();
        return ResponseEntity.ok(cattles);
    }

    @Operation(summary = "Get cattle by ID", description = "Fetches a specific cattle record using its ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Cattle found"),
        @ApiResponse(responseCode = "404", description = "Cattle not found")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Cattle> getCattleById(
        @Parameter(description = "ID of the cattle record", example = "1")
        @PathVariable Long id) {
        Cattle cattle = cattleService.getCattleById(id);
        return cattle != null ? ResponseEntity.ok(cattle) : ResponseEntity.notFound().build();
    }

    @Operation(summary = "Create a new cattle record", description = "Adds a new cattle entry to the system")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Cattle created successfully"),
        @ApiResponse(responseCode = "400", description = "Invalid input data")
    })
    @PostMapping
    public ResponseEntity<Cattle> createCattle(
        @Parameter(description = "Cattle data to create")
        @Valid @RequestBody CattleDTO dto) {
        Cattle savedCattle = cattleService.createCattle(dto);
        if (savedCattle != null) {
            URI location = URI.create("/api/Cattle/" + savedCattle.getId());
            return ResponseEntity.created(location).body(savedCattle);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @Operation(summary = "Update cattle record", description = "Updates an existing cattle entry")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Cattle updated successfully"),
        @ApiResponse(responseCode = "404", description = "Cattle not found")
    })
    @PutMapping("/{id}")
    public ResponseEntity<Cattle> updateCattle(
        @Parameter(description = "ID of the cattle record to update", example = "1")
        @PathVariable Long id,
        @Parameter(description = "Updated cattle data")
        @Valid @RequestBody Cattle cattle) {
        Cattle updatedCattle = cattleService.updateCattle(id, cattle);
        return updatedCattle != null ? ResponseEntity.ok(updatedCattle) : ResponseEntity.notFound().build();
    }

    @Operation(summary = "Delete cattle record", description = "Deletes a cattle entry by ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "Cattle deleted successfully"),
        @ApiResponse(responseCode = "404", description = "Cattle not found")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCattleById(
        @Parameter(description = "ID of the cattle record to delete", example = "1")
        @PathVariable Long id) {
        Cattle existing = cattleService.getCattleById(id);
        if (existing != null) {
            cattleService.deleteCattleById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Patch cattle record", description = "Partially updates cattle details")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Cattle patched successfully"),
        @ApiResponse(responseCode = "404", description = "Cattle not found"),
        @ApiResponse(responseCode = "400", description = "Invalid patch data")
    })
    @PatchMapping("/{id}")
    public ResponseEntity<CattleDTO> patchCattle(
        @Parameter(description = "ID of the cattle record to patch", example = "1")
        @PathVariable Long id,
        @Parameter(description = "Partial cattle data")
        @Valid @RequestBody CattleDTO cattlePatchDTO) {
        CattleDTO patchedCattle = cattleService.patchCattle(id, cattlePatchDTO);
        return patchedCattle != null ? ResponseEntity.ok(patchedCattle) : ResponseEntity.notFound().build();
    }
}