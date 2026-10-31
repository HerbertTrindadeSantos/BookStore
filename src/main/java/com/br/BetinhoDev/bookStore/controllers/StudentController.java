package com.br.BetinhoDev.bookStore.controllers;

import com.br.BetinhoDev.bookStore.dtos.StudentRequestDTO;
import com.br.BetinhoDev.bookStore.dtos.StudentResponseDTO;
import com.br.BetinhoDev.bookStore.services.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public ResponseEntity<List<StudentResponseDTO>> findAll(){
        List<StudentResponseDTO> students = studentService.findAll();
        return ResponseEntity.ok().body(students);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentResponseDTO> findById(@PathVariable Long id){
        StudentResponseDTO response = studentService.findById(id);
        return ResponseEntity.ok().body(response);
    }

    @PostMapping
    public ResponseEntity<StudentResponseDTO> insert(@RequestBody StudentRequestDTO studentRequest){
        StudentResponseDTO studentResponseDTO = studentService.insert(studentRequest);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(studentResponseDTO.id()).toUri();
        return ResponseEntity.created(uri).body(studentResponseDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentResponseDTO> update(@PathVariable Long id, @RequestBody StudentRequestDTO request){
        StudentResponseDTO response =studentService.update(id,request);
        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        studentService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
