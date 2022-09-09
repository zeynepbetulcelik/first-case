package com.example.firstcase.service;

import com.example.firstcase.model.dto.ProductCommentDTO;

import java.util.List;

public interface ProductCommentService {
    List<ProductCommentDTO> getUserComments(String email);
}
