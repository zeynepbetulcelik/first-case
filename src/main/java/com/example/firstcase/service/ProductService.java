package com.example.firstcase.service;

import com.example.firstcase.model.dto.ProductCommentDTO;
import com.example.firstcase.model.dto.ProductDTO;

import java.text.ParseException;
import java.util.List;

public interface ProductService {
    ProductDTO createProduct(ProductDTO productDTO) throws ParseException;
    String deleteProduct (Integer productId);
    ProductCommentDTO createProductComment(Integer productId,String email,ProductCommentDTO productCommentDTO) throws ParseException;

    List<ProductDTO> getExpiredProducts() throws ParseException;

    List<ProductDTO> getNonExpiredProducts();



}
