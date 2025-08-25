package Practice.farmerDetails.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Practice.farmerDetails.model.FieldVerificationDetails;
import Practice.farmerDetails.repository.FieldVerificationDetailsRepository;

@Service
public class FieldVerificationDetailsService {

@Autowired
private FieldVerificationDetailsRepository fieldVerificationDetailsRepository;
    

    public List<FieldVerificationDetails> getAllFieldVerificationDetails(){
        return fieldVerificationDetailsRepository.findAll();
    }

    public FieldVerificationDetails getFieldVerificationDetailsById(Long Id){
        return fieldVerificationDetailsRepository.findById(Id).orElse(null);
    }
      
    public FieldVerificationDetails createFieldVerificationDetails(FieldVerificationDetails fieldVerificationDetails){
        return fieldVerificationDetailsRepository.save(fieldVerificationDetails);
    }

    public FieldVerificationDetails updateFieldVerificationDetails(Long Id, FieldVerificationDetails fieldVerificationDetails){
        FieldVerificationDetails existingDetails = fieldVerificationDetailsRepository.findById(Id).orElse(null);
        if(existingDetails != null){
            
            existingDetails.setLandShownForFieldVerification(fieldVerificationDetails.isLandShownForFieldVerification());
            existingDetails.setAssetCategory(fieldVerificationDetails.getAssetCategory());
            existingDetails.setKhataNo(fieldVerificationDetails.getKhataNo());
            existingDetails.setSurveyNo(fieldVerificationDetails.getSurveyNo());
            existingDetails.setAcres(fieldVerificationDetails.getAcres());
    
            return fieldVerificationDetailsRepository.save(existingDetails);
        }else{
            return null;
        }
    }

    public void deleteFieldVerificationDetailsById(Long Id){
        fieldVerificationDetailsRepository.deleteById(Id);
    


    }
}
