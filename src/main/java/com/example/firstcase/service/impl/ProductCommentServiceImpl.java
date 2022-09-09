package com.example.firstcase.service.impl;

import com.example.firstcase.data.ProductCommentRepository;
import com.example.firstcase.data.UserRepository;
import com.example.firstcase.model.dto.ProductCommentDTO;
import com.example.firstcase.model.entity.ProductComment;
import com.example.firstcase.model.entity.User;
import com.example.firstcase.service.ProductCommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductCommentServiceImpl implements ProductCommentService {
    private final ProductCommentRepository productCommentRepository;
    private final UserRepository userRepository;
    @Override
    public List<ProductCommentDTO> getUserComments(String email) {
        User user = userRepository.findByEmail(email);
        List<ProductComment> productCommentsByUser = productCommentRepository.findProductCommentsByUserId(user.getId());
        List<ProductCommentDTO>productCommentDTOS=new ArrayList<>();
        for(ProductComment productComment: productCommentsByUser){
            ProductCommentDTO productCommentDTO = new ProductCommentDTO();
            BeanUtils.copyProperties(productComment,productCommentDTO);
            productCommentDTOS.add(productCommentDTO);
        }
        return productCommentDTOS;
    }
}
