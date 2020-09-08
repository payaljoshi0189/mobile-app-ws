package com.appsdeveloperblog.app.ws.exceptions;



import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.appsdeveloperblog.app.ws.ui.model.response.ErrorMessage;

@ControllerAdvice
public class AppExceptionsHandler {
	
	@ExceptionHandler(value = {Exception.class})
	public ResponseEntity<Object> handleAnyException(Exception ex, WebRequest request){
		
		String errorMessage = ex.getLocalizedMessage();
		
		if(errorMessage == null) errorMessage = ex.toString();
		
		ErrorMessage error = new ErrorMessage(new Date(), ex.getLocalizedMessage());
		
		return new ResponseEntity<>(error, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	@ExceptionHandler(value = {NullPointerException.class, UserServiceException.class})
	public ResponseEntity<Object> handleNullPointerException(NullPointerException ex, WebRequest request){
		
		String errorMessage = ex.getLocalizedMessage();
		
		if(errorMessage == null) errorMessage = ex.toString();
		
		ErrorMessage error = new ErrorMessage(new Date(), ex.getLocalizedMessage());
		
		return new ResponseEntity<>(error, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	

}
