package ru.example.service.validation;

import org.apache.commons.lang3.StringUtils;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import ru.example.model.Command;
import ru.example.model.enumeration.CommandName;
import ru.example.model.enumeration.KeyName;
import ru.example.service.enumeration.FieldName;
import ru.example.service.enumeration.MessageTemplate;

import java.util.Objects;
import java.util.Set;

@Component
public class CommandValidator implements Validator {

    private static final Set<CommandName> COMMAND_WITHOUT_KEY = Set.of(CommandName.ADD, CommandName.UPDATE, CommandName.SAVE, CommandName.LOAD, CommandName.HELP, CommandName.EXIT);

    private static final Set<CommandName> COMMAND_WITHOUT_DATA = Set.of(CommandName.HELP, CommandName.EXIT);

    @Override
    public boolean supports(@NonNull Class<?> clazz) {
        return Command.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(@NonNull Object target, @NonNull Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, FieldName.NAME.getName(), "name.empty", MessageTemplate.COMMAND_IS_EMPTY.getTemplate());
        Command command = (Command) target;
        if (Objects.isNull(command.getName())) {
            return;
        }
        if (COMMAND_WITHOUT_KEY.contains(command.getName()) && Objects.nonNull(command.getKey())) {
            errors.rejectValue(FieldName.KEY.getName(), getErrorKeyMessage(command));
        }
        if (COMMAND_WITHOUT_DATA.contains(command.getName())) {
            if (Objects.nonNull(command.getContact())) {
                errors.rejectValue(FieldName.CONTACT.getName(), getMessage(MessageTemplate.DATA_CANNOT_RESOLVED, "Данные контакта", command.getName().name()));
            }
            if (StringUtils.isNotBlank(command.getOtherData())) {
                errors.rejectValue(FieldName.OTHER_DATA.getName(), getMessage(MessageTemplate.DATA_CANNOT_RESOLVED, "Введенные данные", command.getName().name()));
            }
            if (Objects.nonNull(command.getKey())) {
                if (command.getName() == CommandName.LIST && !Set.of(KeyName.ALL, KeyName.ERROR).contains(command.getKey())) {
                    errors.rejectValue(FieldName.KEY.getName(), getErrorKeyMessage(command));
                }
                if (Set.of(CommandName.FIND, CommandName.DELETE).contains(command.getName()) && !Set.of(KeyName.NAME, KeyName.PHONE, KeyName.EMAIL).contains(command.getKey())) {
                    errors.rejectValue(FieldName.KEY.getName(), getErrorKeyMessage(command));
                }
            }
        }
    }

    private String getErrorKeyMessage(Command command) {
        return getMessage(MessageTemplate.KEY_CANNOT_RESOLVED, command.getKey().name(), command.getName().name());
    }

    private String getMessage(MessageTemplate template, String firstValue, String secondValue) {
        return String.format(template.getTemplate(), firstValue, secondValue);
    }
}
