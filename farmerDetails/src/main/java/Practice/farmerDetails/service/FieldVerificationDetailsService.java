package Practice.farmerDetails.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import Practice.farmerDetails.controller.FieldVerificationDetailsController;
import Practice.farmerDetails.dto.FieldVerificationDetailsDTO;
import Practice.farmerDetails.mapper.FieldVerificationDetailsMapper;
import Practice.farmerDetails.model.FieldVerificationDetails;
import Practice.farmerDetails.repository.FieldVerificationDetailsRepository;


@Service

public class FieldVerificationDetailsService {

    private final FieldVerificationDetailsController fieldVerificationDetailsController;

@Autowired
private FieldVerificationDetailsRepository fieldVerificationDetailsRepository;


    FieldVerificationDetailsService(FieldVerificationDetailsController fieldVerificationDetailsController) {
        this.fieldVerificationDetailsController = fieldVerificationDetailsController;
    }
    

    public List<FieldVerificationDetails> getAllFieldVerificationDetails(){
        return fieldVerificationDetailsRepository.findAll();
    }

    public FieldVerificationDetails getFieldVerificationDetailsById(Long id){
        return fieldVerificationDetailsRepository.findById(id).orElse(null);
    }
      
    public FieldVerificationDetails createFieldVerificationDetails(FieldVerificationDetailsDTO dto){
        FieldVerificationDetails fieldVerificationDetails = FieldVerificationDetailsMapper.toEntity(dto);
        return fieldVerificationDetailsRepository.save(fieldVerificationDetails);
    }

    public FieldVerificationDetails updateFieldVerificationDetails(Long id, FieldVerificationDetails fieldVerificationDetails){
        FieldVerificationDetails existingDetails = fieldVerificationDetailsRepository.findById(id).orElse(null);
        if(existingDetails != null){
            
            existingDetails.setLandShownForFieldVerification(fieldVerificationDetails.getLandShownForFieldVerification());
            existingDetails.setAssetCategory(fieldVerificationDetails.getAssetCategory());
            existingDetails.setKhataNo(fieldVerificationDetails.getKhataNo());
            existingDetails.setSurveyNo(fieldVerificationDetails.getSurveyNo());
            existingDetails.setAcres(fieldVerificationDetails.getAcres());
    
            return fieldVerificationDetailsRepository.save(existingDetails);
        }else{
            return null;
        }
    }

    public void deleteFieldVerificationDetailsById(Long id){
        fieldVerificationDetailsRepository.deleteById(id);
    }

    public FieldVerificationDetailsDTO patchFieldVerificationDeatils(Long id,FieldVerificationDetailsDTO fieldVerificationDetailsDTO){
        FieldVerificationDetails fieldVerificationDetails = fieldVerificationDetailsRepository.findById(id).orElse(null);
        if(fieldVerificationDetails != null){
            if(fieldVerificationDetailsDTO.getLandShownForFieldVerification() != null){
                fieldVerificationDetails.setLandShownForFieldVerification(fieldVerificationDetailsDTO.getLandShownForFieldVerification());

            }
            if(fieldVerificationDetailsDTO.getAssetCategory()!=null){
                fieldVerificationDetails.setAssetCategory(fieldVerificationDetailsDTO.getAssetCategory());
            
            }
            if(fieldVerificationDetailsDTO.getKhataNo()!=null){
                fieldVerificationDetails.setKhataNo(fieldVerificationDetailsDTO.getKhataNo());
            
            }
            if(fieldVerificationDetailsDTO.getSurveyNo()!=null){
                fieldVerificationDetails.setSurveyNo(fieldVerificationDetailsDTO.getSurveyNo());
           
            }
            if(fieldVerificationDetailsDTO.getAcres()!=0){
                fieldVerificationDetails.setAcres(fieldVerificationDetailsDTO.getAcres());

            }
            fieldVerificationDetailsRepository.save(fieldVerificationDetails);
            return fieldVerificationDetailsDTO;
        }
        else{
            return null;
        }

    }
}


