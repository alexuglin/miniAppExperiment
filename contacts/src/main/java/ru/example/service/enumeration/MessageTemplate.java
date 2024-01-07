package ru.example.service.enumeration;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum MessageTemplate {

    INVALID_DATA("Не валидное значение в поле %s"),
    EMPTY_DATA("Значение поля %s отсутствует");

    private final String template;
}
