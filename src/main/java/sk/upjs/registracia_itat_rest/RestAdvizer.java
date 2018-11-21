package sk.upjs.registracia_itat_rest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;

import sk.upjs.registracia_itat.persitent.ParticipantNotFoundException;

@ControllerAdvice
public class RestAdvizer {

	@ExceptionHandler(NumberFormatException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public ApiError handleNumberFormatException(NumberFormatException e) {
		return new ApiError(HttpStatus.BAD_REQUEST.value(), 
				"Participant id must be a number");
	}
	
	@ExceptionHandler(ParticipantNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ResponseBody
	public ApiError handleParticipantNotFoundException(ParticipantNotFoundException e) {
		return new ApiError(HttpStatus.NOT_FOUND.value(), "Participant with id " 
				+ e.getParticipantId() + " does not exists");
	}
	
	@ExceptionHandler(HttpMessageNotReadableException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public ApiError handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
		return new ApiError(HttpStatus.BAD_REQUEST.value(), 
				"Participant not in right format: " + e.getMessage());
	}

	@ExceptionHandler(DaoException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public ApiError handleDaoException(DaoException e) {
		return new ApiError(HttpStatus.BAD_REQUEST.value(), 
				"Participant not in right format: " + e.getCause().getMessage());
	}

}
