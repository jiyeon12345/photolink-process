package com.example.demo.category.service;

import com.example.demo.category.dto.request.CategoryCreateRequest;
import com.example.demo.category.dto.request.CategoryModifyeRequest;
import com.example.demo.category.dto.response.ResponseCategory;
import com.example.demo.category.entity.Category;
import com.example.demo.category.repository.CategoryRepository;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


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
    @Transactional(readOnly = true)
    public List<ResponseCategory> getTotalCategoryList() {
        List<Category> categories = categoryRepository.findAllByOrderByIdDesc();

        if(categories.isEmpty()) {
            return null;
        }

        return categories.stream().map(category ->
                ResponseCategory.getCategotyDetail(category)
        ).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public ResponseCategory getCategoryById(String id) throws NotFoundException {
        Optional<Category> categoryOptional = categoryRepository.findById(Long.parseLong(id));

        Category category = categoryOptional.orElseThrow(() -> new NotFoundException("Category not found with id: " + id));
        return ResponseCategory.getCategotyDetail(category);
    }

}
