package com.br.BetinhoDev.bookStore.exceptions;

public class NotFoundStatusException extends RuntimeException {
    public NotFoundStatusException(String message) {
        super(message);
    }
}
