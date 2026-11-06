package com.br.BetinhoDev.bookStore.controllers;

import com.br.BetinhoDev.bookStore.dtos.BookRequestDTO;
import com.br.BetinhoDev.bookStore.dtos.BookResponseDTO;
import com.br.BetinhoDev.bookStore.services.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/Books")
public class BookController {

    private BookService BookService;

    public BookController(BookService BookService) {
        this.BookService = BookService;
    }

    @GetMapping
    public ResponseEntity<List<BookResponseDTO>> findAll(){
        List<BookResponseDTO> Books = BookService.findAll();
        return ResponseEntity.ok().body(Books);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookResponseDTO> findById(@PathVariable Long id){
        BookResponseDTO response = BookService.findById(id);
        return ResponseEntity.ok().body(response);
    }

    @PostMapping
    public ResponseEntity<BookResponseDTO> insert(@RequestBody BookRequestDTO BookRequest){
        BookResponseDTO BookResponseDTO = BookService.insert(BookRequest);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(BookResponseDTO.id()).toUri();
        return ResponseEntity.created(uri).body(BookResponseDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookResponseDTO> update(@PathVariable Long id, @RequestBody BookRequestDTO request){
        BookResponseDTO response =BookService.update(id,request);
        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        BookService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
