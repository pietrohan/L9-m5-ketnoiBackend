package com.example.sevice;

import com.example.model.Category;

import java.util.List;
import java.util.Optional;
public interface ICategoryService {
    List<Category> findAll();

    Optional<Category> findById(Long id);

    Category save(Category category);
    void remove(Long id);
}