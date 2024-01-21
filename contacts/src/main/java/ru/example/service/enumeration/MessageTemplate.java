package ru.example.service.enumeration;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum MessageTemplate {

    INVALID_DATA("Не валидное значение в поле %s"),
    EMPTY_DATA("Значение поля %s отсутствует"),
    WRONG_COMMAND_OR_KEY("Не верный ключ или команда, в которой он используется %s"),
    WRONG_COMMAND("Не верная команда %s"),
    KEY_CANNOT_RESOLVED("Ключ <%s> не используется в %s"),
    DATA_CANNOT_RESOLVED("%s не обрабатываюся в %s"),
    COMMAND_IS_EMPTY("Вы не ввели команду, попробуйте еще раз или воспользуйтесь HELP"),
    INVALID_FORMAT_INPUT("Не верный формат ввода, введите в формате: \"ФИО;телефон;адрес электронной почты\""),
    INPUT_COMMAND("Введите команду, пожалуйста."),
    DATA_IS_EMPTY("Данные отсутствуют, повторите ввод.");

    private final String template;
}
