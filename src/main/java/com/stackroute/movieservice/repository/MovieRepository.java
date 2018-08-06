package com.stackroute.movieservice.repository;

import org.springframework.data.repository.CrudRepository;

import com.stackroute.movieservice.domain.Movie;

//import org.springframework.data.mongodb.repository.MongoRepository;


public interface MovieRepository extends CrudRepository<Movie,Integer> {
	
}
