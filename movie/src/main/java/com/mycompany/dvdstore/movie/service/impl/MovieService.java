package com.mycompany.dvdstore.movie.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.mycompany.dvdstore.core.entity.movie.Movie;
import com.mycompany.dvdstore.movie.repository.IMovieRepository;
import com.mycompany.dvdstore.movie.service.IMovieService;

@Service
public class MovieService implements IMovieService
{
	
	@Autowired
	private IMovieRepository movieRepository;
	
	public IMovieRepository getMovieRepository() {
		return movieRepository;
	}

	public void setMovieRepository(IMovieRepository movieRepository) {
		this.movieRepository = movieRepository;
	}

	@Override
	public Movie getMovieById(Long id) {
				
		return movieRepository.findById(id).orElseThrow( () -> 
							new ResponseStatusException(HttpStatus.NOT_FOUND));	    
	}

	@Override
	public Movie registerMovie(Movie movie) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Movie> getMovieList() {
		return Optional.ofNullable(movieRepository.findAll()).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}

}
