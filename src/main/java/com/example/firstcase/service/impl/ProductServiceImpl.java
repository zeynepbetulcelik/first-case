package com.example.firstcase.service.impl;

import com.example.firstcase.data.ProductRepository;
import com.example.firstcase.data.UserRepository;
import com.example.firstcase.model.dto.ProductCommentDTO;
import com.example.firstcase.model.dto.ProductDTO;
import com.example.firstcase.model.entity.Product;
import com.example.firstcase.model.entity.ProductComment;
import com.example.firstcase.model.entity.User;
import com.example.firstcase.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;


@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    @Override
    public ProductDTO createProduct(ProductDTO productDTO) {
        Product product = new Product();
        product.setName(productDTO.getName());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-M-yyyy HH:mm:ss");
        product.setExpirationDate( LocalDateTime.parse(productDTO.getExpirationDate(), formatter).plusHours(3));
        product.setPrice(product.getPrice());
        productRepository.saveAndFlush(product);
        BeanUtils.copyProperties(product, productDTO);
        return productDTO;
    }

    @Override
    public String deleteProduct(Integer productId) {
        try {
            productRepository.deleteById(productId);
            return "Deleted successfully";
        } catch (Exception exception) {
            throw new RuntimeException(exception.getMessage());
        }
    }

    @Override
    public ProductCommentDTO createProductComment(Integer productId, String email, ProductCommentDTO productCommentDTO) throws ParseException {
        User user = userRepository.findByEmail(email);
        ProductComment productComment = new ProductComment();
        productComment.setProductId(productId);
        productComment.setComment(productCommentDTO.getComment());
        productComment.setCommentDate(null);
        productComment.setUserId(user.getId());
        BeanUtils.copyProperties(productComment,productCommentDTO);
        return  productCommentDTO;
    }

    @Override
    public List<ProductDTO> getExpiredProducts() {
        List<ProductDTO>productDTOS = new ArrayList<>();
        List<Product> expireProducts =productRepository.findByExpirationDateBefore(LocalDateTime.now());
        for(Product product : expireProducts){
            ProductDTO productDTO = new ProductDTO();
            BeanUtils.copyProperties(product,productDTO);
            productDTOS.add(productDTO);
        }
        return productDTOS;
    }

    @Override
    public List<ProductDTO> getNonExpiredProducts() {
        return null;
    }

}
