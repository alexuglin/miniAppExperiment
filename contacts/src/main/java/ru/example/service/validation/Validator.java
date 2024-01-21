package ru.example.service.validation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.example.exception.InvalidDataException;
import ru.example.model.Contact;
import ru.example.model.Error;

import java.util.Objects;

@Component
@RequiredArgsConstructor
public class Validator {

    private final DataBinderValidator validator;

    public void validate(Contact contact) {
        Error error = validator.validate(contact);
        if (Objects.nonNull(error)) {
            throw new InvalidDataException(error.getMessage());
        }
    }
}
