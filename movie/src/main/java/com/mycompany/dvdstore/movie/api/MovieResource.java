package com.mycompany.dvdstore.movie.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.dvdstore.core.entity.movie.Movie;
import com.mycompany.dvdstore.movie.service.IMovieService;

@RestController
@RequestMapping("/movie")
public class MovieResource 
{
	@Autowired
	private IMovieService movieService;
	
	public IMovieService getMovieService() {
		return movieService;
	}

	public void setMovieService(IMovieService movieService) {
		this.movieService = movieService;
	}

	@GetMapping("/{id}")
	public Movie get(@PathVariable("id") Long id)
	{
		return movieService.getMovieById(id);
	}
	
	@GetMapping("")
	public Iterable<Movie> list()
	{
		return  movieService.getMovieList();
	}
	

}
