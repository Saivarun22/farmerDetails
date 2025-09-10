package Practice.farmerDetails.model;

import java.time.LocalDate;
import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import Practice.farmerDetails.model.Category;
import Practice.farmerDetails.model.Cattle;
import Practice.farmerDetails.model.FieldVerificationDetails;

@Entity
@Table(name = "farmer")
@Data
@Schema(description = "Entity representing a Farmer in the system")
public class Farmer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Unique identifier for the farmer", example = "1")
    private Long IEID;

    @NotBlank(message = "Full name is required")
    @Schema(description = "Full name of the farmer", example = "Ravi Kumar")
    private String fullName;

    @NotNull(message = "dateOfJoining is required")
    @Schema(description = "Date the farmer joined the program", example = "2023-06-15")
    private LocalDate dateOfJoining;

    @NotBlank(message = "voName is required")
    @Schema(description = "Village Organization name", example = "VO Sunrise")
    private String voName;

    @NotBlank(message = "gender is required")
    @Schema(description = "Gender of the farmer", example = "Female")
    private String gender;

    @NotBlank(message = "sHGName is required")
    @Schema(description = "Self Help Group name", example = "SHG GreenFields")
    private String sHGName;

    @Min(value = 18, message = "age should be at least 18")
    @Max(value = 100, message = "age should not be more than 100")
    @Schema(description = "Age of the farmer", example = "42")
    private int age;

    @NotBlank(message = "mandal is required")
    @Schema(description = "Mandal or administrative region", example = "Guntur East")
    private String mandal;

    @NotBlank(message = "EducationQualification is required")
    @Schema(description = "Educational qualification", example = "Intermediate")
    private String educationQualification;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @NotNull(message = "Category is required")
    @Schema(description = "Caste category of the farmer", example = "C1,C4,C5")
    private Category category;

    @NotBlank(message = "mobile number should not be blank")
    @Pattern(regexp = "^[0-9]{10}$", message = "Mobile number must be 10 digits")
    @Schema(description = "Mobile number of the farmer", example = "9876543210")
    private String mobileNumber;

    @NotNull(message = "status is required")
    @Schema(description = "Active status of the farmer", example = "true")
    private Boolean status;

    @OneToMany(mappedBy = "farmer", cascade = CascadeType.ALL)
    @JsonManagedReference
    @Schema(description = "List of field verification details associated with the farmer")
    private List<FieldVerificationDetails> fieldVerificationDetails;

    @OneToMany(mappedBy = "farmer", cascade = CascadeType.ALL)
    @JsonManagedReference
    @Schema(description = "List of cattle owned by the farmer")
    private List<Cattle> cattle;
}


