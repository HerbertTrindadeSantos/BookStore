package com.br.BetinhoDev.bookStore.dtos;

import com.br.BetinhoDev.bookStore.entities.Category;

public record BookRequestDTO(
        String title,
        String description,
        Category category
) {
}
