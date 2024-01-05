package ru.example.service.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MessageTemplate {

    INVALID_DATA("Не валидное значение в поле %s"),
    EMPTY_DATA("Значение поля %s отсутствует");

    private final String template;
}
