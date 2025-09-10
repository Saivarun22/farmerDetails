package Practice.farmerDetails.dto;

import lombok.Data;
import java.time.LocalDate;
import java.util.List;

import Practice.farmerDetails.model.Category;
import io.swagger.v3.oas.annotations.media.Schema;

@Data
@Schema(description = "Data Transfer Object representing a Farmer")
public class FarmerDTO {

    @Schema(description = "Unique identifier for the farmer", example = "1")
    private Long IEID;

    @Schema(description = "Full name of the farmer", example = "Rajeshwari")
    private String fullName;

    @Schema(description = "Date the farmer joined the program", example = "2023-06-15")
    private LocalDate dateOfJoining;

    @Schema(description = "Name of the Village Organization", example = "VO Sunrise")
    private String voName;

    @Schema(description = "Gender of the farmer", example = "female")
    private String gender;

    @Schema(description = "Self Help Group name", example = "gayathri")
    private String sHGName;

    @Schema(description = "Age of the farmer", example = "42")
    private Integer age;

    @Schema(description = "Mandal or administrative region", example = "Guntur East")
    private String mandal;

    @Schema(description = "Educational qualification", example = "Intermediate")
    private String educationQualification;

    @Schema(description = "Caste category of the farmer")
    private Category category;

    @Schema(description = "Mobile number of the farmer", example = "9876543210")
    private String mobileNumber;

    @Schema(description = "Active status of the farmer", example = "true")
    private Boolean status;

    @Schema(description = "List of field verification details for PATCH operations")
    private List<FieldVerificationDetailsDTO> fieldVerificationDetailsPatchDTO;

    @Schema(description = "List of cattle details for PATCH operations")
    private List<CattleDTO> cattlePatchDTOs;
}

