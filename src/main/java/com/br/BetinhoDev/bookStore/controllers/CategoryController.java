package com.br.BetinhoDev.bookStore.controllers;


import com.br.BetinhoDev.bookStore.dtos.CategoryRequestDTO;
import com.br.BetinhoDev.bookStore.dtos.CategoryResponseDTO;
import com.br.BetinhoDev.bookStore.services.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public ResponseEntity<List<CategoryResponseDTO>> findAll(){
        List<CategoryResponseDTO> categorys = categoryService.findAll();
        return ResponseEntity.ok().body(categorys);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponseDTO> findById(@PathVariable Long id){
        CategoryResponseDTO response = categoryService.findById(id);
        return ResponseEntity.ok().body(response);
    }

    @PostMapping
    public ResponseEntity<CategoryResponseDTO> insert(@RequestBody CategoryRequestDTO categoryRequest){
        CategoryResponseDTO categoryResponseDTO = categoryService.insert(categoryRequest);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(categoryResponseDTO.id()).toUri();
        return ResponseEntity.created(uri).body(categoryResponseDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryResponseDTO> update(@PathVariable Long id, @RequestBody CategoryRequestDTO request){
        CategoryResponseDTO response =categoryService.update(id,request);
        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        categoryService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
