package com.example.Recipe.service.impl;

import com.example.Recipe.dto.IngredientDto;
import com.example.Recipe.mapper.IngredientMapper;
import com.example.Recipe.model.Ingredient;
import com.example.Recipe.model.Recipe;
import com.example.Recipe.repository.IngredientRepository;
import com.example.Recipe.repository.RecipeRepository;
import com.example.Recipe.service.IngredientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class IngredientServiceImpl implements IngredientService {

    private final IngredientRepository ingredientRepository;
    private final IngredientMapper ingredientMapper;
    private final RecipeRepository recipeRepository;



    @Override
    public List<IngredientDto> getAllIngredients() {
        return ingredientRepository.findAll().stream()
                .map(ingredientMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public IngredientDto getIngredientById(Long id) {
        return ingredientRepository.findById(id)
                .map(ingredientMapper::toDto)
                .orElseThrow(() -> new RuntimeException("Ingredient not found"));
    }

    @Override
    public IngredientDto createIngredient(IngredientDto ingredientDto) {
        Ingredient ingredient = ingredientMapper.toEntity(ingredientDto);

        if (ingredientDto.getRecipeId() != null) {
            Recipe recipe = recipeRepository.findById(ingredientDto.getRecipeId())
                    .orElseThrow(() -> new RuntimeException("Recipe not found"));
            ingredient.getRecipes().add(recipe);
        }

        return ingredientMapper.toDto(ingredientRepository.save(ingredient));
    }

    @Override
    public IngredientDto updateIngredient(Long id, IngredientDto ingredientDto) {
        Ingredient existing = ingredientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ingredient not found"));
        existing.setName(ingredientDto.getName());
        existing.setQuantity(ingredientDto.getQuantity());
        return ingredientMapper.toDto(ingredientRepository.save(existing));
    }

    @Override
    public void deleteIngredient(Long id) {
        ingredientRepository.deleteById(id);
    }
}
