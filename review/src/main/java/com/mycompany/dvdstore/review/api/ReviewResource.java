package com.mycompany.dvdstore.review.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.dvdstore.core.entity.review.Review;
import com.mycompany.dvdstore.review.service.IReviewService;

@RestController
@RequestMapping("/review")
public class ReviewResource {
	
	@Autowired
	private IReviewService reviewService;
	
	@GetMapping("/{id}")
	public Review get(@PathVariable("id") Long id)
	{
		return reviewService.getReviewById(id);
	}
	
	@GetMapping
	public Iterable<Review> list()
	{
		return reviewService.getReviewList();
	}
	
	@GetMapping("/byMovie/{id}")
	public Iterable<Review> listByIdMovie(@PathVariable("id") Long id)
	{
		return reviewService.getReviewListByIdMovie(id);
	}

	public IReviewService getReviewService() {
		return reviewService;
	}

	public void setReviewService(IReviewService reviewService) {
		this.reviewService = reviewService;
	}

}
