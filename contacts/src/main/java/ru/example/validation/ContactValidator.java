package ru.example.validation;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import ru.example.model.Contact;

import static ru.example.validation.enumeration.PatternRegx.EMAIL;
import static ru.example.validation.enumeration.PatternRegx.FULL_NAME;
import static ru.example.validation.enumeration.PatternRegx.PHONE;

@Component
public class ContactValidator implements Validator {
    @Override
    public boolean supports(@NonNull Class clazz) {
        return Contact.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(@NonNull Object target, @NonNull Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "fullName", "name.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phoneNumber", "phoneNumber.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "email.empty");
        Contact contact = (Contact) target;
        if (contact.getFullName().matches(FULL_NAME.getExpression())) {
            errors.rejectValue("fullName", "name.wrong");
        }
        if (contact.getPhoneNumber().matches(PHONE.getExpression())) {
            errors.rejectValue("phoneNumber", "phoneNumber.wrong");
        }
        if (contact.getFullName().matches(EMAIL.getExpression())) {
            errors.rejectValue("email", "email.wrong");
        }
    }

}
