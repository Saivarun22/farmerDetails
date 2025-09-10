package Practice.farmerDetails.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import Practice.farmerDetails.model.Cattle;
import jakarta.transaction.Transactional;

public interface CattleRepository extends JpaRepository <Cattle,Long>{

@Query("Select c from Cattle c")
List<Cattle> getAllCattles();

@Query("Select c from Cattle c Where c.id=:id")
Cattle getCattleById(@Param("id") Long id);

@Modifying
@Transactional
@Query("Update Cattle c set c.noOfCows = :noOfCows, c.noOfBuffaloes = :noOfBuffaloes ,c.noOfGoates = :noOfGoates , c.noOfSheeps = :noOfSheeps where  c.farmer.IEID =:IEID AND c.id = :id")
int updateCattle(@Param("id") Long id,@Param("noOfCows") Integer noOfCows,@Param("noOfBuffaloes") Integer noOfBuffaloes, @Param("noOfGoates") Integer noOfGoates, @Param("noOfSheeps") Integer noOfSheeps, @Param("IEID") Long IEID);

@Modifying
@Transactional
@Query("Delete Cattle c Where c.id=:id")
int deleteCattleById(@Param("id") Long id);

@Modifying
@Transactional
@Query("Update Cattle c set c.noOfCows = :noOfCows, c.noOfBuffaloes = :noOfBuffaloes , c.noOfGoates = :noOfGoates , c.noOfSheeps = :noOfSheeps where c.id =:id")
int patchCattle(@Param("id") Long id, @Param("noOfCows") Integer noOfCows , @Param("noOfBuffaloes") Integer noOfBuffaloes, @Param("noOfGoates") Integer noOfGoates, @Param("noOfSheeps") Integer noOfSheeps);

}














// package Practice.farmerDetails.repository;

// import java.util.List;

// import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.jpa.repository.Modifying;
// import org.springframework.data.jpa.repository.Query;
// import org.springframework.data.repository.query.Param;

// import Practice.farmerDetails.model.Cattle;
// import jakarta.transaction.Transactional;

// public interface CattleRepository extends JpaRepository<Cattle, Long> {

//     @Query("SELECT c FROM Cattle c")
//     List<Cattle> getAllCattles();

//     @Query("SELECT c FROM Cattle c WHERE c.id = :id")
//     Cattle getCattleById(@Param("id") Long id); 

//     @Modifying
//     @Transactional
//     @Query("UPDATE Cattle c SET c.noOfCows = :noOfCows, c.noOfBuffaloes = :noOfBuffaloes,c.noOfGoates = :noOfGoates, c.noOfSheeps = :noOfSheeps WHERE c.farmer.IEID = :IEID AND c.id = :id")
//     int updateCattle(@Param("id") Long id,
//                      @Param("noOfCows") Integer noOfCows,
//                      @Param("noOfBuffaloes") Integer noOfBuffaloes,
//                      @Param("noOfGoates") Integer noOfGoates,
//                      @Param("noOfSheeps") Integer noOfSheeps,
//                      @Param("IEID") Long IEID);

//     @Modifying
//     @Transactional
//     @Query("DELETE FROM Cattle c WHERE c.id = :id")
//     int deleteCattleById(@Param("id") Long id); 

//     @Modifying
//     @Transactional
//     @Query("UPDATE Cattle c SET c.noOfCows = :noOfCows, c.noOfBuffaloes = :noOfBuffaloes,c.noOfGoates = :noOfGoates, c.noOfSheeps = :noOfSheeps WHERE c.id = :id")
//     int patchCattle(@Param("id") Long id,    
//                     @Param("noOfCows") Integer noOfCows,
//                     @Param("noOfBuffaloes") Integer noOfBuffaloes,
//                     @Param("noOfGoates") Integer noOfGoates,
//                     @Param("noOfSheeps") Integer noOfSheeps);
// }
