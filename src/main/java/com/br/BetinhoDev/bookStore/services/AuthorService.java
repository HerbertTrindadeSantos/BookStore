package com.br.BetinhoDev.bookStore.services;

import com.br.BetinhoDev.bookStore.dtos.AuthorRequestDTO;
import com.br.BetinhoDev.bookStore.dtos.AuthorResponseDTO;
import com.br.BetinhoDev.bookStore.dtos.StudentRequestDTO;
import com.br.BetinhoDev.bookStore.dtos.StudentResponseDTO;
import com.br.BetinhoDev.bookStore.dtos.mappers.AuthorMapper;
import com.br.BetinhoDev.bookStore.dtos.mappers.StudentMapper;
import com.br.BetinhoDev.bookStore.entities.Author;
import com.br.BetinhoDev.bookStore.entities.Student;
import com.br.BetinhoDev.bookStore.exceptions.NotFoundAuthorException;
import com.br.BetinhoDev.bookStore.exceptions.NotFoundStudentException;
import com.br.BetinhoDev.bookStore.repositories.AuthorRepository;
import com.br.BetinhoDev.bookStore.repositories.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    private AuthorRepository authorRepository;
    private AuthorMapper authorMapper;

    public AuthorService(AuthorRepository authorRepository, AuthorMapper authorMapper) {
        this.authorRepository = authorRepository;
        this.authorMapper = authorMapper;
    }

    public AuthorResponseDTO findById(Long id) {
        Author author = authorRepository.findById(id).
                orElseThrow(() -> new NotFoundAuthorException("Studant not found id: " + id));
        return authorMapper.toResponse(author);
    }

    public List<AuthorResponseDTO> findAll() {
        return authorRepository.findAll().stream().map(authorMapper::toResponse).toList();
    }

    public AuthorResponseDTO insert(AuthorRequestDTO request) {
        Author author = authorRepository.save(authorMapper.toEntity(request));
        return authorMapper.toResponse(author);
    }

    public AuthorResponseDTO update(Long id, AuthorRequestDTO request) {
        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new NotFoundAuthorException("Author not found id: " + id));
        author.setName(request.name());
        author.setSurname(request.surname());

        return authorMapper.toResponse(author);
    }

    public void delete(Long id) {
        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new NotFoundAuthorException("Author not found id: " + id));
        authorRepository.delete(author);
    }
}
