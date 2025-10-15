package com.example.Recipe.mapper;

import com.example.Recipe.dto.RecipeDto;
import com.example.Recipe.model.Recipe;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.InheritInverseConfiguration;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", imports = Collectors.class)
public interface RecipeMapper {

    @Mapping(target = "categoryId", source = "category.id")
    @Mapping(target = "ingredientIds",
            expression = "java(recipe.getIngredients().stream().map(i -> i.getId()).collect(Collectors.toList()))")
    RecipeDto toDto(Recipe recipe);

    @InheritInverseConfiguration
    @Mapping(target = "category", ignore = true)
    @Mapping(target = "ingredients", ignore = true)
    Recipe toEntity(RecipeDto recipeDto);
}
