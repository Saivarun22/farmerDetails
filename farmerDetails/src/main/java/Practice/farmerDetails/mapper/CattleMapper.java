package Practice.farmerDetails.mapper;

import Practice.farmerDetails.dto.CattleDTO;
import Practice.farmerDetails.model.Cattle;
import lombok.Builder;

@Builder
public class CattleMapper {

    public static CattleDTO toDTO(Cattle cattle){
        if(cattle == null) return null;

        CattleDTO dto = new CattleDTO();
        dto.setId(cattle.getId());
        dto.setNoOfCows(cattle.getNoOfCows());
        dto.setNoOfBuffaloes(cattle.getNoOfBuffaloes());
        dto.setNoOfGoates(cattle.getNoOfGoates());
        dto.setNoOfSheeps(cattle.getNoOfSheeps());
        return dto;

    }

    public static Cattle toEntity(CattleDTO dto){
        if(dto == null) return null;

        Cattle cattle = new Cattle();
        cattle.setId(dto.getId());
        cattle.setNoOfCows(dto.getNoOfCows());
        cattle.setNoOfBuffaloes(dto.getNoOfBuffaloes());
        cattle.setNoOfGoates(dto.getNoOfGoates());
        cattle.setNoOfSheeps(dto.getNoOfSheeps());
        return cattle;
    }

}
