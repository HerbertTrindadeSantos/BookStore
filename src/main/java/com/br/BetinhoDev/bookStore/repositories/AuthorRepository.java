package com.br.BetinhoDev.bookStore.repositories;

import com.br.BetinhoDev.bookStore.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author,Long> {
}
