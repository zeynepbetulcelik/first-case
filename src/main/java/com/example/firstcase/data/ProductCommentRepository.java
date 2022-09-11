package com.example.firstcase.data;


import com.example.firstcase.model.entity.ProductComment;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Repository
public interface ProductCommentRepository extends JpaRepository<ProductComment,Integer> {


    List<ProductComment> findProductCommentsByUserId(UUID userId);
    List<ProductComment>findProductCommentsByCommentDateBetweenAndProductId(LocalDateTime startingDate, LocalDateTime endingDate, Integer productId);
}
