package com.example.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@Entity
@Table(name = "product")

public class Product {
    @Id
    private Long id;
    private String name;
    private int price;
    private String description;
    @ManyToOne
    private Category category;
}