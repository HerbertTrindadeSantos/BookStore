package com.br.BetinhoDev.bookStore.controllers;

import com.br.BetinhoDev.bookStore.dtos.LoanRequestDTO;
import com.br.BetinhoDev.bookStore.dtos.LoanResponseDTO;
import com.br.BetinhoDev.bookStore.services.LoanService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/Loans")
public class LoanController {

    private LoanService LoanService;

    public LoanController(LoanService LoanService) {
        this.LoanService = LoanService;
    }

    @GetMapping
    public ResponseEntity<List<LoanResponseDTO>> findAll(){
        List<LoanResponseDTO> Loans = LoanService.findAll();
        return ResponseEntity.ok().body(Loans);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LoanResponseDTO> findById(@PathVariable Long id){
        LoanResponseDTO response = LoanService.findById(id);
        return ResponseEntity.ok().body(response);
    }

    @PostMapping
    public ResponseEntity<LoanResponseDTO> insert(@RequestBody LoanRequestDTO LoanRequest){
        LoanResponseDTO LoanResponseDTO = LoanService.insert(LoanRequest);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(LoanResponseDTO.id()).toUri();
        return ResponseEntity.created(uri).body(LoanResponseDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LoanResponseDTO> update(@PathVariable Long id, @RequestBody LoanRequestDTO request){
        LoanResponseDTO response =LoanService.update(id,request);
        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        LoanService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
