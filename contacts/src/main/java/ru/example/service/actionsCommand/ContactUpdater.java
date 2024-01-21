package ru.example.service.actionsCommand;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.example.model.Contact;
import ru.example.repository.Storage;
import ru.example.service.InvalidPhoneNumberCleaner;
import ru.example.service.validation.Validator;

@Component
@RequiredArgsConstructor
public class ContactUpdater {

    private final Storage<Contact> contactStorage;

    private final Validator validator;

    private final InvalidPhoneNumberCleaner phoneNumberCleaner;


    public void update(Contact contact) {
        phoneNumberCleaner.invalidDataClean(contact);
        validator.validate(contact);
        save(contact);
    }

    protected void save(Contact contact) {
        if (contactStorage.contains(contact)) {
            System.out.println("Контакт не существует");
        } else {
            contactStorage.remove(contact);
            contactStorage.add(contact);
            System.out.println("Контакт обновлен");
        }
    }
}
