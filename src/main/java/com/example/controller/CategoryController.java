package com.example.controller;

import com.example.model.Category;
import com.example.sevice.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin("*")
@RequestMapping("/categorys")
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;

    //    hiện thị tất cả sản phẩm
    @GetMapping
    public ResponseEntity<Iterable<Category>> findAllCategory() {
        List<Category> categorys = (List<Category>) categoryService.findAll();
        if (categorys.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categorys, HttpStatus.OK);
    }

    //    thêm sản phẩm
    @PostMapping("")
    public ResponseEntity<Category> add(@RequestBody Category category) {
        categoryService.save(category);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable Long id, @RequestBody Category category) {
        Optional<Category> categoryOptional = categoryService.findById(id);
        if (!categoryOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        category.setId(categoryOptional.get().getId());
        categoryService.save(category);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //    xóa
    @DeleteMapping("/{id}")
    public ResponseEntity<Category> deleteCategory(@PathVariable Long id) {
        Optional<Category> categoryOptional = categoryService.findById(id);
        if (!categoryOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        categoryService.remove(id);
        return new ResponseEntity<>(categoryOptional.get(), HttpStatus.OK);
    }
}
