package com.votacion.domain.exception;

public class VotacionNotFoundException extends RuntimeException {
    public VotacionNotFoundException(String mensaje) {
        super(mensaje);
    }
}
