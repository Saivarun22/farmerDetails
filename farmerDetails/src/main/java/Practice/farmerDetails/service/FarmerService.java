package Practice.farmerDetails.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Practice.farmerDetails.dto.FarmerDTO;
import Practice.farmerDetails.mapper.FarmerMapper;
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

    public Farmer createFarmer(FarmerDTO dto){
        Farmer farmer = FarmerMapper.toEntity(dto);
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

     public FarmerDTO patchFarmer(Long IEID,FarmerDTO farmerDTO){
        Farmer farmer = farmerRepository.findById(IEID).orElse(null);
        if(farmer != null){

            if(farmerDTO.getFullName()!=null){
                farmer.setFullName(farmerDTO.getFullName());
            }
            if(farmerDTO.getDateOfJoining()!=null){
                farmer.setDateOfJoining(farmerDTO.getDateOfJoining());
            }
            if(farmerDTO.getVoName()!=null){
                farmer.setVoName(farmerDTO.getVoName());
            }
            if(farmerDTO.getGender()!=null){
                farmer.setGender(farmerDTO.getGender());
            }
            if(farmerDTO.getSHGName()!=null){
                farmer.setSHGName(farmerDTO.getSHGName());
            }
            if(farmerDTO.getAge()!=0){
                farmer.setAge(farmerDTO.getAge());
            }
            
            if(farmerDTO.getMandal()!=null){
                farmer.setMandal(farmerDTO.getMandal());
            }
            if(farmerDTO.getEducationQualification()!=null){
                farmer.setEducationQualification(farmerDTO.getEducationQualification());
            }
            if(farmerDTO.getCategory()!=null){
                farmer.setCategory(farmerDTO.getCategory());
            }
            if(farmerDTO.getMobileNumber()!=null){
                farmer.setMobileNumber(farmerDTO.getMobileNumber());
            }
            if(farmerDTO.getStatus()!=null){
                farmer.setStatus(farmerDTO.getStatus());
            }

            farmerRepository.save(farmer);
            return farmerDTO;
        }
        else{
            return null;
        }


        }
    
    }


 

