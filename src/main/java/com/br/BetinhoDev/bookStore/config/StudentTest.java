package com.br.BetinhoDev.bookStore.config;

import com.br.BetinhoDev.bookStore.entities.Student;
import com.br.BetinhoDev.bookStore.repositories.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class StudentTest implements CommandLineRunner {

    private StudentRepository studentRepository;

    public StudentTest(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Student st1 = new Student("Tiago","Fonseca");
        Student st2 = new Student("Joao","Augusto");
        Student st3 = new Student("Gabriel","martineli");

        studentRepository.saveAll(Arrays.asList(st1,st2,st3));
    }
}
