package com.br.BetinhoDev.bookStore.config;

import com.br.BetinhoDev.bookStore.entities.Author;
import com.br.BetinhoDev.bookStore.entities.Book;
import com.br.BetinhoDev.bookStore.entities.Category;
import com.br.BetinhoDev.bookStore.entities.Student;
import com.br.BetinhoDev.bookStore.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class StudentTest implements CommandLineRunner {

    private StudentRepository studentRepository;
    private AuthorRepository authorRepository;
    private CategoryRepository categoryRepository;
    private LoanRepository loanRepository;
    private BookRepository bookRepository;

    public StudentTest(StudentRepository studentRepository,AuthorRepository authorRepository,CategoryRepository categoryRepository,LoanRepository loanRepository, BookRepository bookRepository){
        this.studentRepository = studentRepository;
        this.authorRepository = authorRepository;
        this.categoryRepository = categoryRepository;
        this.loanRepository = loanRepository;
        this.bookRepository = bookRepository;
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

        Book b1 = new Book("FranksTein","Um livro sobre um morto vivo",c1);
        Book b2 = new Book("Os tres mosqueteiros", "Um conjunto de 3 homens que lutam pela igualdade",c2);
        Book b3 = new Book("Verity", "Um drama no qual no sabemos a quem é o psicopata",c3);

        c1.getBooks().add(b1);
        c2.getBooks().add(b2);
        c3.getBooks().add(b3);

        categoryRepository.saveAll(Arrays.asList(c1,c2,c3));

        bookRepository.saveAll(Arrays.asList(b1,b2,b3));

        authorRepository.saveAll(Arrays.asList(au1,au2,au3));

        studentRepository.saveAll(Arrays.asList(st1,st2,st3));
    }
}
