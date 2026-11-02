package com.br.BetinhoDev.bookStore.dtos;

import com.br.BetinhoDev.bookStore.entities.Category;

public record CategoryResponseDTO(
        Long id,
        String name
) {
}
