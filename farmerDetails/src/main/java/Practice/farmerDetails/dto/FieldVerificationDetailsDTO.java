package Practice.farmerDetails.dto;

import Practice.farmerDetails.model.AssetCategory;
import lombok.Data;
import io.swagger.v3.oas.annotations.media.Schema;

@Data
@Schema(description = "DTO representing field verification details for a farmer")
public class FieldVerificationDetailsDTO {

    @Schema(description = "Unique identifier for the field verification record", example = "1")
    private Long id;

    @Schema(description = "Whether land was shown for field verification", example = "true")
    private Boolean landShownForFieldVerification;

    @Schema(description = "Asset category of the land", example = "LAND_OWNED")
    private AssetCategory assetCategory;

    @Schema(description = "Khata number of the land", example = "KH12345")
    private String khataNo;

    @Schema(description = "Survey number of the land", example = "SV98765")
    private String surveyNo;

    @Schema(description = "Size of the land in acres", example = "2.5")
    private float acres;

    @Schema(description = "Farmer IEID to associate this record with", example = "1")
    private Long IEID;
}
