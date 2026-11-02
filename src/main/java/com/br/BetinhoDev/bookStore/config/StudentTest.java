package com.br.BetinhoDev.bookStore.config;

import com.br.BetinhoDev.bookStore.entities.Author;
import com.br.BetinhoDev.bookStore.entities.Category;
import com.br.BetinhoDev.bookStore.entities.Student;
import com.br.BetinhoDev.bookStore.repositories.AuthorRepository;
import com.br.BetinhoDev.bookStore.repositories.CategoryRepository;
import com.br.BetinhoDev.bookStore.repositories.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class StudentTest implements CommandLineRunner {

    private StudentRepository studentRepository;
    private AuthorRepository authorRepository;
    private CategoryRepository categoryRepository;

    public StudentTest(StudentRepository studentRepository,AuthorRepository authorRepository,CategoryRepository categoryRepository){
        this.studentRepository = studentRepository;
        this.authorRepository = authorRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Student st1 = new Student("Tiago","Fonseca");
        Student st2 = new Student("Joao","Augusto");
        Student st3 = new Student("Gabriel","martineli");

        Author au1 = new Author("Ricard","Rasmunsen");
        Author au2 = new Author("Jonathan","Kaileo");
        Author au3 = new Author("Muriles","Gonzalez");

        Category c1 = new Category("Ficcao");
        Category c2 = new Category("Acao");
        Category c3 = new Category("Drama");

        authorRepository.saveAll(Arrays.asList(au1,au2,au3));

        studentRepository.saveAll(Arrays.asList(st1,st2,st3));
        categoryRepository.saveAll(Arrays.asList(c1,c2,c3));
    }
}
