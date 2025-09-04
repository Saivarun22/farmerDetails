package Practice.farmerDetails.mapper;

import Practice.farmerDetails.dto.FieldVerificationDetailsDTO;
import Practice.farmerDetails.model.FieldVerificationDetails;
import lombok.Builder;

@Builder
public class FieldVerificationDetailsMapper {

    public static FieldVerificationDetailsDTO toDTO(FieldVerificationDetails fieldVerificationDetails){
        if(fieldVerificationDetails == null) return null;
        
        // fieldVerificationDetails to FieldVerificationDetailsDTO
        FieldVerificationDetailsDTO dto = new FieldVerificationDetailsDTO();
        dto.setId(fieldVerificationDetails.getId());
        dto.setLandShownForFieldVerification(fieldVerificationDetails.getLandShownForFieldVerification());
        dto.setAssetCategory(fieldVerificationDetails.getAssetCategory());
        dto.setKhataNo(fieldVerificationDetails.getKhataNo());
        dto.setSurveyNo(fieldVerificationDetails.getSurveyNo());
        dto.setAcres(fieldVerificationDetails.getAcres());
        return dto;
    }

    public static FieldVerificationDetails toEntity (FieldVerificationDetailsDTO dto){
        if(dto == null ) return null;

        // FieldVerificationDetailsDTO to fieldVerificationDetails
        FieldVerificationDetails fieldVerificationDetails = new FieldVerificationDetails();
        fieldVerificationDetails.setId(dto.getId());
        fieldVerificationDetails.setLandShownForFieldVerification(dto.getLandShownForFieldVerification());
        fieldVerificationDetails.setAssetCategory(dto.getAssetCategory());
        fieldVerificationDetails.setKhataNo(dto.getKhataNo());
        fieldVerificationDetails.setSurveyNo(dto.getSurveyNo());
        fieldVerificationDetails.setAcres(dto.getAcres());
        return fieldVerificationDetails;

    }

}
