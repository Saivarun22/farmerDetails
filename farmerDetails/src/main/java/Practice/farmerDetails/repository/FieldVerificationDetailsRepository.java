package Practice.farmerDetails.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import Practice.farmerDetails.model.FieldVerificationDetails;

public interface FieldVerificationDetailsRepository extends JpaRepository<FieldVerificationDetails, Long> {

}
