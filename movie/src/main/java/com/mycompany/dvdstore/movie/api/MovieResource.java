package com.mycompany.dvdstore.movie.api;


import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.mycompany.dvdstore.core.entity.movie.Movie;
import com.mycompany.dvdstore.core.entity.review.Review;
import com.mycompany.dvdstore.movie.service.IMovieService;

@RestController
@RequestMapping("/movie")
public class MovieResource 
{
	@Autowired
	private IMovieService movieService;
	
	@Autowired
	private RestTemplate restTemplate;
	
	public IMovieService getMovieService() {
		return movieService;
	}

	public void setMovieService(IMovieService movieService) {
		this.movieService = movieService;
	}

	@GetMapping("/{id}")
	public Movie get(@PathVariable("id") Long id)
	{
		String url = "http://review-service/review/byMovie/";
		Movie movie = movieService.getMovieById(id);
		ResponseEntity<Review[]> responseEntity = restTemplate.getForEntity(url + movie.getId(), Review[].class);
		
		List<Review> reviews = Arrays.asList(responseEntity.getBody());
		movie.setReviews(reviews);
		return movie;
	}
	
	@GetMapping("")
	public Iterable<Movie> list()
	{
		return  movieService.getMovieList();
	}
	

}
