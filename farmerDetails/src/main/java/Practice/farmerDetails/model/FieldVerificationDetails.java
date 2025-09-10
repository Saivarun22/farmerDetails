package Practice.farmerDetails.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Table(name = "field_verification_details")
@Data
@Schema(description = "Entity representing field verification details for a farmer")
public class FieldVerificationDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Unique identifier for the field verification record", example = "1")
    private Long id;

    @Column(nullable = false)
    @Schema(description = "Whether land was shown for field verification", example = "true")
    private Boolean landShownForFieldVerification;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @NotNull(message = "Category is required")
    @Schema(description = "Asset category of the land", example = "AGRICULTURAL")
    private AssetCategory assetCategory;

    @NotBlank(message = "khataNo is required")
    @Size(min = 5, max = 20, message = "khataNo should be between 5 to 20 characters")
    @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "khataNo should contain only alphanumeric characters")
    @Schema(description = "Khata number of the land", example = "KH12345")
    private String khataNo;

    @NotBlank(message = "surveyNo is required")
    @Size(min = 5, max = 20, message = "surveyNo should be between 5 to 20 characters")
    @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "surveyNo should contain only alphanumeric characters")
    @Schema(description = "Survey number of the land", example = "SV98765")
    private String surveyNo;

    @Min(value = 0, message = "acers should be a positive number")
    @Column(nullable = false)
    @Schema(description = "Size of the land in acres", example = "2.5")
    private float acres;

    @ManyToOne
    @JoinColumn(name = "Farmer_IEID", nullable = false)
    @JsonBackReference
    @Schema(description = "Reference to the owning farmer entity")
    private Farmer farmer;
}