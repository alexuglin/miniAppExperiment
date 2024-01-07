package ru.example.exception;

import ru.example.model.Error;

public class InvalidDataException extends RuntimeException {

    public InvalidDataException(Error error) {
        super(error.toString());
    }
}
