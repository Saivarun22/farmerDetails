package Practice.farmerDetails.repository;

import java.time.LocalDate;
import java.util.List;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import Practice.farmerDetails.model.Farmer;
import jakarta.transaction.Transactional;
import Practice.farmerDetails.model.Category;

public interface FarmerRepository extends JpaRepository <Farmer,Long>{
     
   @Query("Select f from Farmer f")
   List<Farmer> getAllFarmer();

   @Query("Select f From Farmer f where f.IEID =:IEID")
   Farmer getFarmerById(@Param("IEID")Long IEID);

   @Modifying
   @Transactional
   @Query("Update Farmer f set f.fullName =:fullName , f.dateOfJoining =:dateOfJoining , f.voName =:voName , f.gender =:gender , f.sHGName =:sHGName , f.age =:age , f.mandal =:mandal , f.educationQualification =:educationQualification , f.category =:category , f.mobileNumber =:mobileNumber , f.status =:status where f.IEID = :IEID")
   int updateFarmer(@Param("fullName") String fullName , @Param("dateOfJoining") LocalDate dateOfJoining , @Param("voName") String voName , @Param("gender") String gender , @Param("sHGName") String sHGName , @Param("age") Integer age , @Param("mandal") String mandal , @Param("educationQualification") String educationQualification , @Param("category") Category category , @Param("mobileNumber") String mobileNumber , @Param("status") Boolean status , @Param("IEID") Long IEID);
   
   @Modifying
   @Transactional
   @Query("Delete  From Farmer f where f.IEID =:IEID")
   void deleteFarmer(@Param("IEID") Long IEID);

   @Modifying
   @Transactional
   @Query("Update Farmer f set f.fullName =:fullName , f.dateOfJoining =:dateOfJoining , f.voName =:voName , f.gender =:gender , f.sHGName =:sHGName , f.age =:age , f.mandal =:mandal , f.educationQualification =:educationQualification , f.category =:category , f.mobileNumber =:mobileNumber , f.status =:status where f.IEID = :IEID")
   int patchFarmer(@Param("fullName") String fullName , @Param("dateOfJoining") LocalDate dateOfJoining , @Param("voName") String voName , @Param("gender") String gender , @Param("sHGName") String sHGName , @Param("age") Integer age , @Param("mandal") String mandal , @Param("educationQualification") String educationQualification , @Param("category") Category category , @Param("mobileNumber") String mobileNumber , @Param("status") Boolean status , @Param("IEID") Long IEID);
   

    

    


    

}





















// package Practice.farmerDetails.repository;

// import java.time.LocalDate;
// import java.util.List;

// import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.jpa.repository.Modifying;
// import org.springframework.data.jpa.repository.Query;
// import org.springframework.data.repository.query.Param;

// import Practice.farmerDetails.model.Farmer;
// import jakarta.transaction.Transactional;
// import Practice.farmerDetails.model.Category;

// public interface FarmerRepository extends JpaRepository<Farmer, Long> {
     
//     @Query("SELECT f FROM Farmer f")
//     List<Farmer> getAllFarmer();

//     @Query("SELECT f FROM Farmer f WHERE f.IEID = :IEID")
//     Farmer getFarmerById(@Param("IEID") Long IEID);

//     @Modifying
//     @Transactional
//     @Query("UPDATE Farmer f SET f.fullName = :fullName, " +
//            "f.dateOfJoining = :dateOfJoining, " +
//            "f.voName = :voName, " +
//            "f.gender = :gender, " +
//            "f.sHGName = :sHGName, " +       // ✅ fixed (removed space)
//            "f.age = :age, " +
//            "f.mandal = :mandal, " +
//            "f.educationQualification = :educationQualification, " +
//            "f.category = :category, " +
//            "f.mobileNumber = :mobileNumber, " +
//            "f.status = :status " +
//            "WHERE f.IEID = :IEID")
//     int updateFarmer(@Param("fullName") String fullName,
//                      @Param("dateOfJoining") LocalDate dateOfJoining,
//                      @Param("voName") String voName,
//                      @Param("gender") String gender,
//                      @Param("sHGName") String sHGName,
//                      @Param("age") Integer age,
//                      @Param("mandal") String mandal,
//                      @Param("educationQualification") String educationQualification,
//                      @Param("category") Category category,
//                      @Param("mobileNumber") String mobileNumber,
//                      @Param("status") Boolean status,
//                      @Param("IEID") Long IEID);

//     @Modifying
//     @Transactional
//     @Query("DELETE FROM Farmer f WHERE f.IEID = :IEID")
//     void deleteFarmer(@Param("IEID") Long IEID);

//     @Modifying
//     @Transactional
//     @Query("UPDATE Farmer f SET f.fullName = :fullName, " +
//            "f.dateOfJoining = :dateOfJoining, " +
//            "f.voName = :voName, " +
//            "f.gender = :gender, " +
//            "f.sHGName = :sHGName, " +       // ✅ fixed (removed space)
//            "f.age = :age, " +
//            "f.mandal = :mandal, " +
//            "f.educationQualification = :educationQualification, " +
//            "f.category = :category, " +
//            "f.mobileNumber = :mobileNumber, " +
//            "f.status = :status " +
//            "WHERE f.IEID = :IEID")
//     int patchFarmer(@Param("fullName") String fullName,
//                     @Param("dateOfJoining") LocalDate dateOfJoining,
//                     @Param("voName") String voName,
//                     @Param("gender") String gender,
//                     @Param("sHGName") String sHGName,
//                     @Param("age") Integer age,
//                     @Param("mandal") String mandal,
//                     @Param("educationQualification") String educationQualification,
//                     @Param("category") Category category,
//                     @Param("mobileNumber") String mobileNumber,
//                     @Param("status") Boolean status,
//                     @Param("IEID") Long IEID);
// }
