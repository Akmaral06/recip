package com.example.Recipe.mapper;

import com.example.Recipe.dto.IngredientDto;
import com.example.Recipe.model.Ingredient;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-10-14T19:43:25+0500",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.14.3.jar, environment: Java 17.0.16 (Amazon.com Inc.)"
)
@Component
public class IngredientMapperImpl implements IngredientMapper {

    @Override
    public IngredientDto toDto(Ingredient ingredient) {
        if ( ingredient == null ) {
            return null;
        }

        IngredientDto ingredientDto = new IngredientDto();

        ingredientDto.setId( ingredient.getId() );
        ingredientDto.setName( ingredient.getName() );
        ingredientDto.setQuantity( ingredient.getQuantity() );
        ingredientDto.setUnit( ingredient.getUnit() );

        return ingredientDto;
    }

    @Override
    public Ingredient toEntity(IngredientDto ingredientDto) {
        if ( ingredientDto == null ) {
            return null;
        }

        Ingredient ingredient = new Ingredient();

        ingredient.setId( ingredientDto.getId() );
        ingredient.setName( ingredientDto.getName() );
        ingredient.setUnit( ingredientDto.getUnit() );
        ingredient.setQuantity( ingredientDto.getQuantity() );

        return ingredient;
    }
}
