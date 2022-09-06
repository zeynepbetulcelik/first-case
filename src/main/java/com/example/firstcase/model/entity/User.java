package com.example.firstcase.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name="users")
@Getter
@Setter
public class User implements Serializable {
    @Id
    @GeneratedValue
    private UUID id;

    @Column(name ="name")
    private String name;

    @Column(name ="surname")
    private String surname;

    @Column(name ="email")
    private String email;

    @Column(name ="phone")
    private String phone;
}
