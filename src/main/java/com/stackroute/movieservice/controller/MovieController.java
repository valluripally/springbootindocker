package com.stackroute.movieservice.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.movieservice.domain.Movie;
import com.stackroute.movieservice.exceptions.MovieAlreadyExistsException;
import com.stackroute.movieservice.exceptions.MovieNotFoundException;
import com.stackroute.movieservice.services.MovieService;

@RestController
@RequestMapping(value = "/api/v1")
public class MovieController {

	 MovieService movieservice;
	 Logger logger =LoggerFactory.getLogger("mv controller");
//	public MovieController() {
//		// TODO Auto-generated constructor stub
//	}

	@Autowired
	public MovieController(MovieService movieservice) {
		this.movieservice = movieservice;
	}

	// ---------------------save movie-------------------------
	@RequestMapping(value = "/movie", method = RequestMethod.POST, produces = { "application/json" })
	public ResponseEntity<?> saveMovieHandler(@RequestBody Movie movie) throws MovieAlreadyExistsException {
		Movie movieobj = new Movie();
		try {
			movieobj = movieservice.saveMovie(movie);
			return new ResponseEntity<Movie>(movieobj, HttpStatus.OK);
		} catch (MovieAlreadyExistsException e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_IMPLEMENTED);
		}

	}

	// ------------------get all--------------------------------
	@RequestMapping(value = "/movies", method = RequestMethod.GET, produces = { "application/json" })
	public ResponseEntity<List<Movie>> allMoviesHandler() {
		List<Movie> movielist = movieservice.getAllMovies();
		
		logger.debug("debugging1");
		logger.error("error1");
		logger.info("info1");
		logger.warn("warn1");
		logger.trace("trace1");
		return new ResponseEntity<List<Movie>>(movielist, HttpStatus.OK);
	}

	// -------------------delete------------------------------------
	@RequestMapping(value = "/delete", method = RequestMethod.DELETE, produces = { "application/json" })
	public ResponseEntity<?> deleteHandler(@RequestBody Movie movie) {
		List<Movie> movielistdel;
		try {
			movielistdel = movieservice.deleteMovie(movie);
			return new ResponseEntity<List<Movie>>(movielistdel, HttpStatus.ACCEPTED);
		} catch (MovieNotFoundException e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}

	// -------------------update-----------------------------------
	@RequestMapping(value = "/update", method = RequestMethod.PUT, produces = { "application/json" })
	public ResponseEntity<?> updateHandler(@RequestBody Movie movie) throws MovieNotFoundException {

		Movie updated;
		try {
			updated = movieservice.updateMovie(movie);
			return new ResponseEntity<Movie>(updated, HttpStatus.OK);
		} catch (MovieNotFoundException e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}

	// @RequestMapping(value = "/search/{term}", method = RequestMethod.PUT,
	// produces = { "application/json" })
	// public ResponseEntity<?> getAlphaHandler(@PathVariable("term") String
	// searchTerm) {
	// List<Movie> movielistalpha = movieservice.getByMovieAlpha(searchTerm);
	// return new ResponseEntity<List<Movie>>(movielistalpha, HttpStatus.OK);

}
