package com.hcl.project.exceptions;
import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;



@ControllerAdvice
public class CustomizedExceptionHandling extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(EquipmentNotFound.class)
	public ResponseEntity<Object> handleEquipmentNotFoundException(){
		return new ResponseEntity<Object>("Equipment not found",HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(ItemNotFound.class)
	public ResponseEntity<Object> handleItemNotFoundException(){
		return new ResponseEntity<Object>("Item not found",HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler({UserNotFound.class, NoSuchElementException.class})
	public ResponseEntity<Object> UserNotFoundNotFoundException(){
		return new ResponseEntity<Object>("No such a user ID found",HttpStatus.NOT_FOUND);
	}
	
	
}
