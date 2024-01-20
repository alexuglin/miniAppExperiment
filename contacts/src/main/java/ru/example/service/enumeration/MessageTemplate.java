package ru.example.service.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MessageTemplate {

    INVALID_DATA("Не валидное значение в поле %s"),
    EMPTY_DATA("Значение поля %s отсутствует"),
    WRONG_COMMAND_OR_KEY("Не верный ключ или команда, в которой он используется %s"),
    WRONG_COMMAND("Не верная команда %s"),
    INVALID_FORMAT_INPUT("Не верный формат ввода, введите в формате: \"ФИО;телефон;адрес электронной почты\""),
    INPUT_COMMAND("Введите команду, пожалуйста."),
    DATA_IS_EMPTY("Данные отсутствуют, повторите ввод.");

    private final String template;
}
