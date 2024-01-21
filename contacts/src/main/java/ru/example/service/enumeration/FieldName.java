package ru.example.service.enumeration;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum FieldName {

    FULL_NAME("fullname"),
    PHONE_NUMBER("phoneNumber"),
    EMAIL("email"),
    NAME("name"),
    KEY("key"),
    CONTACT("contact"),
    OTHER_DATA("otherData");


    private final String name;
}
