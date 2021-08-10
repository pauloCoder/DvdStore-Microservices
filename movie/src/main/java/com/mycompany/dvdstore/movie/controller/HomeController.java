package com.mycompany.dvdstore.movie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.mycompany.dvdstore.movie.service.IMovieService;

@Controller
public class HomeController {
	
	@Autowired
	private IMovieService movieService;
	
	public IMovieService getMovieService() {
		return movieService;
	}

	public void setMovieService(IMovieService movieService) {
		this.movieService = movieService;
	}
	
	@GetMapping("/home")
	public String displayHome()
	{
		return "dvdstore-home";
	}
	
	/*@GetMapping("/add-movie-form")
	public void displayMovieForm(@ModelAttribute("movieForm") MovieForm movie)
	{
		
	}*/

}
