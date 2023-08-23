package com.example.demo.category.entity;

import com.example.demo.category.dto.request.CategoryCreateRequest;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static lombok.AccessLevel.PROTECTED;

@Entity
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
    public Category (String title, String description) {
        this.title = title;
        this.description = description;
    }

    public static Category create(CategoryCreateRequest categoryCreate) {
        return Category.builder()
                .title(categoryCreate.getCategoryTitle())
                .description(categoryCreate.getCategoryDesc())
                .build();
    }

    //update 추가 예정

}