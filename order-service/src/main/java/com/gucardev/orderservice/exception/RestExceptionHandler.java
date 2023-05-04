package com.gucardev.orderservice.exception;

import jakarta.validation.ConstraintViolationException;
import java.util.HashMap;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
@Slf4j
public class RestExceptionHandler {

  /**
   * Handle all exception response entity.
   *
   * @param ex the ex
   * @param request the request
   * @return the response entity
   */
  @ExceptionHandler(Exception.class)
  public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) {
    return ResponseEntity.badRequest().body(ex.getMessage());
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public final ResponseEntity<Object> handleMethodArgumentNotValidEx(
      MethodArgumentNotValidException ex, WebRequest request) {
    return getMapResponseEntity(ex);
  }

  /**
   * Handle constraint violation ex response entity.
   *
   * @param ex the ex
   * @param request the request
   * @return the response entity
   */
  @ExceptionHandler(ConstraintViolationException.class)
  public final ResponseEntity<Object> handleConstraintViolationEx(
      MethodArgumentNotValidException ex, WebRequest request) {
    return getMapResponseEntity(ex);
  }

  private ResponseEntity<Object> getMapResponseEntity(MethodArgumentNotValidException ex) {
    Map<String, String> errors = new HashMap<>();
    ex.getBindingResult()
        .getAllErrors()
        .forEach(
            x -> {
              String fieldName = ((FieldError) x).getField();
              String errorMessage = x.getDefaultMessage();
              errors.put(fieldName, errorMessage);
            });
    return ResponseEntity.badRequest().body(errors);
  }
}
