package com.br.BetinhoDev.bookStore.services;

import com.br.BetinhoDev.bookStore.dtos.BookRequestDTO;
import com.br.BetinhoDev.bookStore.dtos.BookResponseDTO;
import com.br.BetinhoDev.bookStore.dtos.mappers.BookMapper;
import com.br.BetinhoDev.bookStore.entities.Book;
import com.br.BetinhoDev.bookStore.exceptions.NotFoundBookException;
import com.br.BetinhoDev.bookStore.repositories.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private static Logger logger = LoggerFactory.getLogger(BookService.class);

    private BookRepository bookRepository;
    private BookMapper bookMapper;

    public BookService(BookRepository bookRepository, BookMapper bookMapper) {
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
    }

    public BookResponseDTO findById(Long id) {
        logger.info("Find by id Book");
        Book Book = BookRepository.findById(id).
                orElseThrow(() -> new NotFoundBookException("Studant not found id: " + id));
        return bookMapper.toResponse(Book);
    }

    public List<BookResponseDTO> findAll() {
        logger.info("Find all Books");
        return bookRepository.findAll().stream().map(BookMapper::toResponse).toList();
    }

    public BookResponseDTO insert(BookRequestDTO request) {
        logger.info("Insert a new Book");
        Book Book = BookRepository.save(bookMapper.toEntity(request));
        return bookMapper.toResponse(Book);
    }

    public BookResponseDTO update(Long id, BookRequestDTO request) {
        logger.info("Update an Book");
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new NotFoundBookException("Book not found id: " + id));


        return bookMapper.toResponse(book);
    }

    public void delete(Long id) {
        logger.info("Delete an Book");
        Book Book = bookRepository.findById(id)
                .orElseThrow(() -> new NotFoundBookException("Book not found id: " + id));
        bookRepository.delete(Book);
    }
}
