package com.vti.exception;

import java.util.HashMap;
import java.util.Map;

import javax.security.auth.login.AccountNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.vti.annotation.AccountUserNameNotExists;

@ControllerAdvice
public class ValidationExceptionHandler extends ResponseEntityExceptionHandler {
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException exception,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		Map<String, String> errors = new HashMap<>();

		for (ObjectError error : exception.getBindingResult().getAllErrors()) {
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			errors.put(fieldName, errorMessage);
		}

		return new ResponseEntity<>(errors, status);
	}
	
	@Autowired
	private MessageSource messageSource;
	
	private String getMessage(String key) {
		return messageSource.getMessage(
				key, 
				null, 
				"Default message", 
				LocaleContextHolder.getLocale());
	}

	@ExceptionHandler({ Exception.class })
	public ResponseEntity<Object> handleAll(Exception exception) {
		
		String message = getMessage("Exception.message") != null ? getMessage("Exception.message") : exception.getMessage();
//		String detailMessage = exception.getLocalizedMessage();
//		int code = 1;
//		String moreInformation = "http://localhost:8080/api/v1/exception/1";
//			
//		ErrorResponse response = new ErrorResponse(message, detailMessage, null, code, moreInformation);
			
		if (exception instanceof AccountNotFoundException) {
			message = getMessage("Account.createAccount.form.userName.NotExists");
		}
		
		Map<String, String> mapError = new HashMap();
		mapError.put("error_messager", message);
		
		return new ResponseEntity<>(mapError, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	
}
