package com.mycompany.dvdstore.movie.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.EntityGraph.EntityGraphType;
import org.springframework.data.repository.CrudRepository;

import com.mycompany.dvdstore.core.entity.movie.Movie;


public interface IMovieRepository extends CrudRepository<Movie, Long>
{
	
	@EntityGraph(value = "movie-actors" , type = EntityGraphType.FETCH)
	public Optional<Movie> findById(Long id);
}