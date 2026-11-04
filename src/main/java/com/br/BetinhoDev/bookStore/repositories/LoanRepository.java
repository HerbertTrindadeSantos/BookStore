package com.br.BetinhoDev.bookStore.repositories;

import com.br.BetinhoDev.bookStore.entities.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRepository extends JpaRepository<Loan,Long> {
}
