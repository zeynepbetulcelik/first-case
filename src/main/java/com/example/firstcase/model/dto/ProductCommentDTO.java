package com.example.firstcase.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductCommentDTO {

    private Integer id;
    private String comment;
    private Date commentDate;
    private Integer productId;
    private UUID userId;
}
