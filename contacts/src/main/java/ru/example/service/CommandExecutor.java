package ru.example.service;

import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import ru.example.exception.WrongCommandException;
import ru.example.model.Command;
import ru.example.model.Contact;
import ru.example.service.actionsCommand.ContactCreator;
import ru.example.service.actionsCommand.ContactUpdater;
import ru.example.service.validation.DataBinderValidator;

@Component
@AllArgsConstructor
public class CommandExecutor {

    private ContactCreator contactCreator;

    private ContactUpdater contactUpdater;

    private DataBinderValidator validator;

    public void execute(Command command) {
        String error = validator.validate(command);
        if (StringUtils.isNotEmpty(error)) {
            throw new WrongCommandException(error);
        }
        Contact contact = command.getContact();
        switch (command.getName()) {
            case ADD -> contactCreator.create(contact);
            case UPDATE -> contactUpdater.update(contact);
            case LIST -> {
            }
            case FIND -> {
            }
            case DELETE -> {
            }
            case HELP -> {
            }
            case SAVE -> {
            }
            case LOAD -> {
            }
        }
        // todo обработка по командам
    }
}
