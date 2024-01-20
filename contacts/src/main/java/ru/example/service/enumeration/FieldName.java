package ru.example.service.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum FieldName {

    FULL_NAME("fullname"),
    PHONE_NUMBER("phoneNumber"),
    EMAIL("email");

    private final String name;
}
