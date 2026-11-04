package com.br.BetinhoDev.bookStore.exceptions;

public class NotFoundBookException extends RuntimeException {
    public NotFoundBookException(String message) {
        super(message);
    }
}
