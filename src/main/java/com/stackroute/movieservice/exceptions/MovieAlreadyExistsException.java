package com.stackroute.movieservice.exceptions;

@SuppressWarnings("serial")
public class MovieAlreadyExistsException extends Exception {

	public MovieAlreadyExistsException(String s) {
		// Call constructor of parent Exception
		super(s);
	}
}
