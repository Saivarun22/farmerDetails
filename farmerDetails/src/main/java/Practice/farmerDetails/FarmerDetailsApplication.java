package Practice.farmerDetails;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
    info = @Info(title = "Farmer API", version = "1.0", description = "API for managing farmers")
)

@SpringBootApplication
public class FarmerDetailsApplication {

	public static void main(String[] args) {
		SpringApplication.run(FarmerDetailsApplication.class, args);
	}

}
