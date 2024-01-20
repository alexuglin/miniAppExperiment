package ru.example.validation;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.DataBinder;
import ru.example.model.Contact;
import ru.example.model.Error;
import ru.example.service.mapper.ErrorMapper;

@Component
@AllArgsConstructor
public class DataBinderValidator {

    private ErrorMapper errorMapper;

    private ContactValidator contactValidator;

    public Error validate(Contact contact) {
        DataBinder binder = new DataBinder(contact);
        binder.setValidator(contactValidator);
        binder.validate();
        return errorMapper.convert(binder.getBindingResult());
    }
}
