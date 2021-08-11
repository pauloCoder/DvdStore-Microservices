package com.mycompany.dvdstore.review.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.EntityGraph.EntityGraphType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mycompany.dvdstore.core.entity.review.Review;

public interface IRepositoryReview extends JpaRepository<Review, Long> {
	
	@EntityGraph(value = "review-user", type = EntityGraphType.FETCH)
	public Optional<Review> findById(Long id);
	
	@Query(value = "SELECT review FROM  Review review WHERE review.idMovie = :idMovie")
	public List<Review> findByIdMovie(@Param("idMovie") Long idMovie);

}
