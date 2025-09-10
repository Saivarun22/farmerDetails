package Practice.farmerDetails.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Practice.farmerDetails.dto.CattleDTO;
import Practice.farmerDetails.mapper.CattleMapper;
import Practice.farmerDetails.model.Cattle;
import Practice.farmerDetails.model.Farmer;
import Practice.farmerDetails.repository.CattleRepository;
import Practice.farmerDetails.repository.FarmerRepository;


@Service

public class CattleService {

    @Autowired
    private CattleRepository cattleRepository;
    @Autowired
    private FarmerRepository farmerRepository;

    public List<Cattle> getAllCattles(){
        return cattleRepository.findAll();
    

    }
    public Cattle getCattleById(Long id){
        return cattleRepository.findById(id).orElse(null);
    }


    public Cattle createCattle(CattleDTO dto) {
     // Convert DTO → Entity
     Cattle cattle = CattleMapper.toEntity(dto);

     // Find Farmer using IEID from DTO
     Farmer farmer = farmerRepository.findById(dto.getIEID())
            .orElseThrow(() -> new RuntimeException("Farmer not found with IEID: " + dto.getIEID()));

     // Set farmer into cattle
     cattle.setFarmer(farmer);

     // Save cattle
     return cattleRepository.save(cattle);
    }


    public Cattle updateCattle (Long id,Cattle cattleDetails){
        Cattle cattle = cattleRepository.findById(id).orElse(null);
        if(cattle != null){
            cattle.setNoOfCows( cattleDetails.getNoOfCows());
            cattle.setNoOfBuffaloes(cattleDetails.getNoOfBuffaloes());
            cattle.setNoOfGoates(cattleDetails.getNoOfGoates());
            cattle.setNoOfSheeps(cattleDetails.getNoOfSheeps());
            return cattleRepository.save(cattle);
        }else{
            return null;
        }
    }

    public void deleteCattleById(Long id){
        cattleRepository.deleteById(id);
    }

    public CattleDTO patchCattle(Long id, CattleDTO cattleDTO){
        Cattle cattle = cattleRepository.findById(id).orElse(null);
        if(cattle != null){
            if(cattleDTO.getNoOfCows()!=null){
                cattle.setNoOfCows(cattleDTO.getNoOfCows());

            }
            if(cattleDTO.getNoOfBuffaloes()!=null){
                cattle.setNoOfBuffaloes(cattleDTO.getNoOfBuffaloes());

            }
            if(cattleDTO.getNoOfGoates()!=null){
                cattle.setNoOfGoates(cattleDTO.getNoOfGoates());

            }
            if(cattleDTO.getNoOfSheeps()!=null){
                cattle.setNoOfSheeps(cattleDTO.getNoOfSheeps());

            }

            cattleRepository.save(cattle);
            return cattleDTO;
            
        }else{

            return null;

        }


    }
}





