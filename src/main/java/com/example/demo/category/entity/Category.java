package com.example.demo.category.entity;

import com.example.demo.category.dto.request.CategoryCreateRequest;
import com.example.demo.category.dto.request.CategoryModifyeRequest;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static lombok.AccessLevel.PROTECTED;

@Entity
@Table(name="category")
@Getter
@NoArgsConstructor(access = PROTECTED)
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String title;

    @Column(nullable = false, length = 255)
    private String description;

    @Builder
    public Category (Long id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public static Category create(CategoryCreateRequest categoryCreate) {
        return Category.builder()
                .title(categoryCreate.getTitle())
                .description(categoryCreate.getDescription())
                .build();
    }

    public static Category update(CategoryModifyeRequest modifyRequest) {
        return Category.builder()
                .id(modifyRequest.getId())
                .title(modifyRequest.getTitle())
                .description(modifyRequest.getDescription())
                .build();
    }

}