package Practice.farmerDetails.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
public class FieldVerificationDetails {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Long Id;
    
    @Column(nullable = false)
    private boolean landShownForFieldVerification;
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @NotNull(message ="Category is required")
    private AssetCategory assetCategory;
   
    @NotBlank(message ="khataNo is required")
    @Size(min=5,max=20 ,message = "khataNo should be between 5 to 20 characters")
    @Pattern(regexp = "^[a-zA-Z0-9]+$",message ="khataNo should contain only alphanumeric characters")
    private String khataNo;
    
    @NotBlank(message ="surveyNo is required")
    @Size(min=5,max=20,message="surveyNo should be between 5 to 20 charaacters")
    @Pattern(regexp="^[a-zA-Z0-9]+$",message="surveyNo should contain only alphanumeric characters")
    private String surveyNo;
    
    
    @Min(value = 0,message ="acers should be a positive number")
    @Column(nullable = false)
    private float acres;
    
    @ManyToOne
    @JoinColumn(name = "Farmer_IEID",nullable =false)
    @JsonBackReference
    private Farmer farmer;







}
