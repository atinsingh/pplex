package com.example.pragraplex.exceptions;

public class MovieNotFoundException extends RuntimeException {
    public MovieNotFoundException(String format) {
        super(format);
    }
}
