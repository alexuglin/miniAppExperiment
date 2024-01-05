package ru.example.model;

import lombok.AllArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

import java.util.StringJoiner;

@Setter
@AllArgsConstructor
public class Error {

    public Contact contact;

    public String message;

    @Override
    public String toString() {
        return new StringJoiner(StringUtils.LF).add(contact.toString()).add(message).toString();
    }
}
