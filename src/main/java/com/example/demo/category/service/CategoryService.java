package com.example.demo.category.service;

import com.example.demo.category.dto.request.CategoryCreateRequest;
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

    //select할때만 readOnly 추가
}
