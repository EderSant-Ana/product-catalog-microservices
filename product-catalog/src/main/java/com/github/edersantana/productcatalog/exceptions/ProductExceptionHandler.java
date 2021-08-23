package com.github.edersantana.productcatalog.exceptions;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProductExceptionHandler {

@ExceptionHandler(ProductAlreadyRegisteredException.class)
public ResponseEntity<StandardError> alreadyRegisteredMessage(ProductAlreadyRegisteredException e, HttpServletRequest request){
	
	StringWriter errors = new StringWriter();
	e.printStackTrace(new PrintWriter(errors));
	
	StandardError err = new StandardError();
	err.setTimestamp(ZonedDateTime.now().format(DateTimeFormatter.ISO_INSTANT));
	err.setStatus(HttpStatus.BAD_REQUEST.value());
	err.setError(HttpStatus.BAD_REQUEST.getReasonPhrase());
	err.setTrace(errors.toString());
	err.setMessage(e.getMessage());
	err.setPath(request.getServletPath());
	return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);		
}

@ExceptionHandler(ProductNotFoundException.class)
public ResponseEntity<StandardError> notFoundMessage(ProductNotFoundException e, HttpServletRequest request){
	
	StringWriter errors = new StringWriter();
	e.printStackTrace(new PrintWriter(errors));
	
	StandardError err = new StandardError();
	err.setTimestamp(ZonedDateTime.now().format(DateTimeFormatter.ISO_INSTANT));
	err.setStatus(HttpStatus.NOT_FOUND.value());
	err.setError(HttpStatus.NOT_FOUND.getReasonPhrase());
	err.setTrace(errors.toString());
	err.setMessage(e.getMessage());
	err.setPath(request.getServletPath());
	return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
}

}
