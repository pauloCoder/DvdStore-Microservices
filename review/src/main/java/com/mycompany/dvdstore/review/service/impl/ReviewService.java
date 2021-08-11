package com.mycompany.dvdstore.review.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.mycompany.dvdstore.core.entity.review.Review;
import com.mycompany.dvdstore.review.repository.IRepositoryReview;
import com.mycompany.dvdstore.review.service.IReviewService;

@Service
public class ReviewService implements IReviewService {

	@Autowired
	private IRepositoryReview repositoryReview;
	
	@Override
	public Review getReviewById(Long id) {
		return repositoryReview.findById(id).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
	
	@Override
	public Iterable<Review> getReviewList() {
		return Optional.ofNullable(repositoryReview.findAll()).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
	
	@Override
	public Iterable<Review> getReviewListByIdMovie(Long idMovie) {
		return Optional.ofNullable(repositoryReview.findByIdMovie(idMovie)).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}

	public IRepositoryReview getRepositoryReview() {
		return repositoryReview;
	}

	public void setRepositoryReview(IRepositoryReview repositoryReview) {
		this.repositoryReview = repositoryReview;
	}

}
