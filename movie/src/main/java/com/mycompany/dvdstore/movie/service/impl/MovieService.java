package com.mycompany.dvdstore.movie.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import com.mycompany.dvdstore.core.entity.movie.Movie;
import com.mycompany.dvdstore.core.entity.review.Review;
import com.mycompany.dvdstore.movie.repository.IMovieRepository;
import com.mycompany.dvdstore.movie.service.IMovieService;

@Service
public class MovieService implements IMovieService
{
	
	@Autowired
	private IMovieRepository movieRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	public IMovieRepository getMovieRepository() {
		return movieRepository;
	}

	public void setMovieRepository(IMovieRepository movieRepository) {
		this.movieRepository = movieRepository;
	}

	@Override
	public Movie getMovieById(Long id) {
		
		String url = "http://localhost:9005/review/movie/";
		
		Movie movie = movieRepository.findById(id).orElseThrow( () -> 
							new ResponseStatusException(HttpStatus.NOT_FOUND));
		ResponseEntity<Review[]> responseEntity = restTemplate.getForEntity(url + movie.getId(), Review[].class);
		
		List<Review> reviews = Arrays.asList(responseEntity.getBody());
		movie.setReviews(reviews);
		return movie;
	    
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
