// getsionneur des exception global il va executer les methodes en cas de catcher des exceptions
package org.sid.handlers;

import org.sid.exception.EntityNotFoundException;
import org.sid.exception.ErrorCodes;
import org.sid.exception.InvalidEntityException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@RestControllerAdvice // cette @ contient le requestBody 
public class RestExceptionHandler extends ResponseEntityExceptionHandler { // But: utiliser le model Response Entiy pour
																			// la gestion des exception

	@ExceptionHandler(EntityNotFoundException.class)// pour definir que cette methode utlise la classe EntityNotFoundException
	public ResponseEntity<ErrorDto> handelException(EntityNotFoundException exception, WebRequest webRequest) {

//ici si il ya une exception de type EntityNotFoundException le @resetControllerAdvice va capter l'exception et implementer le logique de cette methode

		final HttpStatus notFound = HttpStatus.NOT_FOUND;
		final ErrorDto errorDto = ErrorDto.builder()
				.errorsCode(exception.getErrorCode())
				.httpCode(notFound.value())
				.message(exception.getMessage())
				.build();
		return new ResponseEntity<>(errorDto, notFound);
	}

	@ExceptionHandler(InvalidEntityException.class)
	public ResponseEntity<ErrorDto> handelException(InvalidEntityException exception, WebRequest webRequest) {

		final HttpStatus badRequest = HttpStatus.BAD_REQUEST;

		final ErrorDto errorDto = ErrorDto.builder()
				.errorsCode(exception.getErrorCode())
				.httpCode(badRequest.value())
				.message(exception.getMessage())
				.errors(exception.getErrors())
				.build();
		return new ResponseEntity<>(errorDto, badRequest);
	}
	  @ExceptionHandler(BadCredentialsException.class)
	  public ResponseEntity<ErrorDto> handleException(BadCredentialsException exception, WebRequest webRequest) {
	    final HttpStatus badRequest = HttpStatus.BAD_REQUEST;

	    final ErrorDto errorDto = ErrorDto.builder()
	        .errorsCode(ErrorCodes.BAD_CREDENTIALS)
	        .httpCode(badRequest.value())
	        .message(exception.getMessage())
	        .errors(java.util.Collections.singletonList("Login et / ou mot de passe incorrecte"))
	        .build();

	    return new ResponseEntity<>(errorDto, badRequest);
	  }
}
