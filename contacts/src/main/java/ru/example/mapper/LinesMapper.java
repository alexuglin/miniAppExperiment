package ru.example.mapper;

import org.apache.commons.lang3.StringUtils;
import ru.example.exception.WrongCommandException;
import ru.example.model.Command;
import ru.example.model.Contact;

public class LinesMapper {

    public Command convert(String value) {

        return new Command();
    }

    public Contact convertContact(String value) {

        return new Contact();
    }

    private <T extends Enum<T>> T convertEnum(Class<T> tClass, String value) {
        if (StringUtils.isNotEmpty(value)) {
            try {
                return Enum.valueOf(tClass, value.trim().toUpperCase());
            } catch (IllegalArgumentException e) {
                throw new WrongCommandException(String.format("Не верная команда %s", value));
            }
        }
        return null;
    }
}
