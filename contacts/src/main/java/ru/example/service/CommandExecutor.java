package ru.example.service;

import org.springframework.stereotype.Component;
import ru.example.model.Command;

@Component
public class CommandExecutor {
    public void execute(Command command) {
        //todo валидация, зачистка не валидных данных номера телефона и обработка по командам
    }
}
