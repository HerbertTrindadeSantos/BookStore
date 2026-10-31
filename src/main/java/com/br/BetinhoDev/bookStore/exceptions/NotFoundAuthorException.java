package com.br.BetinhoDev.bookStore.exceptions;

public class NotFoundAuthorException extends RuntimeException {
    public NotFoundAuthorException(String message) {
        super(message);
    }
}
