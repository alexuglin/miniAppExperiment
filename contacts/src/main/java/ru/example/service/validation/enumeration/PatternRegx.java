package ru.example.service.validation.enumeration;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum PatternRegx {

    PHONE("^\\+\\d{9,12}"),
    OTHER_PHONE("^\\+[\\d\\s\\-\\(\\)]{9,20}"),
    PHONE_CLEAN("[\\s\\(\\)\\-]+"),
    FULL_NAME("^[\\wА-ЯЁа-яё][\\wА-ЯЁа-яё\\s\\-]{1,100}"),
    EMAIL("^\\w[\\w\\-_\\.]+@[\\w\\-_\\.]{6,50}");

    private final String expression;
}
