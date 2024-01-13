package ru.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.example.model.enumeration.CommandName;
import ru.example.model.enumeration.KeyName;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Command {

    private CommandName name;

    private KeyName key;

    private Contact contact;

    private String otherData;
}
