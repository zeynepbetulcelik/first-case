package com.example.firstcase.model.resource;

import com.example.firstcase.model.dto.ProductCommentDTO;
import com.example.firstcase.model.dto.ProductDTO;
import com.example.firstcase.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RestController
@RequestMapping("/api/v1/product")
@RequiredArgsConstructor
public class ProductResource {
    private final ProductService productService;

    @PostMapping("/create-product")
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO productDTO) throws ParseException {
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.createProduct(productDTO));
    }
    @DeleteMapping("/delete-product")
    public ResponseEntity<String> deleteProduct(@RequestParam("product-id") Integer productId){
        return  ResponseEntity.status(HttpStatus.OK).body(productService.deleteProduct(productId));
    }
    @GetMapping("/expired-products")
    public ResponseEntity<?> expiredProducts() throws ParseException {
        return ResponseEntity.status(HttpStatus.OK).body(productService.getExpiredProducts());
    }

    @PostMapping("/create-comment")
    public ResponseEntity<?> createComment(@RequestParam("product-id") Integer productId, @RequestBody ProductCommentDTO productCommentDTO){
        return  ResponseEntity.status(HttpStatus.OK).body(null);
    }

}