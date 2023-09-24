package com.example.demo.category.controller;

import com.example.demo.category.dto.request.CategoryCreateRequest;
import com.example.demo.category.dto.request.CategoryModifyeRequest;
import com.example.demo.category.dto.response.ResponseCategory;
import com.example.demo.category.service.CategoryService;
import io.swagger.annotations.ApiOperation;
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

    @ApiOperation(value="카테고리 정보 생성", notes="카테고리 정보를 생성한다.")
    @PostMapping()
    public ResponseEntity<Object> createCategory (@Valid @RequestBody CategoryCreateRequest createRequest) {
        categoryService.createCategory(createRequest);

        return new ResponseEntity<>(null, HttpStatus.CREATED);
    }

    @ApiOperation(value="카테고리 전체 목록 조회", notes="카테고리 전체 목록을 조회한다.")
    @GetMapping()
    public ResponseEntity<List<ResponseCategory>> getCategoryList () {
        List<ResponseCategory> categories = categoryService.getTotalCategoryList();

        return new ResponseEntity<List<ResponseCategory>>(categories, HttpStatus.OK);
    }

    @ApiOperation(value="카테고리 id 관련 데이터 상세 조회", notes="카테고리 id 별 데이터를 상세 조회한다.")
    @GetMapping("/{id}")
    public ResponseEntity<ResponseCategory> getCategoryDetail (@Valid @PathVariable String id) throws NotFoundException {
        ResponseCategory category = categoryService.getCategoryById(id);

        return new ResponseEntity<ResponseCategory>(category, HttpStatus.OK);
    }

    @ApiOperation(value="카테고리 id 관련 데이터 수정", notes="카테고리 id 별 데이터를 수정한다.")
    @PutMapping()
    public ResponseEntity<Object> modifyCategory (@Valid @RequestBody CategoryModifyeRequest modifyRequest) {
        categoryService.modifyCategory(modifyRequest);

        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @ApiOperation(value="카테고리 id 관련 데이터 삭제", notes="카테고리 id 관련 데이터를 삭제한다.")
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteCategory (@Valid @PathVariable String id) {
        categoryService.deleteCategory(id);

        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }
}
