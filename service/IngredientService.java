package com.example.Recipe.service;

import com.example.Recipe.dto.IngredientDto;
import java.util.List;

public interface IngredientService {
    List<IngredientDto> getAllIngredients();
    IngredientDto getIngredientById(Long id);
    IngredientDto createIngredient(IngredientDto ingredientDto);
    IngredientDto updateIngredient(Long id, IngredientDto ingredientDto);
    void deleteIngredient(Long id);
}
