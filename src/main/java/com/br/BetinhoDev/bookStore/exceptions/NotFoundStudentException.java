package com.br.BetinhoDev.bookStore.exceptions;

public class NotFoundStudentException extends RuntimeException {
    public NotFoundStudentException(String message) {
        super(message);
    }
}
