package ru.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

import java.util.Objects;
import java.util.StringJoiner;

@Setter
@AllArgsConstructor
public class Error {

    private Contact contact;

    @Getter
    private String message;

    @Override
    public String toString() {
        return new StringJoiner(StringUtils.LF)
                .add(Objects.isNull(contact) ? null : contact.toString()).add(message).toString();
    }
}
