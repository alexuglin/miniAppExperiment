package ru.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.example.model.enumeration.NameCommand;
import ru.example.model.enumeration.NameKey;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Command {

    private NameCommand name;

    private NameKey key;

    private Contact contact;
}
