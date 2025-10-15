package com.example.Recipe.mapper;

import com.example.Recipe.dto.IngredientDto;
import com.example.Recipe.model.Ingredient;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IngredientMapper {
    IngredientDto toDto(Ingredient ingredient);
    Ingredient toEntity(IngredientDto ingredientDto);
}
