package com.stackroute.movieservice.services;

import java.util.List;

import com.stackroute.movieservice.domain.Movie;
import com.stackroute.movieservice.exceptions.MovieAlreadyExistsException;
import com.stackroute.movieservice.exceptions.MovieNotFoundException;

public interface MovieService {

	// add,update,delete,byId

	public Movie saveMovie(Movie movie) throws MovieAlreadyExistsException;

	public List<Movie> getAllMovies();

	public List<Movie> deleteMovie(Movie movie) throws MovieNotFoundException;

	public Movie updateMovie(Movie movie) throws MovieNotFoundException;

	// public List<Movie> getByMovieAlpha(String searchTerm);

}
