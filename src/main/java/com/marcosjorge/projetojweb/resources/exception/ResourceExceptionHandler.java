package com.marcosjorge.projetojweb.resources.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpServerErrorException;

import javassist.tools.rmi.ObjectNotFoundException;

public class ResourceExceptionHandler {

		public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServerErrorException request){
			StandardError erro = new StandardError(HttpStatus.NOT_FOUND.value(), e.getMessage(), System.currentTimeMillis());
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
		} 
}
