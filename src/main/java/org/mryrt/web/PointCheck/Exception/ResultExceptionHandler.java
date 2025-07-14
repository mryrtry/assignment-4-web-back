package org.mryrt.web.PointCheck.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ResultExceptionHandler {

    @ExceptionHandler(InvalidResultUpload.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(InvalidResultUpload ex) {
        Map<String, String> errors = new HashMap<>();
        errors.put("params", ex.getExCause());
        errors.put("timestamp", LocalDateTime.now().toString());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<HashMap<String, String>> handleHttpMessageNotReadableException(HttpMessageNotReadableException ex) {
        HashMap<String, String> errors = new HashMap<>();
        errors.put("params:", "Invalid JSON format");
        errors.put("timestamp", LocalDateTime.now().toString());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }

}