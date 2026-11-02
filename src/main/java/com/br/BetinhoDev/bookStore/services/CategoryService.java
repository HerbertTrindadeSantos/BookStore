package com.br.BetinhoDev.bookStore.services;


import com.br.BetinhoDev.bookStore.dtos.CategoryRequestDTO;
import com.br.BetinhoDev.bookStore.dtos.CategoryResponseDTO;
import com.br.BetinhoDev.bookStore.dtos.mappers.CategoryMapper;
import com.br.BetinhoDev.bookStore.entities.Category;
import com.br.BetinhoDev.bookStore.exceptions.NotFoundCategoryException;
import com.br.BetinhoDev.bookStore.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private CategoryRepository categoryRepository;
    private CategoryMapper categoryMapper;

    public CategoryService(CategoryRepository categoryRepository, CategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }

    public CategoryResponseDTO findById(Long id) {
        Category category = categoryRepository.findById(id).
                orElseThrow(() -> new NotFoundCategoryException("Studant not found id: " + id));
        return categoryMapper.toResponse(category);
    }

    public List<CategoryResponseDTO> findAll() {
        return categoryRepository.findAll().stream().map(categoryMapper::toResponse).toList();
    }

    public CategoryResponseDTO insert(CategoryRequestDTO request) {
        Category category = categoryRepository.save(categoryMapper.toEntity(request));
        return categoryMapper.toResponse(category);
    }

    public CategoryResponseDTO update(Long id, CategoryRequestDTO request) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new NotFoundCategoryException("Category not found id: " + id));
        category.setName(request.name());

        return categoryMapper.toResponse(category);
    }

    public void delete(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new NotFoundCategoryException("Category not found id: " + id));
        categoryRepository.delete(category);
    }
}
