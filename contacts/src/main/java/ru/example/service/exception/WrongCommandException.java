package ru.example.service.exception;

public class WrongCommandException extends RuntimeException {

    public WrongCommandException(String message) {
        super(message);
    }
}
