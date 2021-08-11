package com.mycompany.dvdstore.review.service;

import com.mycompany.dvdstore.core.entity.review.Review;

public interface IReviewService {
	
	public Review getReviewById(Long id); 
	
	public Iterable<Review> getReviewListByIdMovie(Long idMovie);
	
	public Iterable<Review> getReviewList();

}
