package ru.example.exception;

import ru.example.service.enumeration.MessageTemplate;

public class WrongCommandException extends RuntimeException {

    public WrongCommandException(String message) {
        super(message);
    }

    public WrongCommandException(MessageTemplate messageTemplate) {
        super(messageTemplate.getTemplate());
    }
}
