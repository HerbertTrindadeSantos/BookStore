package com.br.BetinhoDev.bookStore.exceptions;

public class NotFoundCategoryException extends RuntimeException {
    public NotFoundCategoryException(String message) {
        super(message);
    }
}
