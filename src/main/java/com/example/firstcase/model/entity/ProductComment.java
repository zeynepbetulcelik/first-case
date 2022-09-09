package com.example.firstcase.model.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;


@Entity
@Table(name = "product_comment")
@Getter
@Setter
public class ProductComment implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "comment")
    private String comment;

    @Column(name = "comment_date")
    private Date commentDate;

    @Column(name="product_id",nullable = false)
    private Integer productId;

    @Column(name="user_id",nullable = false)
    private UUID userId;


    public ProductComment() {

    }
}
