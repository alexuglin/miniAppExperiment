package ru.example.model;

import lombok.*;

import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
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

        return !Objects.equals(phoneNumber, contact.phoneNumber) || Objects.equals(email, contact.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName, phoneNumber, email);
    }
}
