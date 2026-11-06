package com.br.BetinhoDev.bookStore.exceptions;

public class NotFoundLoanException extends RuntimeException {
    public NotFoundLoanException(String message) {
        super(message);
    }
}
