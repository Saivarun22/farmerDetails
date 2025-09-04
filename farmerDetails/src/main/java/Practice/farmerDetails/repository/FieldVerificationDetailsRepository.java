package Practice.farmerDetails.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import Practice.farmerDetails.model.AssetCategory;
import Practice.farmerDetails.model.FieldVerificationDetails;
import jakarta.transaction.Transactional;

public interface FieldVerificationDetailsRepository extends JpaRepository<FieldVerificationDetails, Long> {

@Query("Select fv from FieldVerificationDetails fv")
List<FieldVerificationDetails> getAllFieldVerificationDetails();

@Query("Select fv from FieldVerificationDetails fv Where fv.id=:id")
FieldVerificationDetails getFieldVerificationDetailsById(@Param("Id") Long id);

@Modifying
@Transactional
@Query("Update FieldVerificationDetails fv set fv.landShownForFieldVerification = :landShownForFieldVerification , fv.assetCategory = :assetCategory , fv.khataNo = :khataNo , fv.surveyNo = :surveyNo , fv.acres = :acres where fv.farmer.IEID =:IEID AND fv.id = :id")
int updateFieldVerificationDetails (@Param("id") Long id , @Param("landShownForFieldVerification") Boolean landShownForFieldVerification , @Param("assetCategory") AssetCategory assetCategory , @Param("khataNo") String khataNo , @Param("surveyNo") String surveyNo , @Param("acres") Float acres , @Param("IEID") Long IEID);

@Modifying
@Transactional
@Query("Delete from FieldVerificationDetails fv where fv.id= :id")
int deleteFieldVerificationDetailsById(@Param("id") Long id);

@Modifying
@Transactional
@Query("Update FieldVerificationDetails fv set fv.landShownForFieldVerification = :landShownForFieldVerification , fv.assetCategory = :assetCategory , fv.khataNo = :khataNo , fv.surveyNo = :surveyNo , fv.acres = :acres where fv.id = :id")
int patchFieldVerificationDetails (@Param("id") Long id , @Param("landShownForFieldVerification") Boolean landShownForFieldVerification , @Param("assetCategory") AssetCategory assetCategory , @Param("khataNo") String khataNo , @Param("surveyNo") String surveyNo , @Param("acres") Float acres );
}
