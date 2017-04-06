package com.navaneeth.counter.exceptionhandler;

import java.net.HttpURLConnection;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class CounterApiErrorHandler {
  
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public String processValidationError(Exception ex) {
    	StringBuffer sb=new StringBuffer();
    	sb.append ("HTTP Status-Code :");
    	sb.append(HttpURLConnection.HTTP_BAD_REQUEST );
    	sb.append("Invalid Request :");
    	sb.append(ex.getMessage());
		return sb.toString();	
    }
 
 }