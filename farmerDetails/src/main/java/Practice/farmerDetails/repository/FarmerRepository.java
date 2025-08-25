package Practice.farmerDetails.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Practice.farmerDetails.model.Farmer;

public interface FarmerRepository extends JpaRepository <Farmer,Long>{


    

}
