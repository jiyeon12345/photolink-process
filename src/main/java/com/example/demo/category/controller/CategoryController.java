package com.example.demo.category.controller;

import com.example.demo.category.dto.request.CategoryCreateRequest;
import com.example.demo.category.entity.Category;
import com.example.demo.category.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @PostMapping("/create")
    public ResponseEntity<Object> createCategory (@Valid @RequestBody CategoryCreateRequest createRequest) {
        categoryService.createCategory(createRequest);

        return new ResponseEntity<>(null, HttpStatus.CREATED);
    }

//    @GetMapping("/list")
//    public void getCategoryList () {
//        log.info("test ok");
//    }
}
