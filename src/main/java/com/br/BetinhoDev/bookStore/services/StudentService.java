package com.br.BetinhoDev.bookStore.services;

import com.br.BetinhoDev.bookStore.dtos.StudentRequestDTO;
import com.br.BetinhoDev.bookStore.dtos.StudentResponseDTO;
import com.br.BetinhoDev.bookStore.dtos.mappers.StudentMapper;
import com.br.BetinhoDev.bookStore.entities.Student;
import com.br.BetinhoDev.bookStore.exceptions.NotFoundStudentException;
import com.br.BetinhoDev.bookStore.repositories.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private Logger logger = LoggerFactory.getLogger(StudentService.class);

    private StudentRepository studentRepository;
    private StudentMapper studentMapper;

    public StudentService(StudentRepository studentRepository, StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }

    public StudentResponseDTO findById(Long id) {
        logger.info("Find by id Student");
        Student student = studentRepository.findById(id).
                orElseThrow(() -> new NotFoundStudentException("Studant not found id: " + id));
        return studentMapper.toResponse(student);
    }

    public List<StudentResponseDTO> findAll() {
        logger.info("Find all students");
        return studentRepository.findAll().stream().map(studentMapper::toResponse).toList();
    }

    public StudentResponseDTO insert(StudentRequestDTO request) {
        logger.info("Insert a new student");
        Student student = studentRepository.save(studentMapper.toEntity(request));
        return studentMapper.toResponse(student);
    }

    public StudentResponseDTO update(Long id, StudentRequestDTO request) {
        logger.info("Update a new Student");
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new NotFoundStudentException("Studant not found id: " + id));
        student.setName(request.name());
        student.setSurname(request.surname());

        return studentMapper.toResponse(student);
    }

    public void delete(Long id) {
        logger.info("delete a Student");
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new NotFoundStudentException("Studant not found id: " + id));
        studentRepository.delete(student);
    }
}
