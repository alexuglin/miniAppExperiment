package ru.example.service;

import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import ru.example.model.Contact;
import ru.example.service.validation.enumeration.PatternRegx;

@Component
@NoArgsConstructor
public class InvalidPhoneNumberCleaner {

    public void invalidDataClean(Contact contact) {
        String phone = contact.getPhoneNumber();
        if (StringUtils.isNotBlank(phone)) {
            contact.setPhoneNumber(phone.replaceAll(PatternRegx.PHONE_CLEAN.getExpression(), StringUtils.EMPTY));
        }
    }
}
