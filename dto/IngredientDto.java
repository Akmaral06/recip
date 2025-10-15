package com.example.Recipe.dto;

import lombok.Data;

@Data
public class IngredientDto {
    private Long id;
    private String name;
    private Double quantity;
    private String unit;
    private Long recipeId;
}
