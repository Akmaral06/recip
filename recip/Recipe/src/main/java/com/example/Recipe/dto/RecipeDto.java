package com.example.Recipe.dto;

import lombok.Data;
import java.util.List;

@Data
public class RecipeDto {
    private Long id;
    private String title;
    private String instructions;
    private Long categoryId;
    private List<Long> ingredientIds;
}

