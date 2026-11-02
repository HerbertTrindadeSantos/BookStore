package com.br.BetinhoDev.bookStore.repositories;

import com.br.BetinhoDev.bookStore.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {
}
