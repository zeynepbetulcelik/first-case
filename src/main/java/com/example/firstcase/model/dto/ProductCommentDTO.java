package com.example.firstcase.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductCommentDTO {

    private Integer id;
    private String comment;
    private LocalDateTime commentDate;
    private Integer productId;
    private UUID userId;
}
