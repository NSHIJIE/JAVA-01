package com.example.shardingsphere.model;

import lombok.Data;
import lombok.ToString;
import javax.persistence.*;

@Data
@Table(name = "user")
@ToString
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

}