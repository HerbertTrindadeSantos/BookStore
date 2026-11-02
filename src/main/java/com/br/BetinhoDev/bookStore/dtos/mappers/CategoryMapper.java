package com.br.BetinhoDev.bookStore.dtos.mappers;

import com.br.BetinhoDev.bookStore.dtos.CategoryRequestDTO;
import com.br.BetinhoDev.bookStore.dtos.CategoryResponseDTO;
import com.br.BetinhoDev.bookStore.entities.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {

    public Category toEntity(CategoryRequestDTO request){
        return new Category(request.name());
    }

    public CategoryResponseDTO toResponse(Category category){
        return new CategoryResponseDTO(
                category.getId(),
                category.getName());
    }
}
