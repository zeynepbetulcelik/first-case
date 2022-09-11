package com.example.firstcase.model.resource;

import com.example.firstcase.model.dto.ProductCommentDTO;
import com.example.firstcase.model.dto.ProductDTO;
import com.example.firstcase.service.ProductCommentService;
import com.example.firstcase.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
@RequiredArgsConstructor
public class ProductResource {
    private final ProductService productService;
    private final ProductCommentService productCommentService;

    @PostMapping("/create-product")
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO productDTO) throws ParseException {
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.createProduct(productDTO));
    }

    @DeleteMapping("/delete-product")
    public ResponseEntity<String> deleteProduct(@RequestParam("product-id") Integer productId) {
        return ResponseEntity.status(HttpStatus.OK).body(productService.deleteProduct(productId));
    }

    @GetMapping("/expired-products")
    public ResponseEntity<List<ProductDTO>> expiredProducts() throws ParseException {
        return ResponseEntity.status(HttpStatus.OK).body(productService.getExpiredProducts());
    }

    @GetMapping("/non-expired-products")
    public ResponseEntity<List<ProductDTO>> nonExpiredProducts() {
        return ResponseEntity.status(HttpStatus.OK).body(productService.getNonExpiredProducts());
    }

    @PostMapping("/create-comment")
    public ResponseEntity<ProductCommentDTO> createComment(@RequestParam("product-id") Integer productId, @RequestParam("email") String email,
                                                           @RequestBody ProductCommentDTO productCommentDTO) throws ParseException {
        return ResponseEntity.status(HttpStatus.OK).body(productService.createProductComment(productId, email, productCommentDTO));
    }

    @GetMapping("/comments-by-user")
    public ResponseEntity<List<ProductCommentDTO>> comments(@RequestParam("email") String email) {
        return ResponseEntity.status(HttpStatus.OK).body(productCommentService.getUserComments(email));
    }
    @GetMapping("/comments-by-date-and-product")
    public ResponseEntity<List<ProductCommentDTO>> commentsByDateAndProduct(@RequestParam("product-id") Integer productId,
                                                                            @RequestParam("starting-date") String startingDate,@RequestParam("ending-date") String endingDate ) {
        return ResponseEntity.status(HttpStatus.OK).body(productCommentService.getProductCommentByProductAndDates(productId,startingDate,endingDate));
    }

    @GetMapping("/comments-by-product")
    public ResponseEntity<List<ProductCommentDTO>> commentsByProduct (@RequestParam("product-id") Integer productId){
        return ResponseEntity.status(HttpStatus.OK).body(productCommentService.getProductCommentsByProduct(productId));
    }
}