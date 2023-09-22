package com.example.demo.category.dto.request;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import javax.validation.constraints.NotBlank;

@Getter
@RequiredArgsConstructor
public class CategoryCreateRequest {
    @NotBlank
    private String title;

    @NotBlank
    private String description;
}