package com.br.BetinhoDev.bookStore.dtos;

import com.br.BetinhoDev.bookStore.entities.Student;

import java.time.Instant;

public record LoanResponseDTO(
        Long id,
        Instant checkIn,
        Instant checkOut,
        Student student
) {
}
