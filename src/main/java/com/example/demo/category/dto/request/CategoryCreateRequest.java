package com.example.demo.category.dto.request;

import com.example.demo.category.entity.Category;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@RequiredArgsConstructor
public class CategoryCreateRequest {
    @NotBlank
    final private String categoryTitle;

    @NotBlank
    final private String categoryDesc;
}
