package ru.example.service;

import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import ru.example.model.Command;
import ru.example.model.Contact;
import ru.example.model.Error;
import ru.example.validation.DataBinderValidator;
import ru.example.validation.enumeration.PatternRegx;

@Component
@AllArgsConstructor
public class CommandExecutor {

    private DataBinderValidator validator;
    public void execute(Command command) {
        Contact contact = command.getContact();
        String phone = contact.getPhoneNumber();
        if (StringUtils.isNotBlank(phone)) {
            contact.setPhoneNumber(phone.replaceAll(PatternRegx.PHONE_CLEAN.getExpression(), StringUtils.EMPTY));
        }
        Error errors = validator.validate(contact);
        // todo обработка по командам
    }
}
