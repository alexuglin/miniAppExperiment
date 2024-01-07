package ru.example.exception;

public class WrongCommandException extends RuntimeException {

    public WrongCommandException(String message) {
        super(message);
    }
}
