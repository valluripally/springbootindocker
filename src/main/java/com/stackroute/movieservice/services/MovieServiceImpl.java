package com.stackroute.movieservice.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.movieservice.domain.Movie;
import com.stackroute.movieservice.exceptions.MovieAlreadyExistsException;
import com.stackroute.movieservice.exceptions.MovieNotFoundException;
import com.stackroute.movieservice.repository.MovieRepository;

@Service
public class MovieServiceImpl implements MovieService {

	 MovieRepository movierepo;

//	public MovieServiceImpl() {
//
//	}

	@Autowired
	public MovieServiceImpl(MovieRepository movierepo) {
		this.movierepo = movierepo;

	}

	// ----------------savemovie-------------------------
	@Override
	public Movie saveMovie(Movie movie) throws MovieAlreadyExistsException {
		Movie obj = null;
		int local = movie.getMovieId();
		if (movierepo.existsById(local) != true) {
			obj = movierepo.save(movie);
			return obj;
		} else {
			throw new MovieAlreadyExistsException("Movie already exits ");
		}

	}

	// ---------------------getall-------------------------

	@Override

	public List<Movie> getAllMovies() {
		// TODO Auto-generated method stub
		List<Movie> movielist = (List<Movie>) movierepo.findAll();
		return movielist;
	}

	// ------------------------------------------delete------------------------
	@Override
	public List<Movie> deleteMovie(Movie movie) throws MovieNotFoundException {
		int local = movie.getMovieId();
		List<Movie> listobj;
		if (movierepo.existsById(local) == true) {
			movierepo.deleteById(local);
			listobj = (List<Movie>) movierepo.findAll();
		} else {
			throw new MovieNotFoundException("Movie not found");
		}
		return listobj;
	}

	// --------------update movie---------------------------------
	@Override
	public Movie updateMovie(Movie movie) throws MovieNotFoundException {
		Movie obj = null;
		int local = movie.getMovieId();
		if (movierepo.existsById(local) == true) {
			Optional<Movie> movielocal = movierepo.findById(local); // setMovieName(movie.getMovieName());
			obj = movielocal.get();
			obj.setMovieName(movie.getMovieName());
			return obj;
		} else {
			throw new MovieNotFoundException("Notfound");
		}
	}

	// @Override
	// public List<Movie> getByMovieAlpha(String searchTerm) {
	// List<Movie> alphalist = movierepo.getByMovieAlpha(searchTerm);
	// return alphalist;
	// }

	// ----------------get-byId-----------------------------------------

}
// ------------junk---------------------------
// @Override
// public List<Movie> deleteMovie(MovieId movieid) {
// List<Movie> listobj ;
// int local = movieid;
// if(movierepo.existsById(movieid)==true) {
// movierepo.deleteById(movieid);
// listobj = (List<Movie>) movierepo.findAll();
// }else {
// listobj = (List<Movie>) movierepo.findAll();
// }
// return listobj;
