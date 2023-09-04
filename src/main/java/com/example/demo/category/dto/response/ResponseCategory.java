package com.example.demo.category.dto.response;

import com.example.demo.category.entity.Category;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ResponseCategory {
    private Long id;
    private String title;
    private String description;

    @Builder
    public ResponseCategory (Long id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public static ResponseCategory getCategotyDetail(Category category) {
        return ResponseCategory.builder()
                .id(category.getId())
                .title(category.getTitle())
                .description(category.getDescription())
                .build();
    }

}
