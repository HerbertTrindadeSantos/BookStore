package com.br.BetinhoDev.bookStore.repositories;

import com.br.BetinhoDev.bookStore.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Long> {
}
