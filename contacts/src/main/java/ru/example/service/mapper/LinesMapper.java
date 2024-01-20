package ru.example.service.mapper;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import ru.example.exception.InvalidDataException;
import ru.example.exception.WrongCommandException;
import ru.example.model.Command;
import ru.example.model.Contact;
import ru.example.model.enumeration.CommandName;
import ru.example.model.enumeration.KeyName;

import java.util.Set;

import static ru.example.service.enumeration.MessageTemplate.DATA_IS_EMPTY;
import static ru.example.service.enumeration.MessageTemplate.INPUT_COMMAND;
import static ru.example.service.enumeration.MessageTemplate.INVALID_FORMAT_INPUT;
import static ru.example.service.enumeration.MessageTemplate.WRONG_COMMAND;
import static ru.example.service.enumeration.MessageTemplate.WRONG_COMMAND_OR_KEY;

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
            String inputData = values[1];
            if (Set.of(CommandName.ADD, CommandName.UPDATE).contains(command.getName())) {
                command.setContact(convertContact(inputData));
            } else if (!StringUtils.isBlank(inputData)) {
                command.setOtherData(inputData);
            }
        }
        return command;
    }

    public Contact convertContact(String value) {
        if (StringUtils.isBlank(value)) {
            throw new InvalidDataException(DATA_IS_EMPTY);
        }
        String[] fields = value.split(";");
        if (fields.length > 3) {
            throw new InvalidDataException(INVALID_FORMAT_INPUT);
        }
        return switch (fields.length) {
            case 1 -> new Contact(fields[0], null, null);
            case 2 -> new Contact(fields[0], fields[1], null);
            default -> new Contact(fields[0], fields[1], fields[2]);
        };
    }

    private <T extends Enum<T>> T convertEnum(Class<T> tClass, String value) throws IllegalArgumentException {
        if (StringUtils.isEmpty(value)) {
            throw new WrongCommandException(INPUT_COMMAND);
        }
        return Enum.valueOf(tClass, value.trim().toUpperCase());
    }

    private CommandName convertCommand(String commandString) {
        try {
            return convertEnum(CommandName.class, commandString);
        } catch (IllegalArgumentException exception) {
            throw new WrongCommandException(String.format(WRONG_COMMAND.getTemplate(), commandString));
        }
    }

    private KeyName convertKey(String keyString) {
        if (StringUtils.isBlank(keyString)) {
            return null;
        }
        try {
            return convertEnum(KeyName.class, keyString);
        } catch (IllegalArgumentException exception) {
            throw new WrongCommandException(String.format(WRONG_COMMAND_OR_KEY.getTemplate(), keyString));
        }
    }
}
