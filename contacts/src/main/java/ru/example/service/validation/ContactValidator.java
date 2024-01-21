package ru.example.service.validation;

import org.apache.commons.lang3.StringUtils;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import ru.example.model.Contact;
import ru.example.service.enumeration.FieldName;
import ru.example.service.enumeration.MessageTemplate;
import ru.example.service.validation.enumeration.PatternRegx;

@Component
public class ContactValidator implements Validator {
    @Override
    public boolean supports(@NonNull Class clazz) {
        return Contact.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(@NonNull Object target, @NonNull Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, FieldName.FULL_NAME.getName(), "name.empty", getDataIsEmptyMessage(FieldName.FULL_NAME));
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, FieldName.PHONE_NUMBER.getName(), "phoneNumber.empty", getDataIsEmptyMessage(FieldName.PHONE_NUMBER));
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, FieldName.EMAIL.getName(), "email.empty", getDataIsEmptyMessage(FieldName.EMAIL));
        Contact contact = (Contact) target;
        if (StringUtils.isNotBlank(contact.getFullName()) && contact.getFullName().matches(PatternRegx.FULL_NAME.getExpression())) {
            errors.rejectValue(FieldName.FULL_NAME.getName(), "name.wrong", getInvalidDataMessage(FieldName.FULL_NAME));
        }
        if (StringUtils.isNotBlank(contact.getPhoneNumber()) && contact.getPhoneNumber().matches(PatternRegx.PHONE.getExpression())) {
            errors.rejectValue(FieldName.PHONE_NUMBER.getName(), "phoneNumber.wrong", getInvalidDataMessage(FieldName.PHONE_NUMBER));
        }
        if (StringUtils.isNotBlank(contact.getEmail()) && contact.getEmail().matches(PatternRegx.EMAIL.getExpression())) {
            errors.rejectValue(FieldName.EMAIL.getName(), "email.wrong", getInvalidDataMessage(FieldName.EMAIL));
        }
    }

    private String getDataIsEmptyMessage(FieldName field) {
        return getMessage(MessageTemplate.EMPTY_DATA, field.getName());
    }

    private String getInvalidDataMessage(FieldName field) {
        return getMessage(MessageTemplate.INVALID_DATA, field.getName());
    }

    private String getMessage(MessageTemplate template, String fieldName) {
        return String.format(template.getTemplate(), fieldName);
    }

}
