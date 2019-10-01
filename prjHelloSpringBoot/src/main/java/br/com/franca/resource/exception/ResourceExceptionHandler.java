package br.com.franca.resource.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.franca.service.exception.ObjectNotFoundException;
/**
 * 
 * @author rfranca
 * Handler responsável por interceptar o resource caso ocorra uma exception e o handler que irá lançar a resposta http adequada;
 * intercepta as exceptions
 * StandartError contem o erro 
 * HttpServletRequest informações da requisição
 */

@ControllerAdvice
public class ResourceExceptionHandler {
	 
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandartError> objectNotFoundException(ObjectNotFoundException e,
			HttpServletRequest request) {
		StandartError err = new StandartError(HttpStatus.NOT_FOUND.value(), e.getMessage(), System.currentTimeMillis());		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<StandartError> validation(MethodArgumentNotValidException e,
			HttpServletRequest request) {
		StandartError err = new StandartError(HttpStatus.NOT_FOUND.value(), e.getMessage(), System.currentTimeMillis());		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
	}
}
