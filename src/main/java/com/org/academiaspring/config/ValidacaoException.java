package com.org.academiaspring.config;

public class ValidacaoException extends IllegalArgumentException {
    private static final long serialVersionUID = 1L;

    public ValidacaoException(String mensagem) {
        super(mensagem);
    }
}
