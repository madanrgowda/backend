package backend1.app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import backend1.app.response.ResoponseStructure;

@ControllerAdvice

public class Exceptioncontroller {
	@ExceptionHandler(value = myexception.class)
	public ResponseEntity<ResoponseStructure<String>> idNotFound(myexception ie) {
		ResoponseStructure<String> responseStructure = new ResoponseStructure<String>();
		responseStructure.setCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessgae("Request failed");
		responseStructure.setData(ie.toString());
		return new ResponseEntity<ResoponseStructure<String>>(responseStructure, HttpStatus.NOT_ACCEPTABLE);


	}

}
