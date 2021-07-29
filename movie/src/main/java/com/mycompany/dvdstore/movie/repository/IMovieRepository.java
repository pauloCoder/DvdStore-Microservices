package com.mycompany.dvdstore.movie.repository;

import org.springframework.data.repository.CrudRepository;

import com.mycompany.dvdstore.core.entity.movie.Movie;

public interface IMovieRepository extends CrudRepository<Movie, Long>
{

}