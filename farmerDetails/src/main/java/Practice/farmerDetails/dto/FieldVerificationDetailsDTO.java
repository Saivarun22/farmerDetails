package Practice.farmerDetails.dto;

import Practice.farmerDetails.model.AssetCategory;
import Practice.farmerDetails.model.Farmer;
import lombok.Data;


@Data

public class FieldVerificationDetailsDTO {

    private Long id;
    private Boolean landShownForFieldVerification;
    private AssetCategory assetCategory;
    private String khataNo;
    private String surveyNo;
    private float acres;
    
    private Long IEID;
}
