package com.br.BetinhoDev.bookStore.services;

import com.br.BetinhoDev.bookStore.dtos.AuthorRequestDTO;
import com.br.BetinhoDev.bookStore.dtos.AuthorResponseDTO;
import com.br.BetinhoDev.bookStore.dtos.mappers.AuthorMapper;
import com.br.BetinhoDev.bookStore.entities.Author;
import com.br.BetinhoDev.bookStore.exceptions.NotFoundAuthorException;
import com.br.BetinhoDev.bookStore.repositories.AuthorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    private static Logger logger = LoggerFactory.getLogger(AuthorService.class);

    private AuthorRepository authorRepository;
    private AuthorMapper authorMapper;

    public AuthorService(AuthorRepository authorRepository, AuthorMapper authorMapper) {
        this.authorRepository = authorRepository;
        this.authorMapper = authorMapper;
    }

    public AuthorResponseDTO findById(Long id) {
        logger.info("Find by id Author");
        Author author = authorRepository.findById(id).
                orElseThrow(() -> new NotFoundAuthorException("Studant not found id: " + id));
        return authorMapper.toResponse(author);
    }

    public List<AuthorResponseDTO> findAll() {
        logger.info("Find all Authors");
        return authorRepository.findAll().stream().map(authorMapper::toResponse).toList();
    }

    public AuthorResponseDTO insert(AuthorRequestDTO request) {
        logger.info("Insert a new author");
        Author author = authorRepository.save(authorMapper.toEntity(request));
        return authorMapper.toResponse(author);
    }

    public AuthorResponseDTO update(Long id, AuthorRequestDTO request) {
        logger.info("Update an author");
        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new NotFoundAuthorException("Author not found id: " + id));
        author.setName(request.name());
        author.setSurname(request.surname());

        return authorMapper.toResponse(author);
    }

    public void delete(Long id) {
        logger.info("Delete an author");
        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new NotFoundAuthorException("Author not found id: " + id));
        authorRepository.delete(author);
    }
}
