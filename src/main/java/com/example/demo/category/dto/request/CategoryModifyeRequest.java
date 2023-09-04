package com.example.demo.category.dto.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@RequiredArgsConstructor
public class CategoryModifyeRequest {
    @NotNull
    private Long id;

    @NotBlank
    private String title;

    @NotBlank
    private String description;

}
