package com.example.Recipe.service.impl;

import com.example.Recipe.dto.RecipeDto;
import com.example.Recipe.mapper.RecipeMapper;
import com.example.Recipe.model.Category;
import com.example.Recipe.model.Recipe;
import com.example.Recipe.repository.CategoryRepository;
import com.example.Recipe.repository.RecipeRepository;
import com.example.Recipe.service.RecipeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;
    private final RecipeMapper recipeMapper;
    private final CategoryRepository categoryRepository;

    @Override
    public List<RecipeDto> getAllRecipes() {
        return recipeRepository.findAll().stream()
                .map(recipeMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public RecipeDto getRecipeById(Long id) {
        return recipeRepository.findById(id)
                .map(recipeMapper::toDto)
                .orElseThrow(() -> new RuntimeException("Recipe not found"));
    }

    @Override
    public RecipeDto createRecipe(RecipeDto recipeDto) {
        Recipe recipe = recipeMapper.toEntity(recipeDto);

        if (recipeDto.getCategoryId() != null) {
            Category category = categoryRepository.findById(recipeDto.getCategoryId())
                    .orElseThrow(() -> new RuntimeException("Category not found"));
            recipe.setCategory(category);
        }

        return recipeMapper.toDto(recipeRepository.save(recipe));
    }

    @Override
    public RecipeDto updateRecipe(Long id, RecipeDto recipeDto) {
        Recipe recipe = recipeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Recipe not found"));

        recipe.setTitle(recipeDto.getTitle());
        recipe.setInstructions(recipeDto.getInstructions());

        if (recipeDto.getCategoryId() != null) {
            Category category = categoryRepository.findById(recipeDto.getCategoryId())
                    .orElseThrow(() -> new RuntimeException("Category not found"));
            recipe.setCategory(category);
        }

        return recipeMapper.toDto(recipeRepository.save(recipe));
    }

    @Override
    public void deleteRecipe(Long id) {
        recipeRepository.deleteById(id);
    }
}
