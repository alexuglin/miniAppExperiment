package ru.example.service.mapper;

import org.apache.commons.lang3.StringUtils;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import ru.example.model.Contact;
import ru.example.model.Error;

import java.util.stream.Collectors;

@Component
public class ErrorMapper {

    public Error convert(BindingResult result) {
        if (result.getTarget() instanceof Contact) {
            String messages = result.getAllErrors()
                    .stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .collect(Collectors.joining("\\n"));
            return StringUtils.isNotEmpty(messages) ? new Error((Contact) result.getTarget(), messages) : null;
        }
        return null;
    }
}
