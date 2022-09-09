package com.example.firstcase.data;

import com.example.firstcase.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.time.LocalDateTime;

import java.util.List;


@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
    List<Product> findByExpirationDateBefore(LocalDateTime date);

    List<Product> findByExpirationDateAfterOrExpirationDateIsNull(LocalDateTime date);
}
