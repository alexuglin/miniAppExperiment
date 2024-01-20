package ru.example.exception;

import ru.example.service.enumeration.MessageTemplate;

public class InvalidDataException extends RuntimeException {

    public InvalidDataException(String message) {
        super(message);
    }

    public InvalidDataException(MessageTemplate message) {
        super(message.getTemplate());
    }
}
