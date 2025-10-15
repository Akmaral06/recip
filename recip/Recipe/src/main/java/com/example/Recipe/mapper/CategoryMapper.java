package com.example.Recipe.mapper;

import com.example.Recipe.dto.CategoryDto;
import com.example.Recipe.model.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    CategoryDto toDto(Category category);
    Category toEntity(CategoryDto categoryDto);
}
