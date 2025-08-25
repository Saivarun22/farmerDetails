package Practice.farmerDetails.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Practice.farmerDetails.model.Farmer;
import Practice.farmerDetails.repository.FarmerRepository;

@Service
public class FarmerService {
    
    @Autowired
    private FarmerRepository farmerRepository;

    public List<Farmer>getAllFarmers(){
        return farmerRepository.findAll();
    }

    public Farmer getFarmerById(Long IEID){
        return farmerRepository.findById(IEID).orElse(null);
    }

    public Farmer createFarmer(Farmer farmer){
        return farmerRepository.save(farmer);
    }

    public Farmer updateFarmer (Long IEID,Farmer farmerDetails){
        Farmer farmer = farmerRepository.findById(IEID).orElse(null);
        if(farmer != null){
            farmer.setFullName( farmerDetails.getFullName());
            farmer.setDateOfJoining (farmerDetails.getDateOfJoining());
            farmer.setVoName(farmerDetails.getVoName());
            farmer.setGender(farmerDetails.getGender());
            farmer.setSHGName(farmerDetails.getSHGName());
            farmer.setAge(farmerDetails.getAge());
            farmer.setFarmerId(farmerDetails.getFarmerId());
            farmer.setMandal(farmerDetails.getMandal());
            farmer.setEducationQualification(farmerDetails.getEducationQualification());
            farmer.setCategory(farmerDetails.getCategory());
            farmer.setMobileNumber(farmerDetails.getMobileNumber());
            farmer.setStatus(farmerDetails.getStatus());
            return farmerRepository.save(farmer);
        }else{
            return null;

        }

    }

    public void deleteFarmerById(Long IEID){
        farmerRepository.deleteById(IEID);
    }



 
}
