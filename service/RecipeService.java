package com.example.Recipe.service;

import com.example.Recipe.dto.RecipeDto;
import java.util.List;

public interface RecipeService {
    List<RecipeDto> getAllRecipes();
    RecipeDto getRecipeById(Long id);
    RecipeDto createRecipe(RecipeDto recipeDto);
    RecipeDto updateRecipe(Long id, RecipeDto recipeDto);
    void deleteRecipe(Long id);
}
