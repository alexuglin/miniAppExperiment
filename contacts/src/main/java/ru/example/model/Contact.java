package ru.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

import java.util.Objects;
import java.util.StringJoiner;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Contact {


    private String fullName;

    private String phoneNumber;

    private String email;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Contact contact)) {
            return false;
        }

        return Objects.equals(phoneNumber, contact.phoneNumber) || Objects.equals(email, contact.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(phoneNumber, email);
    }

    @Override
    public String toString() {
        return new StringJoiner("|")
                .add(fullName)
                .add(StringUtils.defaultIfBlank(phoneNumber, getAbsent("номер телефона")))
                .add(StringUtils.defaultIfBlank(email, getAbsent("адрес электронной почты"))).toString();
    }

    private String getAbsent(String fieldName) {
        return String.format("<%s  отсутствует>", fieldName);
    }
}
