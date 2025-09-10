package Practice.farmerDetails.dto;

import lombok.Data;
import io.swagger.v3.oas.annotations.media.Schema;

@Data
@Schema(description = "DTO representing livestock details owned by a farmer")
public class CattleDTO {

    @Schema(description = "Unique identifier for the cattle record", example = "8")
    private Long id;

    @Schema(description = "Number of cows owned by the farmer", example = "2")
    private Integer noOfCows = 0;

    @Schema(description = "Number of buffaloes owned by the farmer", example = "1")
    private Integer noOfBuffaloes = 0;

    @Schema(description = "Number of goats owned by the farmer", example = "3")
    private Integer noOfGoates = 0;

    @Schema(description = "Number of sheep owned by the farmer", example = "4")
    private Integer noOfSheeps = 0;

    @Schema(description = "Farmer IEID to associate this cattle record with", example = "1")
    private Long IEID;
}

