package com.example.demo.category.service;

import com.example.demo.category.dto.request.CategoryCreateRequest;
import com.example.demo.category.dto.request.CategoryModifyeRequest;
import com.example.demo.category.entity.Category;
import com.example.demo.category.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class CategoryService {
    private final CategoryRepository categoryRepository;

    @Transactional
    public void createCategory(CategoryCreateRequest createRequest) {
        categoryRepository.save(Category.create(createRequest));
    }

    @Transactional
    public void modifyCategory(CategoryModifyeRequest modifyRequest) {
        categoryRepository.save(Category.update(modifyRequest));
    }
    @Transactional
    public void deleteCategory(String id) {
        categoryRepository.deleteById(Long.valueOf(id));
    }



    //select할때만 readOnly 추가
}
