package ru.example.service.actionsCommand;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.example.model.Contact;
import ru.example.repository.Storage;
import ru.example.service.InvalidPhoneNumberCleaner;
import ru.example.service.validation.Validator;

@Component
@RequiredArgsConstructor
public class ContactCreator {

    private final Storage<Contact> contactStorage;

    private final Validator validator;

    private final InvalidPhoneNumberCleaner phoneNumberCleaner;


    public void create(Contact contact) {
        phoneNumberCleaner.invalidDataClean(contact);
        validator.validate(contact);
        save(contact);
    }

    protected void save(Contact contact) {
        if (!contactStorage.contains(contact)) {
            contactStorage.add(contact);
            System.out.println("Контакт добавлен");
            return;
        }
        System.out.println("Контакт уже существует");
    }
}
