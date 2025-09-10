package Practice.farmerDetails.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "cattle")
@Data
@Schema(description = "Entity representing livestock details owned by a farmer")
public class Cattle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Unique identifier for the cattle record", example = "1")
    private Long id;

    @Schema(description = "Number of cows owned by the farmer", example = "2")
    private Integer noOfCows = 0;

    @Schema(description = "Number of buffaloes owned by the farmer", example = "1")
    private Integer noOfBuffaloes = 0;

    @Schema(description = "Number of goats owned by the farmer", example = "3")
    private Integer noOfGoates = 0;

    @Schema(description = "Number of sheep owned by the farmer", example = "4")
    private Integer noOfSheeps = 0;

    @ManyToOne
    @JoinColumn(name = "Farmer_IEID", nullable = false)
    @JsonBackReference
    @Schema(description = "Reference to the owning farmer entity")
    private Farmer farmer;
}

