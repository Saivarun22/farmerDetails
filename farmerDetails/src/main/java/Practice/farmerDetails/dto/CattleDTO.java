package Practice.farmerDetails.dto;

import lombok.Data;

@Data

public class CattleDTO {
    private Long id;
    private Integer noOfCows =0;
    private Integer noOfBuffaloes = 0;
    private Integer noOfGoates = 0;
    private Integer noOfSheeps = 0;

    private Long IEID;
    

}
