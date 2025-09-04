package Practice.farmerDetails.model;



import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;




@Entity
@Data


public class Cattle {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;


private Integer noOfCows = 0;


private Integer noOfBuffaloes = 0;


private Integer noOfGoates = 0;


private Integer noOfSheeps = 0;

@ManyToOne
@JoinColumn(name ="Farmer_IEID", nullable = false)
@JsonBackReference
private Farmer farmer;
}

