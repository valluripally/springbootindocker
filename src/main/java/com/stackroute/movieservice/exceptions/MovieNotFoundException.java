package com.stackroute.movieservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(HttpStatus.NOT_FOUND)
public class MovieNotFoundException extends Exception {
	public MovieNotFoundException(String s) {
		// Call constructor of parent Exception
		super(s);
	}

}
