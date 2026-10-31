package com.br.BetinhoDev.bookStore.controllers;

import com.br.BetinhoDev.bookStore.dtos.AuthorRequestDTO;
import com.br.BetinhoDev.bookStore.dtos.AuthorResponseDTO;
import com.br.BetinhoDev.bookStore.services.AuthorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    private AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public ResponseEntity<List<AuthorResponseDTO>> findAll(){
        List<AuthorResponseDTO> authors = authorService.findAll();
        return ResponseEntity.ok().body(authors);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuthorResponseDTO> findById(@PathVariable Long id){
        AuthorResponseDTO response = authorService.findById(id);
        return ResponseEntity.ok().body(response);
    }

    @PostMapping
    public ResponseEntity<AuthorResponseDTO> insert(@RequestBody AuthorRequestDTO authorRequest){
        AuthorResponseDTO authorResponseDTO = authorService.insert(authorRequest);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(authorResponseDTO.id()).toUri();
        return ResponseEntity.created(uri).body(authorResponseDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AuthorResponseDTO> update(@PathVariable Long id, @RequestBody AuthorRequestDTO request){
        AuthorResponseDTO response =authorService.update(id,request);
        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        authorService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
