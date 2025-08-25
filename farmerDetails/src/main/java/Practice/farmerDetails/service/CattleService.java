package Practice.farmerDetails.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Practice.farmerDetails.model.Cattle;
import Practice.farmerDetails.repository.CattleRepository;

@Service
public class CattleService {

    @Autowired
    private CattleRepository cattleRepository;

    public List<Cattle> getAllCattles(){
        return cattleRepository.findAll();
    

    }
    public Cattle getCattleById(Long Id){
        return cattleRepository.findById(Id).orElse(null);
    }

    public Cattle createCattle(Cattle cattle){
        return cattleRepository.save(cattle);
    }

    public Cattle updateCattle (Long Id,Cattle cattleDetails){
        Cattle cattle = cattleRepository.findById(Id).orElse(null);
        if(cattle != null){
            cattle.setNoOfCows( cattleDetails.getNoOfCows());
            cattle.setNoOfBuffaloes(cattleDetails.getNoOfBuffaloes());
            cattle.setNoOfGoats(cattleDetails.getNoOfGoats());
            cattle.setNoOfSheeps(cattleDetails.getNoOfSheeps());
            return cattleRepository.save(cattle);
        }else{
            return null;
        }
    }

    public void deleteCattleById(Long Id){
        cattleRepository.deleteById(Id);
    }

}


