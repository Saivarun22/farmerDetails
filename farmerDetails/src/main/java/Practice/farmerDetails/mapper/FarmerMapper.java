
package Practice.farmerDetails.mapper;

import Practice.farmerDetails.dto.FarmerDTO;
import Practice.farmerDetails.model.Farmer;
import lombok.Builder;


@Builder
public class FarmerMapper {

    // Convert Farmer entity to FarmerDTO
    public static FarmerDTO toDTO(Farmer farmer) {
        if (farmer == null) return null;

        FarmerDTO dto = new FarmerDTO();
        dto.setIEID(farmer.getIEID());
        dto.setFullName(farmer.getFullName());
        dto.setDateOfJoining(farmer.getDateOfJoining());
        dto.setVoName(farmer.getVoName());
        dto.setGender(farmer.getGender());
        dto.setSHGName(farmer.getSHGName());
        dto.setAge(farmer.getAge());
        dto.setMandal(farmer.getMandal());
        dto.setEducationQualification(farmer.getEducationQualification());
        dto.setCategory(farmer.getCategory());
        dto.setMobileNumber(farmer.getMobileNumber());
        dto.setStatus(farmer.getStatus());
        return dto;
    }

    // Convert FarmerDTO to Farmer entity
    public static Farmer toEntity(FarmerDTO dto) {
        if (dto == null) return null;

        Farmer farmer = new Farmer();
        farmer.setIEID(dto.getIEID());
        farmer.setFullName(dto.getFullName());
        farmer.setDateOfJoining(dto.getDateOfJoining());
        farmer.setVoName(dto.getVoName());
        farmer.setGender(dto.getGender());
        farmer.setSHGName(dto.getSHGName());
        farmer.setAge(dto.getAge());
        farmer.setMandal(dto.getMandal());
        farmer.setEducationQualification(dto.getEducationQualification());
        farmer.setCategory(dto.getCategory());
        farmer.setMobileNumber(dto.getMobileNumber());
        farmer.setStatus(dto.getStatus());
        return farmer;
    }

}
