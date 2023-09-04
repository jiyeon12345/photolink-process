package com.example.demo.category.controller;

import com.example.demo.category.dto.request.CategoryCreateRequest;
import com.example.demo.category.dto.request.CategoryModifyeRequest;
import com.example.demo.category.dto.response.ResponseCategory;
import com.example.demo.category.entity.Category;
import com.example.demo.category.service.CategoryService;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @PostMapping()
    public ResponseEntity<Object> createCategory (@Valid @RequestBody CategoryCreateRequest createRequest) {
        categoryService.createCategory(createRequest);

        return new ResponseEntity<>(null, HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<ResponseCategory>> getCategoryList () {
        List<ResponseCategory> categories = categoryService.getTotalCategoryList();

        return new ResponseEntity<List<ResponseCategory>>(categories, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseCategory> getCategoryDetail (@Valid @PathVariable String id) throws NotFoundException {
        ResponseCategory category = categoryService.getCategoryById(id);

        return new ResponseEntity<ResponseCategory>(category, HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity<Object> modifyCategory (@Valid @RequestBody CategoryModifyeRequest modifyRequest) {
        categoryService.modifyCategory(modifyRequest);

        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteCategory (@Valid @PathVariable String id) {
        categoryService.deleteCategory(id);

        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }
}
