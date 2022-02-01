package com.diginamic.bibliorest.bibliorest.controllerRest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.diginamic.bibliorest.bibliorest.exceptions.ErreurClient;

/**
 * C'est le controleur générale "catch" des exceptions de mon serveur API REST
 * 
 * @author Steeve
 *
 */
@RestControllerAdvice
public class ErreurGeneraleController
{
	@ExceptionHandler(value =
	{Exception.class})
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public String errorGeneralException(Exception e)
	{
		String message = "Il y a une erreur : " + e.getMessage();
		return message;
	}

	@ExceptionHandler(value =
	{ErreurClient.class})
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public String errorClientException(ErreurClient e)
	{
		String message = "Erreur liée au Client " + e.getMessage();
		return message;
	}
}
