package com.br.BetinhoDev.bookStore.repositories;

import com.br.BetinhoDev.bookStore.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
}
