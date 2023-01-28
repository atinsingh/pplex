package com.example.pragraplex.exceptions;

public class UnsupportedLoginNameException extends RuntimeException{
    public UnsupportedLoginNameException(String message) {
        super(message);
    }
}
