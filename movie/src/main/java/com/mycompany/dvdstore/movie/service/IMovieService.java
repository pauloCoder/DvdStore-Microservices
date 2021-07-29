package com.mycompany.dvdstore.movie.service;

import com.mycompany.dvdstore.core.entity.movie.Movie;

public interface IMovieService 
{
	public Movie registerMovie(Movie movie);
	
	public Iterable<Movie> getMovieList();
	
	public Movie getMovieById(Long id);
}
