package com.stackroute.movieservice.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
import com.stackroute.movieservice.domain.Movie;
import com.stackroute.movieservice.repository.MovieRepository;

@Configuration
public class BootStrapData implements ApplicationListener<ContextRefreshedEvent> {
	private MovieRepository movieRepository;

	@Autowired
	public BootStrapData(MovieRepository movieRepository) {
		// super();
		this.movieRepository = movieRepository;
		// this.movie = movie;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
//		Movie movie = new Movie();
//		movie.setMovieId("1");
//		movieRepository.save(movie);
//		Movie testMovie = Movie.builder().movieId(1).movieName("asdf").movieDesc("asdf").movieYear(2012);
//		movieRepository.save(testMovie);
		Logger logger =LoggerFactory.getLogger("Bootstrapdata");
		logger.debug("debugging");
		logger.error("error");
		logger.info("info");
		logger.warn("warn");
		logger.trace("trace");
	}
}