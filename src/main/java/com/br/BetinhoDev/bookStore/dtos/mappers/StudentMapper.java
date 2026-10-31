package com.br.BetinhoDev.bookStore.dtos.mappers;

import com.br.BetinhoDev.bookStore.dtos.StudentResponseDTO;
import com.br.BetinhoDev.bookStore.dtos.StudentRequestDTO;
import com.br.BetinhoDev.bookStore.entities.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper {

    public Student toEntity(StudentRequestDTO request){
        return new Student(request.name(),request.surname());
    }

    public StudentResponseDTO toResponse(Student student){
        return new StudentResponseDTO(
                student.getId(),
                student.getName(),
                student.getSurname());
    }
}
