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
private Long Id;


private int noOfCows = 0;


private int noOfBuffaloes = 0;


private int noOfGoats = 0;


private int noOfSheeps = 0;

@ManyToOne
@JoinColumn(name ="Farmer_IEID",referencedColumnName = "IEID", nullable = false)
@JsonBackReference
private Farmer farmer;
}

