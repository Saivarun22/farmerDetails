package Practice.farmerDetails.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Practice.farmerDetails.dto.CattleDTO;
import Practice.farmerDetails.mapper.CattleMapper;
import Practice.farmerDetails.model.Cattle;
import Practice.farmerDetails.repository.CattleRepository;


@Service

public class CattleService {

    @Autowired
    private CattleRepository cattleRepository;

    public List<Cattle> getAllCattles(){
        return cattleRepository.findAll();
    

    }
    public Cattle getCattleById(Long id){
        return cattleRepository.findById(id).orElse(null);
    }

    public Cattle createCattle(CattleDTO dto){
        Cattle cattle = CattleMapper.toEntity(dto);
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
            if(cattleDTO.getNoOfCows()!=0){
                cattle.setNoOfCows(cattleDTO.getNoOfCows());

            }
            if(cattleDTO.getNoOfBuffaloes()!=0){
                cattle.setNoOfBuffaloes(cattleDTO.getNoOfBuffaloes());

            }
            if(cattleDTO.getNoOfGoates()!=0){
                cattle.setNoOfGoates(cattleDTO.getNoOfGoates());

            }
            if(cattleDTO.getNoOfSheeps()!=0){
                cattle.setNoOfSheeps(cattleDTO.getNoOfSheeps());

            }

            cattleRepository.save(cattle);
            return cattleDTO;
            
        }else{

            return null;

        }


    }
}





