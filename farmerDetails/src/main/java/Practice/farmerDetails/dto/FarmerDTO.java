package Practice.farmerDetails.dto;

import lombok.Data;


import java.time.LocalDate;
import java.util.List;

import Practice.farmerDetails.model.Category;

@Data

public class FarmerDTO {
    private Long IEID;
    private String fullName;
    private LocalDate dateOfJoining;
    private String voName;
    private String gender;
    private String sHGName;
    private Integer age;
    private String mandal;
    private String educationQualification;
    private Category category;
    private String mobileNumber;
    private Boolean status;
    

    private List<FieldVerificationDetailsDTO> fieldVerificationDetailsPatchDTO;
    private List<CattleDTO> cattlePatchDTOs;
}
