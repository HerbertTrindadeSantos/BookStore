package com.br.BetinhoDev.bookStore.services;

import com.br.BetinhoDev.bookStore.dtos.LoanRequestDTO;
import com.br.BetinhoDev.bookStore.dtos.LoanResponseDTO;
import com.br.BetinhoDev.bookStore.dtos.mappers.LoanMapper;
import com.br.BetinhoDev.bookStore.entities.Loan;
import com.br.BetinhoDev.bookStore.exceptions.NotFoundLoanException;
import com.br.BetinhoDev.bookStore.repositories.LoanRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanService {

    private static Logger logger = LoggerFactory.getLogger(LoanService.class);

    private LoanRepository LoanRepository;
    private LoanMapper LoanMapper;

    public LoanService(LoanRepository LoanRepository, LoanMapper LoanMapper) {
        this.LoanRepository = LoanRepository;
        this.LoanMapper = LoanMapper;
    }

    public LoanResponseDTO findById(Long id) {
        logger.info("Find by id Loan");
        Loan Loan = LoanRepository.findById(id).
                orElseThrow(() -> new NotFoundLoanException("Studant not found id: " + id));
        return LoanMapper.toResponse(Loan);
    }

    public List<LoanResponseDTO> findAll() {
        logger.info("Find all Loans");
        return LoanRepository.findAll().stream().map(LoanMapper::toResponse).toList();
    }

    public LoanResponseDTO insert(LoanRequestDTO request) {
        logger.info("Insert a new Loan");
        Loan Loan = LoanRepository.save(LoanMapper.toEntity(request));
        return LoanMapper.toResponse(Loan);
    }

    public LoanResponseDTO update(Long id, LoanRequestDTO request) {
        logger.info("Update an Loan");
        Loan Loan = LoanRepository.findById(id)
                .orElseThrow(() -> new NotFoundLoanException("Loan not found id: " + id));
        Loan.setName(request.name());
        Loan.setSurname(request.surname());

        return LoanMapper.toResponse(Loan);
    }

    public void delete(Long id) {
        logger.info("Delete an Loan");
        Loan Loan = LoanRepository.findById(id)
                .orElseThrow(() -> new NotFoundLoanException("Loan not found id: " + id));
        LoanRepository.delete(Loan);
    }
}
