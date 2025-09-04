package Practice.farmerDetails.model;

import java.time.LocalDate;
import java.util.List;
import Practice.farmerDetails.model.Category;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;




@Entity
@Data

public class Farmer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long IEID;
    
    @NotBlank(message = "Full name is required")
    private String fullName;
    
    @NotNull(message = "dateOfJoining is required")
    private LocalDate dateOfJoining;
    
    @NotBlank(message = "voName is required")
    private String voName;
    
    @NotBlank(message = "gender is required")
    private String gender;
    
    @NotBlank(message = "sHGName is required")
    private String sHGName;
    
    @Min(value =18, message = "age should be at least 18")
    @Max(value =100,message = "age should not be more than 100")
    private int age;
    
    
    
    @NotBlank(message = "mandal is required")
    private String mandal;
    
    @NotBlank(message = "EducationQualification is required")
    private String educationQualification;
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @NotNull(message = "Category is required")
    private Category category;
    
    @NotBlank(message="mobile number should not be blank")
    @Pattern(regexp = "^[0-9]{10}$",message = "Mobile number must be 10 digits")
    private String mobileNumber;
    
    @NotNull(message = "status is required")
    private Boolean status;


    @OneToMany(mappedBy ="farmer" ,cascade = CascadeType.ALL)
    private List<FieldVerificationDetails>fieldVerificationDetails;

    @OneToMany(mappedBy = "farmer",cascade = CascadeType.ALL)
    private List<Cattle> cattle;

    






}
