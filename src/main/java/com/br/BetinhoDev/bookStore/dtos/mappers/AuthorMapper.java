package com.br.BetinhoDev.bookStore.dtos.mappers;

import com.br.BetinhoDev.bookStore.dtos.AuthorRequestDTO;
import com.br.BetinhoDev.bookStore.dtos.AuthorResponseDTO;
import com.br.BetinhoDev.bookStore.dtos.StudentRequestDTO;
import com.br.BetinhoDev.bookStore.dtos.StudentResponseDTO;
import com.br.BetinhoDev.bookStore.entities.Author;
import com.br.BetinhoDev.bookStore.entities.Student;
import org.springframework.stereotype.Component;

@Component
public class AuthorMapper {

    public Author toEntity(AuthorRequestDTO request){
        return new Author(request.name(),request.surname());
    }

    public AuthorResponseDTO toResponse(Author author){
        return new AuthorResponseDTO(
                author.getId(),
                author.getName(),
                author.getSurname());
    }
}
