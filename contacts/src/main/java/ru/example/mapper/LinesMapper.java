package ru.example.mapper;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import ru.example.exception.InvalidDataException;
import ru.example.exception.WrongCommandException;
import ru.example.model.Command;
import ru.example.model.Contact;
import ru.example.model.enumeration.CommandName;
import ru.example.model.enumeration.KeyName;

import java.util.Set;

@Component
public class LinesMapper {

    public Command convert(String value) {
        if (StringUtils.isBlank(value)) {
            throw new WrongCommandException("Вы не ввели команду, попробуйте еще раз или воспользуйтесь HELP");
        }
        String[] values = value.trim().split("\\s+", 2);
        String[] commandStructure = values[0].split("-+", 2);
        Command command = new Command();
        command.setName(convertCommand(commandStructure[0]));
        if (commandStructure.length == 2) {
            command.setKey(convertKey(commandStructure[1]));
        }
        if (values.length == 2) {
            if (Set.of(CommandName.ADD, CommandName.UPDATE).contains(command.getName())) {
                command.setContact(convertContact(values[1]));
                return command;
            }
            if (StringUtils.isBlank(values[1])) {
                command.setOtherData(values[1]);
            }
        }
        return command;
    }

    public Contact convertContact(String value) {
        if (StringUtils.isBlank(value)) {
            throw new InvalidDataException("Данные отсутствуют, повторите ввод.");
        }
        String[] fields = value.split(";");
        return switch (fields.length) {
            case 1 -> new Contact(fields[0], null, null);
            case 2 -> new Contact(fields[0], fields[1], null);
            default -> new Contact(fields[0], fields[1], fields[3]);
        };
    }

    private <T extends Enum<T>> T convertEnum(Class<T> tClass, String value) throws IllegalArgumentException {
        if (StringUtils.isNotEmpty(value)) {
            return Enum.valueOf(tClass, value.trim().toUpperCase());
        }
        return null;
    }

    private CommandName convertCommand(String commandString) {
        try {
            return convertEnum(CommandName.class, commandString);
        } catch (IllegalArgumentException exception) {
            throw new WrongCommandException(String.format("Не верная команда %s", commandString));
        }
    }

    private KeyName convertKey(String keyString) {
        if (StringUtils.isBlank(keyString)) {
            return null;
        }
        try {
            return convertEnum(KeyName.class, keyString);
        } catch (IllegalArgumentException exception) {
            throw new WrongCommandException(String.format("Не верный ключ или команда, в которой он используется %s", keyString));
        }
    }
}
