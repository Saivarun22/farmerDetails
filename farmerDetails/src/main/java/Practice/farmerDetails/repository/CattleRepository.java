package Practice.farmerDetails.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Practice.farmerDetails.model.Cattle;

public interface CattleRepository extends JpaRepository <Cattle,Long>{

}
