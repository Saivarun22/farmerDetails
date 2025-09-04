package Practice.farmerDetails.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)

    public ResponseEntity<Object> handleValidationErrors(MethodArgumentNotValidException ex) {
    Map<String, Object> errorBody = new HashMap<>();
    errorBody.put("timestamp", LocalDateTime.now());
    errorBody.put("status", HttpStatus.BAD_REQUEST.value());
    errorBody.put("error", "Validation Failed");
    errorBody.put("message", "Input validation error");
    errorBody.put("path", "/api/Farmer"); 

    Map<String, String> fieldErrors = new HashMap<>();
    ex.getBindingResult().getFieldErrors().forEach(error ->
        fieldErrors.put(error.getField(), error.getDefaultMessage())
    );
    errorBody.put("trace", fieldErrors);

    return ResponseEntity.badRequest().body(errorBody);
}
    

   
}


