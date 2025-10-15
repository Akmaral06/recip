package com.example.Recipe.mapper;

import com.example.Recipe.dto.RecipeDto;
import com.example.Recipe.model.Category;
import com.example.Recipe.model.Recipe;
import java.util.stream.Collectors;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-10-14T21:56:55+0500",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.14.3.jar, environment: Java 17.0.16 (Amazon.com Inc.)"
)
@Component
public class RecipeMapperImpl implements RecipeMapper {

    @Override
    public RecipeDto toDto(Recipe recipe) {
        if ( recipe == null ) {
            return null;
        }

        RecipeDto recipeDto = new RecipeDto();

        recipeDto.setCategoryId( recipeCategoryId( recipe ) );
        recipeDto.setId( recipe.getId() );
        recipeDto.setTitle( recipe.getTitle() );
        recipeDto.setInstructions( recipe.getInstructions() );

        recipeDto.setIngredientIds( recipe.getIngredients().stream().map(i -> i.getId()).collect(Collectors.toList()) );

        return recipeDto;
    }

    @Override
    public Recipe toEntity(RecipeDto recipeDto) {
        if ( recipeDto == null ) {
            return null;
        }

        Recipe.RecipeBuilder recipe = Recipe.builder();

        recipe.id( recipeDto.getId() );
        recipe.title( recipeDto.getTitle() );
        recipe.instructions( recipeDto.getInstructions() );

        return recipe.build();
    }

    private Long recipeCategoryId(Recipe recipe) {
        if ( recipe == null ) {
            return null;
        }
        Category category = recipe.getCategory();
        if ( category == null ) {
            return null;
        }
        Long id = category.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
