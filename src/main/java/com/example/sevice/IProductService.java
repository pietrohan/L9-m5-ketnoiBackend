package com.example.sevice;

import com.example.model.Product;

import java.util.List;
import java.util.Optional;
public interface IProductService {
    List<Product> findAll();

    Optional<Product> findById(Long id);

    Product save(Product product);


    void remove(Long id);
}
