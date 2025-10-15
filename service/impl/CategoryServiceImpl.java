package com.example.Recipe.service.impl;

import com.example.Recipe.dto.CategoryDto;
import com.example.Recipe.mapper.CategoryMapper;
import com.example.Recipe.model.Category;
import com.example.Recipe.repository.CategoryRepository;
import com.example.Recipe.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    @Override
    public List<CategoryDto> getAllCategories() {
        return categoryRepository.findAll().stream()
                .map(categoryMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public CategoryDto getCategoryById(Long id) {
        return categoryRepository.findById(id)
                .map(categoryMapper::toDto)
                .orElseThrow(() -> new RuntimeException("Category not found"));
    }

    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {
        Category category = categoryMapper.toEntity(categoryDto);
        return categoryMapper.toDto(categoryRepository.save(category));
    }

    @Override
    public CategoryDto updateCategory(Long id, CategoryDto categoryDto) {
        Category existing = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));
        existing.setName(categoryDto.getName());
        existing.setDescription(categoryDto.getDescription());
        return categoryMapper.toDto(categoryRepository.save(existing));
    }

    @Override
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }
}
