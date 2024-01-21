package ru.example.service.validation;

import lombok.RequiredArgsConstructor;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.stereotype.Component;
import org.springframework.validation.DataBinder;
import org.springframework.validation.Validator;
import ru.example.model.Command;
import ru.example.model.Contact;
import ru.example.model.Error;
import ru.example.service.mapper.ErrorMapper;

import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class DataBinderValidator {

    private final ErrorMapper errorMapper;

    private final ContactValidator contactValidator;

    private final CommandValidator commandValidator;

    public Error validate(Contact contact) {
        DataBinder binder = buildBinder(contact, contactValidator);
        return errorMapper.convert(binder.getBindingResult());
    }

    public String validate(Command command) {
        DataBinder binder = buildBinder(command, commandValidator);
        return binder.getBindingResult().getAllErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.joining("\\n"));
    }

    private DataBinder buildBinder(Object object, Validator validator) {
        DataBinder binder = new DataBinder(object);
        binder.setValidator(validator);
        binder.validate();
        return binder;
    }
}
